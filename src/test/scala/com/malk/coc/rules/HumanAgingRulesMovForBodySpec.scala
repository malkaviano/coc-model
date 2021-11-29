package com.malk.coc.rules

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.malk.coc.helpers.DiceHelper
import com.malk.coc.abstractions.Body
import com.malk.coc.concepts.characteristics.Strength
import com.malk.coc.concepts.characteristics.Dexterity
import com.malk.coc.concepts.characteristics.Size
import com.malk.coc.concepts.characteristics.Constitution
import com.malk.coc.concepts.attributes.MovementRate
import com.malk.coc.concepts.attributes.Age

import com.malk.coc.helpers.DiceHelper.implicits._

trait MovementRateBehavior extends Matchers { this: AnyFunSpec =>
  def calculateMovementRate(
      age: Age,
      body: Body,
      expected: MovementRate
  ): Unit = {
    describe(s"when ${body}") {
      it(s"should return ${expected}") {
        val humanAgingRules = new HumanAgingRules(age)

        val result =  humanAgingRules movFor body

        result shouldBe expected
      }
    }
  }
}

class HumanAgingRulesMovForBodySpec
    extends AnyFunSpec
    with Matchers
    with MovementRateBehavior {
  describe("Human MOV calculation") {
    describe("Human age is bellow 40") {
      val age = DiceHelper.randomAge(15, 39)

      suit(age, 0)
    }

    describe("Human age is in the 40s") {
      val age = DiceHelper.randomAge(40, 49)

      describe("deduct MOV by 1") {
        suit(age, 1)
      }
    }

    describe("Human age is in the 50s") {
      val age = DiceHelper.randomAge(50, 59)

      describe("deduct MOV by 2") {
        suit(age, 2)
      }
    }

    describe("Human age is in the 60s") {
      val age = DiceHelper.randomAge(60, 69)

      describe("deduct MOV by 3") {
        suit(age, 3)
      }
    }

    describe("Human age is in the 70s") {
      val age = DiceHelper.randomAge(70, 79)

      describe("deduct MOV by 4") {
        suit(age, 4)
      }
    }

    describe("Human age is in the 80s") {
      val age = DiceHelper.randomAge(80, 89)

      describe("deduct MOV by 5") {
        suit(age, 5)
      }
    }

  }

  private def check(
      age: Age,
      body: Body,
      expected: MovementRate
  ) = {
    it should behave like calculateMovementRate(
      age,
      body,
      expected
    )
  }

  private def suit(age: Age, reduction: Int) = {
    val con = Constitution(47)

    Seq(
      (
        Body(Strength(60), con, Dexterity(70), Size(50)),
        MovementRate(9 - reduction)
      ),
      (
        Body(Strength(24), con, Dexterity(48), Size(50)),
        MovementRate(7 - reduction)
      ),
      (
        Body(Strength(50), con, Dexterity(50), Size(50)),
        MovementRate(8 - reduction)
      ),
      (
        Body(Strength(40), con, Dexterity(60), Size(50)),
        MovementRate(8 - reduction)
      ),
      (
        Body(Strength(55), con, Dexterity(30), Size(50)),
        MovementRate(8 - reduction)
      ),
      (
        Body(Strength(50), con, Dexterity(30), Size(50)),
        MovementRate(8 - reduction)
      ),
      (
        Body(Strength(40), con, Dexterity(50), Size(50)),
        MovementRate(8 - reduction)
      )
    ).foreach {
      case (body, expected) => {
        check(age, body, expected)
      }
    }
  }
}
