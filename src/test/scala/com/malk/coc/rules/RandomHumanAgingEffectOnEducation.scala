package com.malk.coc.rules

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.malk.coc.helpers.Dice
import com.malk.coc.concepts.characteristics.Education
import com.malk.coc.rules.RandomHumanAgingEffectOnEducation

class RandomHumanAgingEffectOnEducationSpec extends AnyFunSpec with Matchers {

  val edu = Education(55)

  describe(s"RandomHumanAgingEffectOnEducation - ${edu}") {
    import scala.collection.mutable

    val humanAgingEffect = new RandomHumanAgingEffectOnEducation

    describe("when Human Age is between 20 and 39") {
      it(s"should return ${edu} without improvement") {
        val results = mutable.Set.empty[Education]

        for (n <- 1 to 1000) {
          results add humanAgingEffect.modifiedEducation(Dice.randomAge(20, 39), edu)
        }

        results should contain only (edu)
      }
    }

    describe("when Human Age is bellow 20") {
      it(s"should return ${edu} reduced by 1D10") {
        val results = mutable.Set.empty[Education]

        for (n <- 1 to 1000) {
          results add humanAgingEffect.modifiedEducation(Dice.randomAge(15, 19), edu)
        }

        results should contain theSameElementsAs (-10 to -1).map { i =>
          Education(edu.value + i)
        }
      }
    }

    describe("when Human Age is in the 40's") {
      it(s"should return ${edu} improved by 1D10") {
        val results = mutable.Set.empty[Education]

        for (n <- 1 to 1000) {
          results add humanAgingEffect.modifiedEducation(Dice.randomAge(40, 49), edu)
        }

        results should contain theSameElementsAs (1 to 10).map { i =>
          Education(edu.value + i)
        }
      }
    }

    describe("when Human Age is in the 50's") {
      it(s"should return ${edu} improved by 2D10") {
        val results = mutable.Set.empty[Education]

        for (n <- 1 to 1000) {
          results add humanAgingEffect.modifiedEducation(Dice.randomAge(50, 59), edu)
        }

        results should contain theSameElementsAs (2 to 20).map { i =>
          Education(edu.value + i)
        }
      }
    }

    describe("when Human Age is in the 60's") {
      it(s"should return ${edu} improved by 3D10") {
        val results = mutable.Set.empty[Education]

        for (n <- 1 to 10000) {
          results add humanAgingEffect.modifiedEducation(Dice.randomAge(60, 69), edu)
        }

        results should contain theSameElementsAs (3 to 30).map { i =>
          Education(edu.value + i)
        }
      }
    }

    describe("when Human Age is in the 70's") {
      it(s"should return ${edu} improved by 4D10") {
        val results = mutable.Set.empty[Education]

        for (n <- 1 to 100000) {
          results add humanAgingEffect.modifiedEducation(Dice.randomAge(70, 79), edu)
        }

        results should contain theSameElementsAs (4 to 40).map { i =>
          Education(edu.value + i)
        }
      }
    }

    describe("when Human Age is in the 80's") {
      it(s"should return ${edu} improved by 5D10") {
        val results = mutable.Set.empty[Education]

        for (n <- 1 to 500000) {
          results add humanAgingEffect.modifiedEducation(Dice.randomAge(80, 89), edu)
        }

        results should contain theSameElementsAs (5 to 44).map { i =>
          Education(edu.value + i)
        }
      }
    }

    describe("when Education passes 99") {
      val expected = Education(99)

      it(s"should return ${expected}") {
        val result = (new RandomHumanAgingEffectOnEducation(() => 10)).modifiedEducation(Dice.randomAge(80, 89), edu)

        result shouldBe expected
      }
    }
  }
}
