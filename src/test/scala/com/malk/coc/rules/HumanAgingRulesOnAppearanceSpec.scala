package com.malk.coc.rules

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.malk.coc.concepts.characteristics.Appearance
import com.malk.coc.helpers.DiceHelper

class HumanAgingRulesOnAppearanceSpec extends AnyFunSpec with Matchers {
  import com.malk.coc.helpers.DiceHelper.implicits._

  val app = Appearance(65)

  describe(s"Human Aging on ${app}") {
    describe("when Human Age is bellow 40") {
      val age = DiceHelper.randomAge(15, 39)

      val humanAgingRules = new HumanAgingRules(age)

      it(s"should return ${app} not affected by Age") {
        val result = humanAgingRules on app

        result shouldBe app
      }
    }

    describe("when Human Age is in the 40's") {
      val age = DiceHelper.randomAge(40, 49)

      val humanAgingRules = new HumanAgingRules(age)

      val expected = Appearance(60)

      it(s"should return ${expected}") {
        val result = humanAgingRules on app

        result shouldBe expected
      }
    }

    describe("when Human Age is in the 50's") {
      val age = DiceHelper.randomAge(50, 59)

      val humanAgingRules = new HumanAgingRules(age)

      val expected = Appearance(55)

      it(s"should return ${expected}") {
        val result = humanAgingRules on app

        result shouldBe expected
      }
    }

    describe("when Human Age is in the 60's") {
      val age = DiceHelper.randomAge(60, 69)

      val humanAgingRules = new HumanAgingRules(age)

      val expected = Appearance(50)

      it(s"should return ${expected}") {
        val result = humanAgingRules on app

        result shouldBe expected
      }
    }

    describe("when Human Age is in the 70's") {
      val age = DiceHelper.randomAge(70, 79)

      val humanAgingRules = new HumanAgingRules(age)

      val expected = Appearance(45)

      it(s"should return ${expected}") {
        val result = humanAgingRules on app

        result shouldBe expected
      }
    }

    describe("when Human Age is in the 80's") {
      val age = DiceHelper.randomAge(80, 89)

      val humanAgingRules = new HumanAgingRules(age)

      val expected = Appearance(40)

      it(s"should return ${expected}") {
        val result = humanAgingRules on app

        result shouldBe expected
      }
    }
  }
}
