package com.rkss.rpg.coc.helpers.factories

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.coc.fundamentals.attributes._
import com.rkss.rpg.helpers.dice._
import com.rkss.rpg.coc.behaviors.testing._
import com.rkss.rpg.coc.concepts.characteristic._

final class AttributeFactorySpec extends AnyFunSpec with Matchers {
  describe("Attribute Factory") {
    describe("creating Luck attribute") {
      describe("when base value is informed") {
        val expected = 50

        it(s"should return Luck(${expected})") {
          val luck = AttributeFactory.createLuck(expected)

          luck shouldBe InvestigatorLuck(expected)
        }
      }

      describe("when using rng") {
        val expected = 45

        it(s"should return Luck(${expected})") {
          val dice = TestingProps.fakeRng(Seq(3, 4, 2))

          val luck = AttributeFactory.createLuck(
            SixSidedDice(dice)
          )

          luck shouldBe InvestigatorLuck(expected)
        }
      }
    }

    describe("creating Sanity attribute") {
      val power = CharacteristicFactory.characteristic(Power, 60)
      val mythos = SkillFactory.cthulhuMythosSkill

      describe(s"when $power") {
        val expected = InvestigatorSanity(power, mythos)

        it(s"should return Luck(${expected})") {
          val sanity = AttributeFactory.createSanity(power, mythos)

          sanity shouldBe expected
        }
      }
    }

    describe("creating HitPoints attribute") {
      val size = CharacteristicFactory.characteristic(Size, 60)
      val constitution = CharacteristicFactory.characteristic(Constitution, 50)

      describe(s"when $size and $constitution") {
        val expected = InvestigatorHitPoints(size, constitution)

        it(s"should return Luck(${expected})") {
          val hp = AttributeFactory.createHitPoints(size, constitution)

          hp shouldBe expected
        }
      }
    }

    describe("creating MagicPoints attribute") {
      val power = CharacteristicFactory.characteristic(Power, 60)

      describe(s"when $power") {
        val expected = InvestigatorMagicPoints(power)

        it(s"should return Luck(${expected})") {
          val mp = AttributeFactory.createMagicPoints(power)

          mp shouldBe expected
        }
      }
    }
  }
}
