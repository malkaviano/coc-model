package com.rkss.rpg.coc.behaviors.skill

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.helpers.dice.HundredSidedDice
import com.rkss.rpg.coc.behaviors.testing._
import com.rkss.rpg.coc.behaviors.testing.fakes._
import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.concepts.commons._
import com.rkss.rpg.coc.concepts.results._

final class PushableSkillRollBehaviorSpec extends AnyFunSpec with Matchers {
  describe("Pushing a skill roll") {
    describe("when no previous skill roll was made") {
      it should behave like pushSkillRoll(
        FakePushableSkillRoll(Whip, 60),
        Seq(40),
        Option.empty[SkillRolled[Whip.type]],
        false
      )
    }

    Map(
      SkillRollFumble -> 100,
      SkillRollRegularSuccess -> 60,
      SkillRollHardSuccess -> 30,
      SkillRollExtremeSuccess -> 12,
      SkillRollCriticalSuccess -> 1
    ).foreach {
      case ((result, rolled)) => {
        describe(s"when previous roll was $result") {
          it should behave like pushSkillRoll(
            FakePushableSkillRoll(Appraise, 60),
            Seq(40),
            Option.empty[SkillRolled[Appraise.type]],
            true,
            rolled
          )
        }
      }
    }

    describe(s"when previous roll was a Failure") {
      val pushableSkillRollBehavior = FakePushableSkillRoll(AnimalHandling, 60)

      val expected = SkillRolled(
        pushableSkillRollBehavior.name,
        pushableSkillRollBehavior.value(),
        RegularDifficulty,
        BonusDice(0),
        PenaltyDice(0),
        SkillRollRegularSuccess,
        SkillRollDiceResult(40),
        true
      )

      it should behave like pushSkillRoll(
        pushableSkillRollBehavior,
        Seq(40),
        Some(expected)
      )

      describe("when pushing an already pushed skill roll") {
        it should behave like pushSkillRoll(
          FakePushableSkillRoll(Medicine, 60),
          Seq(40, 50),
          Option.empty[SkillRolled[Medicine.type]],
          pushTwice = true
        )
      }
    }
  }

  private def pushSkillRoll[A <: SkillName](
      pushableSkillRollBehavior: FakePushableSkillRoll[A],
      rolled: Seq[Int],
      expected: Option[SkillRolled[A]],
      makeRoll: Boolean = true,
      rollResult: Int = 95,
      pushTwice: Boolean = false
  ): Unit = {
    it(s"return $expected") {
      if (makeRoll) rollSkill(pushableSkillRollBehavior, Seq(rollResult))

      val hundredSidedDice = HundredSidedDice(
        TestingProps.fakeRng(rolled)
      )

      if (pushTwice) pushableSkillRollBehavior.pushRoll()(hundredSidedDice)

      val result = pushableSkillRollBehavior.pushRoll()(hundredSidedDice)

      result shouldBe expected
    }
  }

  private def rollSkill[A <: Naming](
      pushableSkillRollBehavior: PushableSkillRollBehavior[A],
      rolledTest: Seq[Int]
  ): Unit = {
    val hundredSidedDice = HundredSidedDice(
      TestingProps.fakeRng(rolledTest)
    )

    pushableSkillRollBehavior.roll()(hundredSidedDice)
  }
}
