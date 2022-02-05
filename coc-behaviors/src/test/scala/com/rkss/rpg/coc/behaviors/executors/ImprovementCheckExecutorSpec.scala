package com.rkss.rpg.coc.behaviors.executors

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.coc.behaviors.testing.fakes._
import com.rkss.rpg.helpers.dice._
import com.rkss.rpg.coc.behaviors.testing.TestingProps
import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.concepts._
import com.rkss.rpg.coc.behaviors.results._
import com.rkss.rpg.coc.concepts.characteristic._

final class ImprovementCheckExecutorSpec extends AnyFunSpec with Matchers {
  describe("Improvement Check") {
    describe("when failing a improvement check") {
      val expected =
        ImprovementChecked(RollDiceResult(10), 0)

      describe(s"when rolled value is ${expected.rolled}") {

        val skill = new FakeSkill(Anthropology, 30)

        describe(s"when entity to be tested is ${skill}") {
          it should behave like skillImprovementCheck(
            skill,
            Seq(10),
            Seq(8),
            expected
          )
        }

        val power = new FakeGenericCharacteristic(Power, 60)

        describe(s"when entity to be tested is ${power}") {
          it should behave like characteristicImprovementCheck(
            power,
            Seq(10),
            Seq(8),
            expected
          )
        }
      }
    }

    describe("when passing a improvement check") {
      describe("when rolling above entity value") {
        val skill = new FakeSkill(Handgun, 30)

        it should behave like skillImprovementCheck(
          skill,
          Seq(90),
          Seq(8),
          ImprovementChecked(RollDiceResult(90), 8)

        )

        val power = new FakeGenericCharacteristic(Power, 60)

        it should behave like characteristicImprovementCheck(
          power,
          Seq(91),
          Seq(9),
          ImprovementChecked(RollDiceResult(91), 9)

        )
      }

      describe("when rolling above 95") {
        val skill = new FakeSkill(Axe, 30, 50, 21)

        it should behave like skillImprovementCheck(
          skill,
          Seq(98),
          Seq(6),
          ImprovementChecked(RollDiceResult(98), 6)
        )

        val power = new FakeGenericCharacteristic(Power, 100)

        it should behave like characteristicImprovementCheck(
          power,
          Seq(100),
          Seq(7),
          ImprovementChecked(RollDiceResult(100), 7)
        )
      }
    }
  }

  private def skillImprovementCheck[A <: ImprovableSkillName](
      skill: FakeSkill[A],
      check: Seq[Int],
      improved: Seq[Int],
      expected: ImprovementChecked
  ) = {
    val hundredSidedDice = HundredSidedDice(
      TestingProps.fakeRng(check)
    )

    val tenSidedDice = TenSidedDice(
      TestingProps.fakeRng(improved)
    )

    it(s"return $expected") {
      val skillImprovementCheck = ImprovementCheckExecutor.instance

      val result = skillImprovementCheck.skillImprovementCheck(skill)(
        hundredSidedDice,
        tenSidedDice
      )

      result shouldBe expected
    }
  }

  private def characteristicImprovementCheck[A <: ImprovableCharacteristicName](
      characteristic: FakeGenericCharacteristic[A],
      check: Seq[Int],
      improved: Seq[Int],
      expected: ImprovementChecked
  ) = {
    val hundredSidedDice = HundredSidedDice(
      TestingProps.fakeRng(check)
    )

    val tenSidedDice = TenSidedDice(
      TestingProps.fakeRng(improved)
    )

    it(s"return $expected") {
      val skillImprovementCheck = ImprovementCheckExecutor.instance

      val result = skillImprovementCheck.characteristicCheck(characteristic)(
        hundredSidedDice,
        tenSidedDice
      )

      result shouldBe expected
    }
  }
}
