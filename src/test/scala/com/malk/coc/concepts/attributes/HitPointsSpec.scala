package com.malk.coc.concepts.attributes

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.malk.coc.concepts.characteristics.{Constitution, Size}

trait HitPointsBehaviors extends Matchers { this: AnyFunSpec =>
  def calculateHitPoints(con: Constitution, siz: Size, expected: Int) {
    it(s"should return value ${expected}") {
      HitPoints(con, siz).value shouldBe expected
    }
  }
}

class HitPointsSpec extends AnyFunSpec with Matchers with HitPointsBehaviors {
  describe("The HitPoints") {
    val hp = HitPoints(con = Constitution(40), siz = Size(60))

    it("should have name Hit Points") {
      hp.name shouldBe "Hit Points"
    }

    it should behave like calculateHitPoints(Constitution(40), Size(60), 10)
    it should behave like calculateHitPoints(Constitution(40), Size(40), 8)
    it should behave like calculateHitPoints(Constitution(30), Size(30), 6)
    it should behave like calculateHitPoints(Constitution(55), Size(70), 12)
    it should behave like calculateHitPoints(Constitution(80), Size(90), 17)
    it should behave like calculateHitPoints(Constitution(150), Size(120), 27)
    it should behave like calculateHitPoints(Constitution(150), Size(170), 32)
    it should behave like calculateHitPoints(Constitution(200), Size(200), 40)
    it should behave like calculateHitPoints(Constitution(250), Size(250), 50)
    it should behave like calculateHitPoints(Constitution(300), Size(250), 55)
    it should behave like calculateHitPoints(Constitution(301), Size(304), 60)
  }
}