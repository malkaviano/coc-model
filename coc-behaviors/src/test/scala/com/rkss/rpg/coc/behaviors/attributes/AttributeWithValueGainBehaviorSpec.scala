package com.rkss.rpg.coc.behaviors.attributes

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.coc.behaviors.testing.fakes._
import com.rkss.rpg.coc.concepts.attributes._

final class AttributeWithValueGainBehaviorSpec
    extends AnyFunSpec
    with Matchers {
  describe("Value gain") {
    Seq(
      (
        0,
        20,
        AttributeValueGain(SanityAttribute, 10),
        AttributeValueGained(SanityAttribute, 10, 10, 0, 20)
      ),
      (
        10,
        20,
        AttributeValueGain(SanityAttribute, 15),
        AttributeValueGained(SanityAttribute, 10, 20, 10, 20)
      ),
      (
        20,
        20,
        AttributeValueGain(SanityAttribute, 15),
        AttributeValueGained(SanityAttribute, 0, 20, 20, 20)
      )
    ).foreach { case (current, maximum, gain, expected) =>
      describe(s"when current value is $current") {
        describe(s"and maximum value is $maximum") {
          describe(s"and value gain is $gain") {
            it(s"should return $expected") {
              val attribute = FakeAttribute(SanityAttribute, current, maximum)

              val result = attribute.gain(gain)

              result shouldBe expected
            }
          }
        }
      }
    }
  }

  describe("Value loss") {
    Seq(
      (
        50,
        AttributeValueLoss(SanityAttribute, 10),
        AttributeValueLost(SanityAttribute, 10, 40, 50)
      ),
      (
        50,
        AttributeValueLoss(SanityAttribute, 60),
        AttributeValueLost(SanityAttribute, 50, 0, 50)
      ),
      (
        0,
        AttributeValueLoss(SanityAttribute, 15),
        AttributeValueLost(SanityAttribute, 0, 0, 0)
      )
    ).foreach { case (current, loss, expected) =>
      describe(s"when current value is $current") {
        describe(s"and value loss is $loss") {
          it(s"should return $expected") {
            val attribute = FakeAttribute(SanityAttribute, current, 100)

            val result = attribute.loss(loss)

            result shouldBe expected
          }
        }
      }
    }
  }
}
