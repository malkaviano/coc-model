package com.malk.coc.concepts.attributes

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.malk.coc.concepts.characteristics.{Strength, Size}
import com.malk.coc.concepts.dices.CubeDice
import org.scalamock.scalatest.MockFactory
import com.malk.coc.concepts.dices.TetrahedronDice

trait DamageBonusBehavior extends Matchers with MockFactory {
  this: AnyFunSpec =>
  def calculateDamageBonus(
      str: Strength,
      siz: Size,
      expected: Int,
      rolledD6: Boolean = false,
      rolledD4: Boolean = false
  ): Unit = {
    val rollD6 = mockFunction[(Int, Int), Int]
    val rollD4 = mockFunction[(Int, Int), Int]

    val cubeDice = CubeDice(rollD6)
    val tetrahedronDice = TetrahedronDice(rollD4)


    it(s"should return value equal ${expected}") {
      if (rolledD6) {
        rollD6.expects((1, 6)).atLeastOnce().returning(4)
      } else {
        rollD6.expects((1, 6)).never().returning(4)
      }

      if (rolledD4) {
        rollD4.expects((1, 4)).atLeastOnce().returning(2)
      } else {
        rollD4.expects((1, 4)).never().returning(2)
      }

      val db = DamageBonus(str, siz)(tetrahedronDice, cubeDice)

      db.value shouldBe expected
    }
  }
}

class DamageBonusSpec
    extends AnyFunSpec
    with Matchers
    with DamageBonusBehavior {
  describe("The Damage Bonus") {
    import com.malk.coc.helpers.DiceHelper.implicits._
    val db = DamageBonus(str = Strength(70), siz = Size(70))

    it("should have name Damage Bonus") {
      db.name shouldBe "Damage Bonus"
    }

    it("should have value immutable") {
      val expected = db.value

      for (i <- 1 to 10) {
        db.value shouldBe expected
      }
    }

    it should behave like calculateDamageBonus(Strength(40), Size(60), 0)
    it should behave like calculateDamageBonus(Strength(40), Size(40), -1)
    it should behave like calculateDamageBonus(Strength(30), Size(30), -2)
    it should behave like calculateDamageBonus(Strength(55), Size(70), 2, false, true)
    it should behave like calculateDamageBonus(Strength(80), Size(90), 4, true)
    it should behave like calculateDamageBonus(
      Strength(150),
      Size(120),
      8,
      true
    )
    it should behave like calculateDamageBonus(
      Strength(150),
      Size(170),
      12,
      true
    )
    it should behave like calculateDamageBonus(
      Strength(200),
      Size(200),
      16,
      true
    )
    it should behave like calculateDamageBonus(
      Strength(250),
      Size(250),
      20,
      true
    )
    it should behave like calculateDamageBonus(
      Strength(300),
      Size(250),
      24,
      true
    )
  }
}
