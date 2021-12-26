package com.rkss.rpg.coc.rules.behaviors

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.helpers.dice.HundredSidedDice
import com.rkss.rpg.coc.props.TestingProps
import com.rkss.rpg.coc.props.fakes.FakeSkill
import com.rkss.rpg.coc.props.fakes.FakeDiceResult

class PushableSkillRollBehaviorSpec extends AnyFunSpec with Matchers {
  describe("Pushing a skill roll") {
    describe("when no previous skill roll was made") {
      it("return no result") {
        val pushableSkillRollBehavior =
          FakePushableSkillRoll("Fake", 60, 60, 30, 12)

        val hundredSidedDice = HundredSidedDice(
          TestingProps.fakeRng(Seq(40))
        )

        val result = pushableSkillRollBehavior.pushRoll()(hundredSidedDice)

        result shouldBe Option.empty[SkillRolled]
      }
    }

    Map(
      Fumble -> 100,
      RegularSuccess -> 60,
      HardSuccess -> 30,
      ExtremeSuccess -> 12,
      CriticalSuccess -> 1
    ).foreach {
      case ((result, rolled)) => {
        describe(s"when previous roll was $result") {
          it("return no result") {
            val pushableSkillRollBehavior =
              FakePushableSkillRoll("Fake", 60, 60, 30, 12)

            rollSkill(pushableSkillRollBehavior, Seq(rolled))

            val hundredSidedDice = HundredSidedDice(
              TestingProps.fakeRng(Seq(40))
            )

            val result = pushableSkillRollBehavior.pushRoll()(hundredSidedDice)

            result shouldBe Option.empty[SkillRolled]
          }
        }
      }
    }

    describe(s"when previous roll was a Failure") {
      val pushableSkillRollBehavior =
        FakePushableSkillRoll("Fake", 60, 60, 30, 12)

      rollSkill(pushableSkillRollBehavior, Seq(80))

      it("return a RegularSuccess") {
        val hundredSidedDice = HundredSidedDice(
          TestingProps.fakeRng(Seq(40))
        )

        val result = pushableSkillRollBehavior.pushRoll()(hundredSidedDice)

        val expected = SkillRolled(
          pushableSkillRollBehavior,
          RegularDifficulty,
          BonusDice(0),
          PenaltyDice(0),
          RegularSuccess,
          FakeDiceResult(40)
        )

        result shouldBe Option(expected)
      }
    }
  }

  private def rollSkill(
      pushableSkillRollBehavior: PushableSkillRollBehavior,
      rolledTest: Seq[Int]
  ): Unit = {
    val hundredSidedDice = HundredSidedDice(
      TestingProps.fakeRng(rolledTest)
    )

    pushableSkillRollBehavior.roll()(hundredSidedDice)
  }
}

final case class FakePushableSkillRoll(
    override val name: String,
    override val baseValue: Int,
    override val regular: Int,
    override val hard: Int,
    override val extreme: Int
) extends FakeSkill(name, baseValue, regular, hard, extreme)
    with SkillRollBehavior
    with SkillPushable
    with PushableSkillRollBehavior
