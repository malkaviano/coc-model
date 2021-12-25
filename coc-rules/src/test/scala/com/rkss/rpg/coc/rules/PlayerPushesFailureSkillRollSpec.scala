package com.rkss.rpg.coc.rules

import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.GivenWhenThen
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.coc.rules._
import com.rkss.rpg.helpers.dice.HundredSidedDice
import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.props.scenarios._
import com.rkss.rpg.coc.props.TestingProps
import com.rkss.rpg.coc.props.fakes._

class PlayerPushesSkillRollSpec
    extends AnyFeatureSpec
    with GivenWhenThen
    with Matchers {
  info("As a player")
  info("After failing a skill roll")
  info("But it was not a Fumble")
  info("And the skill is pushable")
  info("I want to push the failed skill roll")
  info("So that I can try to succeeded the failed skill roll")

  Feature("Player pushes a failed skill roll") {
    Seq(
      PushedSkillRollScenario(
        FakeCharacteristic(47, 23, 9),
        Seq(90),
        Seq(10),
        HardSuccess,
        Option.empty[SkillRollDifficultyLevel],
        Option.empty[BonusDice],
        Option.empty[PenaltyDice],
        FakeDiceResult(10)
      ),
      PushedSkillRollScenario(
        FakeCharacteristic(47, 23, 9),
        Seq(90),
        Seq(10),
        Failure,
        Option(ExtremeDifficulty),
        Option.empty[BonusDice],
        Option.empty[PenaltyDice],
        FakeDiceResult(10)
      ),
      PushedSkillRollScenario(
        FakeCharacteristic(47, 23, 9),
        Seq(90),
        Seq(20, 4),
        ExtremeSuccess,
        Option(HardDifficulty),
        Option(BonusDice(1)),
        Option.empty[PenaltyDice],
        FakeDiceResult(4)
      ),
      PushedSkillRollScenario(
        FakeCharacteristic(47, 23, 9),
        Seq(90),
        Seq(20, 4, 100),
        Fumble,
        Option(ExtremeDifficulty),
        Option.empty[BonusDice],
        Option(PenaltyDice(2)),
        FakeDiceResult(100)
      )
    ).foreach {
      case PushedSkillRollScenario(
            rollable,
            failedRolls,
            pushedRolls,
            result,
            difficulty,
            bonusDice,
            penaltyDice,
            chosenRoll
          ) => {
        Scenario(s"The pushed skill roll is a $result") {
          Given("a skill roll failed")
          val failureSkillRoll = SkillRoll(
            FakeCharacteristic(47, 23, 9)
          )(HundredSidedDice(TestingProps.fakeRng(failedRolls)))
          val pushedDifficulty =
            difficulty.getOrElse(failureSkillRoll.difficulty)
          And(s"the pushed skill roll difficulty is $pushedDifficulty")
          val pushedBonusDice = bonusDice.getOrElse(failureSkillRoll.bonusDice)
          And(s"the bonus dice is ${pushedBonusDice.value}")
          val pushedPenaltyDice =
            penaltyDice.getOrElse(failureSkillRoll.penaltyDice)
          And(s"the penalty dice is ${pushedPenaltyDice.value}")
          And(
            s"the maximum value to pass the pushed skill roll is ${rollable.value(pushedDifficulty)}"
          )

          When(
            s"the player push the skill roll with ${pushedRolls.mkString(", ")}"
          )
          val pushedSkillRoll = PushedSkillRoll(
            failureSkillRoll,
            difficulty,
            bonusDice,
            penaltyDice
          )(
            HundredSidedDice(TestingProps.fakeRng(pushedRolls))
          )

          Then(s"the pushed skill roll is a $result")
          val expected =
            SkillRolled(
              rollable,
              pushedDifficulty,
              pushedBonusDice,
              pushedPenaltyDice,
              result,
              chosenRoll
            )

          pushedSkillRoll.result shouldBe Option(expected)
        }
      }
    }
  }
}
