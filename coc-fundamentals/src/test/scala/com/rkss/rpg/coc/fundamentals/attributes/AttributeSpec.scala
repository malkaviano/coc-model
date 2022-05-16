package com.rkss.rpg.coc.fundamentals.attributes

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.coc.concepts.attributes._
import com.rkss.rpg.helpers.fixtures._

class AttributeSpec extends AnyFunSpec with Matchers {
  def fake =
    new Attribute[SanityAttribute.type](SanityAttribute, 8, 100) {}

  describe("Current value") {
    it(s"should be 8") {
      val attribute = fake

      attribute.current shouldBe 8
    }

    describe("when gain 10") {
      it("should be 18") {
        val attribute = fake

        attribute.gain(BasicIntValue(SanityAttribute, 10))

        attribute.current shouldBe 18
      }
    }

    describe("when loss 10") {
      it("should be 0") {
        val attribute = fake

        attribute.loss(BasicIntValue(SanityAttribute, 10))

        attribute.current shouldBe 0
      }
    }
  }

  describe("Maximum value") {
    it("should be 8") {
      val attribute = fake

      attribute.maximum shouldBe 100
    }
  }

}
