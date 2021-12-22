package com.rkss.rpg.coc.rules.roll

import org.scalatest.matchers.should.Matchers
import org.scalatest.funspec.AnyFunSpec

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
      48,
      RegularSuccess,
      RegularDifficulty
    )

    it should behave like makingASkillRoll(
      rollable,
      60,
      Failure,
      RegularDifficulty
    )

    it should behave like makingASkillRoll(
      rollable,
      100,
      Fumble,
      RegularDifficulty
    )

    it should behave like makingASkillRoll(
      rollable,
      20,
      HardSuccess,
      RegularDifficulty
    )

    it should behave like makingASkillRoll(
      rollable,
      6,
      ExtremeSuccess,
      RegularDifficulty
    )

    it should behave like makingASkillRoll(
      rollable,
      1,
      CriticalSuccess,
      RegularDifficulty
    )

    it should behave like makingASkillRoll(
      rollable,
      20,
      RegularSuccess,
      HardDifficulty
    )

    it should behave like makingASkillRoll(
      rollable,
      6,
      HardSuccess,
      HardDifficulty
    )

    it should behave like makingASkillRoll(
      rollable,
      6,
      RegularSuccess,
      ExtremeDifficulty
    )

    it should behave like makingASkillRoll(
      rollable,
      97,
      Failure,
      RegularDifficulty
    )

    it should behave like makingASkillRoll(
      rollable,
      97,
      Fumble,
      HardDifficulty
    )
  }
}

trait BehaveLikeMakingARoll { this: AnyFunSpec with Matchers =>
  def makingASkillRoll(
      rollable: Rollable,
      diceResult: Int,
      result: SkillRollResult,
      difficulty: SkillRollDifficultyLevel
  ): Unit = {
    val fakeRng: DiceRange => DiceResult = _ => FakeDiceResult(diceResult)

    val mockedDice = HundredSidedDice(fakeRng)

    val skillRoll = SkillRoll(rollable, difficulty)(mockedDice)

    describe(s"when difficulty is $difficulty") {
      describe(
        s"when tested skill has regular value ${rollable.value(difficulty)}"
      ) {
        describe(s"when rolling a $diceResult") {
          it(s"should return $result") {
            skillRoll.result shouldBe result
          }
        }
      }
    }
  }
}

final case class FakeDiceResult(override val value: Int) extends DiceResult
