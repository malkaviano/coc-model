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

          luck shouldBe Luck(expected)
        }
      }

      describe("when using rng") {
        val expected = 45

        it(s"should return Luck(${expected})") {
          val dice = TestingProps.fakeRng(Seq(3, 4, 2))

          val luck = AttributeFactory.createLuck(
            SixSidedDice(dice)
          )

          luck shouldBe Luck(expected)
        }
      }
    }

    describe("creating Sanity attribute") {
      val power = CharacteristicFactory.characteristic(Power, 60)
      val mythos = SkillFactory.cthulhuMythosSkill

      describe(s"when $power") {
        val expected = Sanity(power, mythos)

        it(s"should return SAN(${expected.current})") {
          val sanity = AttributeFactory.createSanity(power, mythos)

          sanity shouldBe expected
        }
      }
    }

    describe("creating HitPoints attribute") {
      val size = CharacteristicFactory.characteristic(Size, 60)
      val constitution = CharacteristicFactory.characteristic(Constitution, 50)

      describe(s"when $size and $constitution") {
        val expected = HitPoints(size, constitution)

        it(s"should return HP(${expected.current})") {
          val hp = AttributeFactory.createHitPoints(size, constitution)

          hp shouldBe expected
        }
      }
    }

    describe("creating MagicPoints attribute") {
      val power = CharacteristicFactory.characteristic(Power, 60)

      describe(s"when $power") {
        val expected = InvestigatorMagicPoints(power)

        it(s"should return MP(${expected.current})") {
          val mp = AttributeFactory.createMagicPoints(power)

          mp shouldBe expected
        }
      }
    }

    describe("creating Age attribute") {
      val expected = Age(30)

      it(s"should return Age(${expected.current})") {
        val age = AttributeFactory.createAge(30)

        age shouldBe expected
      }
    }

    describe("creating Movement Rate attribute") {
      val strength = CharacteristicFactory.characteristic(Strength, 60)
      val dexterity = CharacteristicFactory.characteristic(Dexterity, 60)
      val size = CharacteristicFactory.characteristic(Size, 60)

      describe(s"when $strength - $dexterity - $size") {
        val expected = HumanMovementRate(strength, dexterity, size)

        it(s"should return MOV(${expected.current})") {
          val mov =
            AttributeFactory.createMovementRate(strength, dexterity, size)

          mov shouldBe expected
        }
      }
    }

    describe("creating Build attribute") {
      val strength = CharacteristicFactory.characteristic(Strength, 60)
      val size = CharacteristicFactory.characteristic(Size, 60)

      describe(s"when $strength - $size") {
        val expected = Build(strength, size)

        it(s"should return Build(${expected.current})") {
          val mov =
            AttributeFactory.createBuild(strength, size)

          mov shouldBe expected
        }
      }
    }

    describe("creating Damage Bonus attribute") {
      val strength = CharacteristicFactory.characteristic(Strength, 70)
      val size = CharacteristicFactory.characteristic(Size, 80)

      describe(s"when $strength - $size") {
        implicit val fourSidedDice =
          FourSidedDice(TestingProps.fakeRng(Seq(4)))

        implicit val sixSidedDice =
          SixSidedDice(TestingProps.fakeRng(Seq(6, 6, 6, 6, 6, 6)))

        val expected = DamageBonus(strength, size)

        it(s"should return Damage Bonus(${expected.current})") {

          val mov =
            AttributeFactory.createDamageBonus(strength, size)

          mov shouldBe expected
        }
      }
    }
  }
}
