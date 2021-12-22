package com.rkss.rpg.coc.rules.roll

import org.scalatest.matchers.should.Matchers
import org.scalatest.funspec.AnyFunSpec

import com.rkss.rpg.helpers.dice.HundredSidedDice
import com.rkss.rpg.coc.concepts.roll._
import com.rkss.rpg.coc.foundations.characteristics.Strength
import com.rkss.testing.props._

class SkillRollSpec
    extends AnyFunSpec
    with Matchers
    with BehaveLikeMakingARoll {
  val rollable = Strength(50)

  describe("Making a skill roll") {
    it should behave like makingASkillRoll(
      rollable,
      Seq(48),
      RegularSuccess,
      RegularDifficulty
    )

    it should behave like makingASkillRoll(
      rollable,
      Seq(60),
      Failure,
      RegularDifficulty
    )

    it should behave like makingASkillRoll(
      rollable,
      Seq(100),
      Fumble,
      RegularDifficulty
    )

    it should behave like makingASkillRoll(
      rollable,
      Seq(20),
      HardSuccess,
      RegularDifficulty
    )

    it should behave like makingASkillRoll(
      rollable,
      Seq(6),
      ExtremeSuccess,
      RegularDifficulty
    )

    it should behave like makingASkillRoll(
      rollable,
      Seq(1),
      CriticalSuccess,
      RegularDifficulty
    )

    it should behave like makingASkillRoll(
      rollable,
      Seq(20),
      RegularSuccess,
      HardDifficulty
    )

    it should behave like makingASkillRoll(
      rollable,
      Seq(6),
      HardSuccess,
      HardDifficulty
    )

    it should behave like makingASkillRoll(
      rollable,
      Seq(6),
      RegularSuccess,
      ExtremeDifficulty
    )

    it should behave like makingASkillRoll(
      rollable,
      Seq(97),
      Failure,
      RegularDifficulty
    )

    it should behave like makingASkillRoll(
      rollable,
      Seq(97),
      Fumble,
      HardDifficulty
    )

    it should behave like makingASkillRoll(
      rollable,
      Seq(48, 20, 80),
      HardSuccess,
      RegularDifficulty,
      BonusDice(2),
      PenaltyDice(1)
    )

    it should behave like makingASkillRoll(
      rollable,
      Seq(48, 100),
      Fumble,
      RegularDifficulty,
      BonusDice(0),
      PenaltyDice(1)
    )
  }
}

trait BehaveLikeMakingARoll { this: AnyFunSpec with Matchers =>
  def makingASkillRoll(
      rollable: Rollable,
      diceResults: Seq[Int],
      result: SkillRollResult,
      difficulty: SkillRollDifficultyLevel,
      bonusDice: BonusDice = BonusDice(0),
      penaltyDice: PenaltyDice = PenaltyDice(0)
  ): Unit = {
    val rollStreak = diceResults.mkString(", ")

    val mockedDice = HundredSidedDice(TestingProps.fakeRng(diceResults.toSeq))

    val skillRoll =
      SkillRoll(rollable, difficulty, bonusDice, penaltyDice)(mockedDice)

    describe(s"when difficulty is $difficulty") {
      describe(
        s"when tested skill has regular value ${rollable.value(difficulty)}"
      ) {
        describe(s"when rolling a $rollStreak") {
          it(s"should return $result") {
            skillRoll.result shouldBe result
          }
        }
      }
    }
  }
}
