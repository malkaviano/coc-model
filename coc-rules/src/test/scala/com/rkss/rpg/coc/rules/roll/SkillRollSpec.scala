package com.rkss.rpg.coc.rules.roll

import org.scalatest.matchers.should.Matchers
import org.scalatest.funspec.AnyFunSpec

import scala.collection.mutable.{Seq => MutableSeq}

import com.rkss.rpg.helpers.dice.HundredSidedDice
import com.rkss.rpg.helpers.traits._
import com.rkss.rpg.coc.concepts.roll._
import com.rkss.rpg.coc.foundations.characteristics.Strength

class SkillRollSpec
    extends AnyFunSpec
    with Matchers
    with BehaveLikeMakingARoll {
  val rollable = Strength(50)

  describe("Making a skill roll") {
    it should behave like makingASkillRoll(
      rollable,
      MutableSeq(48),
      RegularSuccess,
      RegularDifficulty
    )

    it should behave like makingASkillRoll(
      rollable,
      MutableSeq(60),
      Failure,
      RegularDifficulty
    )

    it should behave like makingASkillRoll(
      rollable,
      MutableSeq(100),
      Fumble,
      RegularDifficulty
    )

    it should behave like makingASkillRoll(
      rollable,
      MutableSeq(20),
      HardSuccess,
      RegularDifficulty
    )

    it should behave like makingASkillRoll(
      rollable,
      MutableSeq(6),
      ExtremeSuccess,
      RegularDifficulty
    )

    it should behave like makingASkillRoll(
      rollable,
      MutableSeq(1),
      CriticalSuccess,
      RegularDifficulty
    )

    it should behave like makingASkillRoll(
      rollable,
      MutableSeq(20),
      RegularSuccess,
      HardDifficulty
    )

    it should behave like makingASkillRoll(
      rollable,
      MutableSeq(6),
      HardSuccess,
      HardDifficulty
    )

    it should behave like makingASkillRoll(
      rollable,
      MutableSeq(6),
      RegularSuccess,
      ExtremeDifficulty
    )

    it should behave like makingASkillRoll(
      rollable,
      MutableSeq(97),
      Failure,
      RegularDifficulty
    )

    it should behave like makingASkillRoll(
      rollable,
      MutableSeq(97),
      Fumble,
      HardDifficulty
    )
  }
}

trait BehaveLikeMakingARoll { this: AnyFunSpec with Matchers =>
  def makingASkillRoll(
      rollable: Rollable,
      diceResults: MutableSeq[Int],
      result: SkillRollResult,
      difficulty: SkillRollDifficultyLevel,
      bonusDice: BonusDice = BonusDice(0),
      penaltyDice: PenaltyDice = PenaltyDice(0)
  ): Unit = {
    val rollStreak = diceResults.mkString(", ")

    val fakeRng: DiceRange => DiceResult = _ => {
      val elem = diceResults.head

      diceResults.drop(1)

      FakeDiceResult(elem)
    }

    val mockedDice = HundredSidedDice(fakeRng)

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

final case class FakeDiceResult(override val value: Int) extends DiceResult
