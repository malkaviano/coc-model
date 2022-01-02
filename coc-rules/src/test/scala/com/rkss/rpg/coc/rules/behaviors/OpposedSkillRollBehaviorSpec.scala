package com.rkss.rpg.coc.rules.behaviors

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.coc.rules.testing.fakes._
import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.rules.testing.fakes.FakeDiceResult
import com.rkss.rpg.coc.rules.testing.TestingProps
import com.rkss.rpg.helpers.dice.HundredSidedDice

final class OpposedSkillRollBehaviorSpec extends AnyFunSpec with Matchers {
  describe("Opposed skill roll") {
    val skill = FakeSkillWithOpposableSkillRoll("fake", 40)

    val opposedBy = FakeCharacteristic(60)

    val expected = SkillRolled(
      skill,
      HardDifficulty,
      BonusDice(0),
      PenaltyDice(0),
      RegularSuccess,
      FakeDiceResult(19),
      false,
      Option(opposedBy)
    )

    val hundredSidedDice =
          HundredSidedDice(TestingProps.fakeRng(Seq(19)))

    it(s"return $expected") {
      val result =  skill.rollOpposedBy(opposedBy)(hundredSidedDice)

      result shouldBe expected
    }
  }
}
