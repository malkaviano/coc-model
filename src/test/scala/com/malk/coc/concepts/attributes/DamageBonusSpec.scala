package com.malk.coc.concepts.attributes

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.malk.coc.concepts.characteristics.{Strength, Size}
import com.malk.coc.abstractions.dices.SixSidedDice
import org.scalamock.scalatest.MockFactory
import com.malk.coc.abstractions.dices.FourSidedDice
import com.malk.coc.concepts.characteristics.Constitution
import com.malk.coc.concepts.characteristics.Dexterity
import com.malk.coc.abstractions.Body
import com.malk.coc.abstractions.dices.DiceRange

trait DamageBonusBehavior extends Matchers with MockFactory {
  this: AnyFunSpec =>
  def calculateDamageBonus(
      body: Body,
      expected: Int,
      rolledD6: Boolean = false,
      rolledD4: Boolean = false
  ): Unit = {
    val rollD6 = mockFunction[DiceRange, Int]
    val rollD4 = mockFunction[DiceRange, Int]

    val sixSidedDice = SixSidedDice(rollD6)
    val fourSidedDice = FourSidedDice(rollD4)

    it(s"should return value equal ${expected}") {
      if (rolledD6) {
        rollD6.expects(DiceRange(1, 6)).atLeastOnce().returning(4)
      } else {
        rollD6.expects(DiceRange(1, 6)).never().returning(4)
      }

      if (rolledD4) {
        rollD4.expects(DiceRange(1, 4)).atLeastOnce().returning(2)
      } else {
        rollD4.expects(DiceRange(1, 4)).never().returning(2)
      }

      val db = DamageBonus(body)(fourSidedDice, sixSidedDice)

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

    val con = Constitution(55)
    val dex = Dexterity(65)
    val db = DamageBonus(Body(Strength(70), con, dex, Size(70)))

    it("should have name Damage Bonus") {
      db.name shouldBe "Damage Bonus"
    }

    it("should have value immutable") {
      val expected = db.value

      for (i <- 1 to 10) {
        db.value shouldBe expected
      }
    }

    it should behave like calculateDamageBonus(
      Body(Strength(40), con, dex, Size(60)),
      0
    )
    it should behave like calculateDamageBonus(
      Body(Strength(40), con, dex, Size(40)),
      -1
    )
    it should behave like calculateDamageBonus(
      Body(Strength(30), con, dex, Size(30)),
      -2
    )
    it should behave like calculateDamageBonus(
      Body(Strength(55), con, dex, Size(70)),
      2,
      false,
      true
    )
    it should behave like calculateDamageBonus(
      Body(Strength(80), con, dex, Size(90)),
      4,
      true
    )
    it should behave like calculateDamageBonus(
      Body(Strength(150), con, dex, Size(120)),
      8,
      true
    )
    it should behave like calculateDamageBonus(
      Body(Strength(150), con, dex, Size(170)),
      12,
      true
    )
    it should behave like calculateDamageBonus(
      Body(Strength(200), con, dex, Size(200)),
      16,
      true
    )
    it should behave like calculateDamageBonus(
      Body(Strength(250), con, dex, Size(250)),
      20,
      true
    )
    it should behave like calculateDamageBonus(
      Body(Strength(300), con, dex, Size(250)),
      24,
      true
    )
  }
}
