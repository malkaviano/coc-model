package com.malk.coc.rules

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
import com.malk.coc.concepts.characteristics.Appearance
import com.malk.coc.helpers.DiceHelper

class HumanAgingEffectOnAppearanceSpec extends AnyFunSpec with Matchers {

  val app = Appearance(65)

  describe(s"The Human ${app} affected by Age") {
    describe("when Human Age is bellow 40") {
      val age = DiceHelper.randomAge(15, 39)

      it(s"should return ${app} not affected by Age") {
        HumanAgingEffectOnAppearance.appearance(age, app) shouldBe app
      }
    }

    describe("when Human Age is in the 40's") {
      val age = DiceHelper.randomAge(40, 49)
      val expected = Appearance(60)

      it(s"should return ${expected}") {
        HumanAgingEffectOnAppearance.appearance(age, app) shouldBe expected
      }
    }

    describe("when Human Age is in the 50's") {
      val age = DiceHelper.randomAge(50, 59)
      val expected = Appearance(55)

      it(s"should return ${expected}") {
        HumanAgingEffectOnAppearance.appearance(age, app) shouldBe expected
      }
    }

    describe("when Human Age is in the 60's") {
      val age = DiceHelper.randomAge(60, 69)
      val expected = Appearance(50)

      it(s"should return ${expected}") {
        HumanAgingEffectOnAppearance.appearance(age, app) shouldBe expected
      }
    }

    describe("when Human Age is in the 70's") {
      val age = DiceHelper.randomAge(70, 79)
      val expected = Appearance(45)

      it(s"should return ${expected}") {
        HumanAgingEffectOnAppearance.appearance(age, app) shouldBe expected
      }
    }

    describe("when Human Age is in the 80's") {
      val age = DiceHelper.randomAge(80, 89)
      val expected = Appearance(40)

      it(s"should return ${expected}") {
        HumanAgingEffectOnAppearance.appearance(age, app) shouldBe expected
      }
    }
  }
}
