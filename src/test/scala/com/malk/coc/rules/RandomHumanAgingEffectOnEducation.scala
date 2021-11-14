package com.malk.coc.rules

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.malk.coc.helpers.DiceHelper
import com.malk.coc.concepts.characteristics.Education
import com.malk.coc.rules.RandomHumanAgingEffectOnEducation
import com.malk.coc.concepts.dices.DeltohedronDice

class RandomHumanAgingEffectOnEducationSpec extends AnyFunSpec with Matchers {
  val edu = Education(55)
  val diceResult = 9
  val loadedDice = DeltohedronDice((t: (Int, Int)) => diceResult)

  describe(s"RandomHumanAgingEffectOnEducation - ${edu}") {
    val humanAgingEffect = new RandomHumanAgingEffectOnEducation(loadedDice)

    describe("when Human Age is between 20 and 39") {
      it(s"should return ${edu} without improvement") {
        val result = humanAgingEffect.modifiedEducation(
          DiceHelper.randomAge(20, 39),
          edu
        )

        result shouldBe edu
      }
    }

    describe("when Human Age is bellow 20") {
      it(s"should return ${edu - diceResult} reduced by 1D10") {
        val result = humanAgingEffect.modifiedEducation(
          DiceHelper.randomAge(15, 19),
          edu
        )

        result shouldBe edu - diceResult
      }
    }

    describe("when Human Age is in the 40's") {
      it(s"should return ${edu + diceResult} improved by 1D10") {
        val result = humanAgingEffect.modifiedEducation(
          DiceHelper.randomAge(40, 49),
          edu
        )

        result shouldBe edu + diceResult
      }
    }

    describe("when Human Age is in the 50's") {
      val expected = edu + 2 * diceResult

      it(s"should return ${expected} improved by 2D10") {
        val result = humanAgingEffect.modifiedEducation(
          DiceHelper.randomAge(50, 59),
          edu
        )

        result shouldBe expected
      }
    }

    describe("when Human Age is in the 60's") {
      val expected = edu + 3 * diceResult

      it(s"should return ${expected} improved by 3D10") {
        val result = humanAgingEffect.modifiedEducation(
          DiceHelper.randomAge(60, 69),
          edu
        )

        result shouldBe expected
      }
    }

    describe("when Human Age is in the 70's") {
      val expected = edu + 4 * diceResult

      it(s"should return ${expected} improved by 4D10") {
        val result = humanAgingEffect.modifiedEducation(
          DiceHelper.randomAge(70, 79),
          edu
        )

        result shouldBe expected
      }
    }

    describe("when Human Age is in the 80's") {
      val expected = Education(99)

      it(s"should return ${expected} improved by 5D10") {
        val result = humanAgingEffect.modifiedEducation(
          DiceHelper.randomAge(80, 89),
          edu
        )

        result shouldBe expected
      }
    }
  }
}
