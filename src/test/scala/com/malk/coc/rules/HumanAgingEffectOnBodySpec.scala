package com.malk.coc.rules

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
import com.malk.coc.helpers.Dice
import com.malk.coc.concepts.characteristics.Strength
import com.malk.coc.concepts.characteristics.Constitution
import com.malk.coc.concepts.characteristics.Dexterity
import com.malk.coc.concepts.characteristics.Size

class HumanAgingEffectOnBodySpec extends AnyFunSpec with Matchers {
  describe("Age effect on physical characteristics") {
    val str = Strength(50)
    val con = Constitution(50)
    val dex = Dexterity(50)
    val siz = Size(50)

    describe("when age is inferior to 20") {
      val age = Dice.randomAge(15, 19)
      val expected = (Strength(47), con, dex, Size(48))

      it("should deduct 5 points among STR and SIZ") {
        val result = HumanAgingEffectOnBody.modifiedPhysical(age, str, con, dex, siz)

        result shouldBe expected
      }
    }

    describe("when age is 20 to 39 years old") {
      val age = Dice.randomAge(20, 39)
      val expected = (str, con, dex, siz)

      it("should return same stats") {
        val result = HumanAgingEffectOnBody.modifiedPhysical(age, str, con, dex, siz)

        result shouldBe expected
      }
    }

    describe("when age is 40 to 49 years old") {
      val age = Dice.randomAge(40, 49)
      val expected = (Strength(48), Constitution(48), Dexterity(49), siz)

      it("should deduct 5 points among STR, CON or DEX") {
        val result = HumanAgingEffectOnBody.modifiedPhysical(age, str, con, dex, siz)

        result shouldBe expected
      }
    }

    describe("when age is 50 to 59 years old") {
      val age = Dice.randomAge(50, 59)
      val expected = (Strength(47), Constitution(47), Dexterity(46), siz)

      it("should deduct 10 points among STR, CON or DEX") {
        val result = HumanAgingEffectOnBody.modifiedPhysical(age, str, con, dex, siz)

        result shouldBe expected
      }
    }

    describe("when age is 60 to 69 years old") {
      val age = Dice.randomAge(60, 69)
      val expected = (Strength(44), Constitution(44), Dexterity(42), siz)

      it("should deduct 20 points among STR, CON or DEX") {
        val result = HumanAgingEffectOnBody.modifiedPhysical(age, str, con, dex, siz)

        result shouldBe expected
      }
    }

    describe("when age is 70 to 79 years old") {
      val age = Dice.randomAge(70, 79)
      val expected = (Strength(37), Constitution(37), Dexterity(36), siz)

      it("should deduct 40 points among STR, CON or DEX") {
        val result = HumanAgingEffectOnBody.modifiedPhysical(age, str, con, dex, siz)

        result shouldBe expected
      }
    }

    describe("when age superior to 80 years old") {
      val age = Dice.randomAge(80, 89)
      val expected = (Strength(24), Constitution(24), Dexterity(22), siz)

      it("should deduct 80 points among STR, CON or DEX") {
        val result = HumanAgingEffectOnBody.modifiedPhysical(age, str, con, dex, siz)

        result shouldBe expected
      }
    }
  }
}