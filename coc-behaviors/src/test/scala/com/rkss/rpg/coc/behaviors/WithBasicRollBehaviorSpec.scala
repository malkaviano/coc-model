package com.rkss.rpg.coc.behaviors

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.coc.behaviors.testing.fakes.FakeWithBasicSkillRoll
import com.rkss.rpg.coc.behaviors.testing.TestingProps
import com.rkss.rpg.helpers.dice.HundredSidedDice
import com.rkss.rpg.coc.concepts._

final class WithBasicRollBehaviorSpec extends AnyFunSpec with Matchers {
  describe("Roll behavior") {
    val fake = FakeWithBasicSkillRoll(60)

    describe("when rolling above the base value") {
      val expected = EntityRolled(
        fake,
        RollDiceResult(90),
        FailureRoll
      )

      it should behave like roll(fake, expected, Seq(90))
    }

    describe("when rolling equal or inferior the base value") {
      Seq(60, 10).foreach(rolled => {
        val expected = EntityRolled(
          fake,
          RollDiceResult(rolled),
          SuccessRoll
        )

        it should behave like roll(fake, expected, Seq(rolled))
      })
    }
  }

  private def roll(
      fake: WithBasicRollBehavior,
      expected: EntityRolled,
      rolled: Seq[Int]
  ): Unit = {
    it(s"return $expected") {
      val hundredSidedDice = HundredSidedDice(
        TestingProps.fakeRng(rolled)
      )

      fake.roll(hundredSidedDice) shouldBe expected
    }
  }
}
