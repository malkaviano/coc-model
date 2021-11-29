package com.malk.coc.concepts.attributes

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.malk.coc.concepts.characteristics.{Constitution, Size}
import com.malk.coc.abstractions.Body
import com.malk.coc.concepts.characteristics.Strength
import com.malk.coc.concepts.characteristics.Dexterity

trait MaximumHitPointsBehaviors extends Matchers { this: AnyFunSpec =>
  def calculateHitPoints(body: Body, expected: Int): Unit = {
    it(s"should return value ${expected}") {
      MaximumHitPoints(body).value shouldBe expected
    }
  }
}

class MaximumHitPointsSpec extends AnyFunSpec with Matchers with MaximumHitPointsBehaviors {
  import com.malk.coc.helpers.DiceHelper.implicits._

  describe("The Maximum Hit Points") {
    val str = Strength(67)
    val dex = Dexterity(45)
    val hp = MaximumHitPoints(Body(str, Constitution(40), dex, Size(60)))

    it("should have name Maximum Hit Points") {
      hp.name shouldBe "Maximum Hit Points"
    }

    it should behave like calculateHitPoints(Body(str, Constitution(40), dex, Size(60)), 10)
    it should behave like calculateHitPoints(Body(str, Constitution(40), dex, Size(40)), 8)
    it should behave like calculateHitPoints(Body(str, Constitution(30), dex, Size(30)), 6)
    it should behave like calculateHitPoints(Body(str, Constitution(55), dex, Size(70)), 12)
    it should behave like calculateHitPoints(Body(str, Constitution(80), dex, Size(90)), 17)
    it should behave like calculateHitPoints(Body(str, Constitution(150), dex, Size(120)), 27)
    it should behave like calculateHitPoints(Body(str, Constitution(150), dex, Size(170)), 32)
    it should behave like calculateHitPoints(Body(str, Constitution(200), dex, Size(200)), 40)
    it should behave like calculateHitPoints(Body(str, Constitution(250), dex, Size(250)), 50)
    it should behave like calculateHitPoints(Body(str, Constitution(300), dex, Size(250)), 55)
    it should behave like calculateHitPoints(Body(str, Constitution(301), dex, Size(304)), 60)
  }
}