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
    with BehaveLikeMakingASkillRoll
    with BehaveLikePushingASkillRoll {
  val strength = Strength(50)

  describe("Making a skill roll") {
    it should behave like makingASkillRoll(
      strength,
      Seq(48),
      RegularSuccess,
      RegularDifficulty
    )

    it should behave like makingASkillRoll(
      strength,
      Seq(60),
      Failure,
      RegularDifficulty
    )

    it should behave like makingASkillRoll(
      strength,
      Seq(100),
      Fumble,
      RegularDifficulty
    )

    it should behave like makingASkillRoll(
      strength,
      Seq(20),
      HardSuccess,
      RegularDifficulty
    )

    it should behave like makingASkillRoll(
      strength,
      Seq(6),
      ExtremeSuccess,
      RegularDifficulty
    )

    it should behave like makingASkillRoll(
      strength,
      Seq(1),
      CriticalSuccess,
      RegularDifficulty
    )

    it should behave like makingASkillRoll(
      strength,
      Seq(20),
      RegularSuccess,
      HardDifficulty
    )

    it should behave like makingASkillRoll(
      strength,
      Seq(6),
      HardSuccess,
      HardDifficulty
    )

    it should behave like makingASkillRoll(
      strength,
      Seq(6),
      RegularSuccess,
      ExtremeDifficulty
    )

    it should behave like makingASkillRoll(
      strength,
      Seq(97),
      Failure,
      RegularDifficulty
    )

    it should behave like makingASkillRoll(
      strength,
      Seq(97),
      Fumble,
      HardDifficulty
    )

    it should behave like makingASkillRoll(
      strength,
      Seq(48, 20, 80),
      HardSuccess,
      RegularDifficulty,
      BonusDice(2),
      PenaltyDice(1)
    )

    it should behave like makingASkillRoll(
      strength,
      Seq(48, 100),
      Fumble,
      RegularDifficulty,
      BonusDice(0),
      PenaltyDice(1)
    )
  }

  describe("Pushing a skill roll") {
    Seq(
      (
        SkillRoll(strength, RegularDifficulty, BonusDice(0), PenaltyDice(0))(
          HundredSidedDice(TestingProps.fakeRng(Seq(100, 70)))
        ),
        Fumble,
        None
      ),
      (
        SkillRoll(strength, RegularDifficulty, BonusDice(1), PenaltyDice(0))(
          HundredSidedDice(TestingProps.fakeRng(Seq(10, 70)))
        ),
        RegularSuccess,
        None
      ),
      (
        SkillRoll(strength, RegularDifficulty, BonusDice(0), PenaltyDice(1))(
          HundredSidedDice(TestingProps.fakeRng(Seq(5, 70, 15, 80)))
        ),
        Failure,
        Some(Failure)
      ),
      (
        SkillRoll(strength, HardDifficulty, BonusDice(0), PenaltyDice(0))(
          HundredSidedDice(TestingProps.fakeRng(Seq(70, 15)))
        ),
        Failure,
        Some(RegularSuccess)
      )
    ).foreach(t => {
      val skillRoll = t._1
      val result: SkillRollResult = t._2
      val expected: Option[SkillRollResult] = t._3

      describe(s"when the skill roll is a $result") {
        it should behave like pushingASkillRoll(
          skillRoll,
          expected
        )
      }
    })

    describe(s"when the skill is not pushable") {
      it(s"should return None") {
        val skillRoll = SkillRoll(
          FakeRollableNonPushable(48),
          RegularDifficulty,
          BonusDice(0),
          PenaltyDice(0)
        )(
          HundredSidedDice(TestingProps.fakeRng(Seq(70, 15)))
        )

        skillRoll.push shouldBe None
      }
    }
  }

}

trait BehaveLikeMakingASkillRoll { this: AnyFunSpec with Matchers =>
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

trait BehaveLikePushingASkillRoll { this: AnyFunSpec with Matchers =>
  def pushingASkillRoll(
      skillRoll: SkillRoll,
      result: Option[SkillRollResult]
  ): Unit = {
    it(s"should return $result") {
      skillRoll.push shouldBe result
    }
  }
}
