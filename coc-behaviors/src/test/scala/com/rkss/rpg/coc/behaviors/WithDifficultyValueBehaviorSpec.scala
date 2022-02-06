package com.rkss.rpg.coc.behaviors

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
import com.rkss.rpg.coc.behaviors.testing.fakes._
import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.concepts.commons._
import com.rkss.rpg.helpers.dice._
import com.rkss.rpg.coc.behaviors.testing.TestingProps
import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.concepts.characteristic._

final class WithDifficultyValueBehaviorSpec extends AnyFunSpec with Matchers {
  describe("Getting value based on difficulty") {
    describe("Characteristic value") {
      val characteristic = FakeGenericCharacteristic(Constitution, 70)

      characteristic.modify(ValueModification(Constitution, -20))

      it should behave like getDifficultyValue(
        characteristic,
        50,
        RegularDifficulty
      )

      it should behave like getDifficultyValue(
        characteristic,
        25,
        HardDifficulty
      )

      it should behave like getDifficultyValue(
        characteristic,
        10,
        ExtremeDifficulty
      )

      describe("when value is negative") {
        val nonNegativeChar = FakeGenericCharacteristic(Size, 40)

        nonNegativeChar.modify(ValueModification(Size, -50))

        it should behave like getDifficultyValue(
          nonNegativeChar,
          0,
          RegularDifficulty
        )
      }
    }

    describe("Skill value") {
      val skill = FakeSkillImprovable(Garrote, 40, 10)

      skill.markUsedWithSuccess()

      val hundredSidedDice = HundredSidedDice(
        TestingProps.fakeRng(Seq(100))
      )

      val tenSidedDice = TenSidedDice(
        TestingProps.fakeRng(Seq(10))
      )

      skill.improvementCheck(hundredSidedDice, tenSidedDice)

      it should behave like getDifficultyValue(
        skill,
        60,
        RegularDifficulty
      )

      it should behave like getDifficultyValue(
        skill,
        30,
        HardDifficulty
      )

      it should behave like getDifficultyValue(
        skill,
        12,
        ExtremeDifficulty
      )
    }
  }

  private def getDifficultyValue(
      fake: EntityWithDifficultyValue,
      expected: Int,
      difficulty: SkillRollDifficultyLevel
  ): Unit = {
    it(s"return $expected") {
      fake.value(difficulty) shouldBe expected
    }
  }
}
