package com.malk.coc.rules

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
import com.malk.coc.concepts.characteristics.Strength
import com.malk.coc.concepts.characteristics.Constitution
import com.malk.coc.concepts.characteristics.Dexterity
import com.malk.coc.concepts.characteristics.Size
import com.malk.coc.abstractions.Body
import com.malk.coc.helpers.DiceHelper

class HumanAgingRulesOnBodySpec extends AnyFunSpec with Matchers {
  import com.malk.coc.helpers.DiceHelper.implicits._

  val str = Strength(50)
  val con = Constitution(50)
  val dex = Dexterity(50)
  val siz = Size(50)
  val body = Body(str, con, dex, siz)

  describe(s"Human Aging on ${body}") {
    describe("when age is inferior to 20") {
      val age = DiceHelper.randomAge(15, 19)

      val humanAging = new HumanAgingRules(age)

      val expected = Body(Strength(47), con, dex, Size(48))

      it(s"should return ${expected}") {
        val result = humanAging on body

        result shouldBe expected
      }
    }

    describe("when age is 20 to 39 years old") {
      val age = DiceHelper.randomAge(20, 39)

      val humanAging = new HumanAgingRules(age)

      val expected = Body(str, con, dex, siz)

      it(s"should return ${expected}") {
        val result = humanAging on body

        result shouldBe expected
      }
    }

    describe("when age is 40 to 49 years old") {
      val age = DiceHelper.randomAge(40, 49)

      val humanAging = new HumanAgingRules(age)

      val expected = Body(Strength(48), Constitution(48), Dexterity(49), siz)

      it(s"should return ${expected}") {
        val result = humanAging on body

        result shouldBe expected
      }
    }

    describe("when age is 50 to 59 years old") {
      val age = DiceHelper.randomAge(50, 59)

      val humanAging = new HumanAgingRules(age)

      val expected = Body(Strength(47), Constitution(47), Dexterity(46), siz)

      it(s"should return ${expected}") {
        val result = humanAging on body

        result shouldBe expected
      }
    }

    describe("when age is 60 to 69 years old") {
      val age = DiceHelper.randomAge(60, 69)

      val humanAging = new HumanAgingRules(age)

      val expected = Body(Strength(44), Constitution(44), Dexterity(42), siz)

      it(s"should return ${expected}") {
        val result = humanAging on body

        result shouldBe expected
      }
    }

    describe("when age is 70 to 79 years old") {
      val age = DiceHelper.randomAge(70, 79)

      val humanAging = new HumanAgingRules(age)

      val expected = Body(Strength(37), Constitution(37), Dexterity(36), siz)

      it(s"should return ${expected}") {
        val result = humanAging on body

        result shouldBe expected
      }
    }

    describe("when age superior to 80 years old") {
      val age = DiceHelper.randomAge(80, 89)

      val expected = Body(Strength(24), Constitution(24), Dexterity(22), siz)

      val humanAging = new HumanAgingRules(age)

      it(s"should return ${expected}") {
        val result = humanAging on body

        result shouldBe expected
      }
    }
  }
}
