package com.malk.coc.concepts.attributes

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.malk.coc.concepts.characteristics.{Strength, Size}

trait DamageBonusBehavior extends Matchers { this: AnyFunSpec =>
  def calculateDamageBonus(str: Strength, siz: Size, min: Int, max: Int) {
    it(s"should return value between ${min} and ${max}") {
      val results = for {
        i <- (1 to (if (max <= 30) 100000 else 500000))
      } yield DamageBonus(str, siz).value

      results.toSet should contain theSameElementsAs (min to max)
    }
  }
}

class DamageBonusSpec extends AnyFunSpec with Matchers with DamageBonusBehavior {
  describe("The Damage Bonus") {
    val bd = DamageBonus(str = Strength(40), siz = Size(60))

    it("should have name Damage Bonus") {
      bd.name shouldBe "Damage Bonus"
    }

    it should behave like calculateDamageBonus(Strength(40), Size(60), 0, 0)
    it should behave like calculateDamageBonus(Strength(40), Size(40), -1, -1)
    it should behave like calculateDamageBonus(Strength(30), Size(30), -2, -2)
    it should behave like calculateDamageBonus(Strength(55), Size(70), 1, 4)
    it should behave like calculateDamageBonus(Strength(80), Size(90), 1, 6)
    it should behave like calculateDamageBonus(Strength(150), Size(120), 2, 12)
    it should behave like calculateDamageBonus(Strength(150), Size(170), 3, 18)
    it should behave like calculateDamageBonus(Strength(200), Size(200), 4, 24)
    it should behave like calculateDamageBonus(Strength(250), Size(250), 5, 30)
    it should behave like calculateDamageBonus(Strength(300), Size(250), 6, 36)
  }
}