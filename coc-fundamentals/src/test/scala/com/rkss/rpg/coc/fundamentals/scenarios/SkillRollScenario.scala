package com.rkss.rpg.coc.fundamentals.specs.scenarios

import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.GivenWhenThen
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.helpers.dice._
import com.rkss.rpg.coc.rules.testing.TestingProps
import com.rkss.rpg.coc.fundamentals.specs.SkillRollSpec

trait SkillRollScenario {
  self: AnyFeatureSpec with GivenWhenThen with Matchers =>

  def makingASkillRoll(spec: SkillRollSpec): Unit = {

    val (difficulty, bonusDice, penaltyDice, rolled, expected, entity) =
      (
        spec.difficulty,
        spec.bonusDice,
        spec.penaltyDice,
        spec.rolled,
        spec.expected,
        spec.entity
      )

    Scenario(s"Making a skill roll for ${entity}") {
      Given(s"My Skill / Characteristic value is ${entity.value()}")
      And(s"The difficulty is $difficulty")
      And(s"The bonus dice is ${bonusDice.value}")
      And(s"The penalty dice is ${penaltyDice.value}")

      When(s"I roll a ${rolled.mkString(", ")} in the hundred dice")
      val hundredSidedDice =
        HundredSidedDice(TestingProps.fakeRng(rolled))

      Then(s"The result should be $expected")

      entity.roll(difficulty, bonusDice, penaltyDice)(
        hundredSidedDice
      ) shouldBe expected
    }
  }
}
