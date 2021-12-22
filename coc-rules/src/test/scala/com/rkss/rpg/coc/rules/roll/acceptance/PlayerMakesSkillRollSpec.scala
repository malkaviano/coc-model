package com.rkss.rpg.coc.rules.roll.features

import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.GivenWhenThen
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.coc.foundations.characteristics.Strength
import com.rkss.rpg.helpers.dice.HundredSidedDice
import com.rkss.rpg.coc.concepts.roll.RegularSuccess
import com.rkss.rpg.coc.rules.roll.SkillRoll
import com.rkss.rpg.coc.concepts.roll.RegularDifficulty
import com.rkss.rpg.coc.concepts.roll.BonusDice
import com.rkss.rpg.coc.concepts.roll.PenaltyDice
import com.rkss.testing.props._
import com.rkss.rpg.coc.concepts.roll.CriticalSuccess

class PlayerMakesSkillRollSpec
    extends AnyFeatureSpec
    with GivenWhenThen
    with Matchers {
  info("As a player")
  info("I want to make a skill roll")
  info("So that I can check my success during an action")

  Feature("Player makes a skill roll") {
    Seq(
      SkillRollScenario(
        60,
        RegularDifficulty,
        BonusDice(0),
        PenaltyDice(0),
        RegularSuccess,
        Seq(50)
      ),
      SkillRollScenario(
        80,
        RegularDifficulty,
        BonusDice(1),
        PenaltyDice(0),
        CriticalSuccess,
        Seq(98, 1)
      )
    ).foreach {
      case SkillRollScenario(value, difficulty, bonusDice, penaltyDice, result, rolled) => {
        Scenario(s"The skill roll is a $result") {
          Given(s"My Strength is $value")
          val strength = Strength(value)

          And(s"The difficulty is $difficulty")
          And(s"The bonus dice is ${bonusDice.value}")
          And(s"The penalty dice is ${penaltyDice.value}")

          When(s"I roll a ${rolled.mkString(", ")} in the hundred dice")
          val hundredSidedDice =
            HundredSidedDice(TestingProps.fakeRng(rolled))

          val skillRoll = SkillRoll(strength, difficulty, bonusDice, penaltyDice)(
            hundredSidedDice
          )

          Then(s"The result should be $result")
          skillRoll.result shouldBe result
        }
      }
    }
  }
}