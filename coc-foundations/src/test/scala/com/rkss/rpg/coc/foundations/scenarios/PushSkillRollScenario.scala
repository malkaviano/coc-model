package com.rkss.rpg.coc.foundations.specs.scenarios

import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.GivenWhenThen
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.helpers.dice._
import com.rkss.rpg.coc.rules.testing.TestingProps
import com.rkss.rpg.coc.foundations.specs._

trait PushSkillRollScenario {
  self: AnyFeatureSpec with GivenWhenThen with Matchers =>

  def pushingASkillRoll(spec: PushSkillRollSpec): Unit = {

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
      And(s"The bonus dice is $bonusDice")
      And(s"The penalty dice is $penaltyDice")

      When(s"I roll a ${rolled.mkString(", ")} in the hundred dice")
      val hundredSidedDice =
        HundredSidedDice(TestingProps.fakeRng(rolled))

      Then(s"The result should be $expected")

      entity.pushRoll(difficulty, bonusDice, penaltyDice)(
        hundredSidedDice
      ) shouldBe expected
    }
  }
}