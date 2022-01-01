package com.rkss.rpg.coc.rules

import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.GivenWhenThen
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.helpers.dice.HundredSidedDice
import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.rules.testing.scenarios._
import com.rkss.rpg.coc.rules.testing._
import com.rkss.rpg.coc.rules.testing.fakes._

class PlayerMakesSkillRollSpec
    extends AnyFeatureSpec
    with GivenWhenThen
    with Matchers {
  info("As a player")
  info("I want to make a skill roll")
  info("So that I can check if it was succeeded")

  Feature("Player makes a skill roll") {
    Seq(
      SkillRollScenario(
        60,
        30,
        12,
        RegularDifficulty,
        BonusDice(0),
        PenaltyDice(0),
        RegularSuccess,
        Seq(50),
        FakeDiceResult(50)
      ),
      SkillRollScenario(
        80,
        40,
        16,
        RegularDifficulty,
        BonusDice(1),
        PenaltyDice(0),
        CriticalSuccess,
        Seq(98, 1),
        FakeDiceResult(1)
      ),
      SkillRollScenario(
        80,
        40,
        16,
        RegularDifficulty,
        BonusDice(1),
        PenaltyDice(2),
        Failure,
        Seq(98, 1),
        FakeDiceResult(98)
      )
    ).foreach {
      case SkillRollScenario(
            regular,
            hard,
            extreme,
            difficulty,
            bonusDice,
            penaltyDice,
            result,
            rolled,
            chosenRoll
          ) => {
        Scenario(s"The skill roll is a $result") {
          Given(s"My Skill / Characteristic value is $regular")
          val someRollable = FakeCharacteristic(regular)

          And(s"The difficulty is $difficulty")
          And(s"The bonus dice is ${bonusDice.value}")
          And(s"The penalty dice is ${penaltyDice.value}")

          When(s"I roll a ${rolled.mkString(", ")} in the hundred dice")
          val hundredSidedDice =
            HundredSidedDice(TestingProps.fakeRng(rolled))

          val skillRoll =
            SkillRoll(someRollable, difficulty, bonusDice, penaltyDice)(
              hundredSidedDice
            )

          Then(s"The result should be $result")
          val expected =
            SkillRolled(
              someRollable,
              difficulty,
              bonusDice,
              penaltyDice,
              result,
              chosenRoll
            )

          skillRoll.result shouldBe expected
        }
      }
    }
  }
}
