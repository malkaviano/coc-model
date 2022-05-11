package com.rkss.rpg.coc.foundations.actions

import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.GivenWhenThen
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.coc.concepts.roll._
import com.rkss.rpg.coc.foundations.actions._
import com.rkss.rpg.coc.behaviors.testing._
import com.rkss.rpg.helpers.dice._
import com.rkss.rpg.coc.helpers.converters._

trait SkillRollCheckScenario extends MarkedWithSuccessScenario {
  self: AnyFeatureSpec with GivenWhenThen with Matchers =>

  def makingASkillRollCheck[A <: SkillRollNaming](
      spec: SkillRollCheckSpecification[A]
  ): Unit = {
    val SkillRollCheckSpecification(
      checkable,
      rolled,
      expected,
      markUsedWithSuccess,
      opposing
    ) = spec

    Scenario(s"Making a skill roll check ${checkable.name}") {
      Given(s"My Skill / Characteristic value is ${checkable.value()}")

      val difficulty = opposing match {
        case Some(value) => DifficultyConverter.fromSkills(value)
        case None        => expected.checked.difficulty
      }
      And(s"The difficulty is ${difficulty}")

      val bonusDice = expected.checked.bonusDice
      And(s"The bonus dice is ${bonusDice}")

      val penaltyDice = expected.checked.penaltyDice
      And(s"The penalty dice is ${penaltyDice}")

      When(s"I roll a ${rolled.mkString(", ")} in the hundred dice")
      val hundredSidedDice = HundredSidedDice(TestingProps.fakeRng(rolled))

      Then(s"The result should be $expected")

      val checker = SkillRollAction(
        hundredSidedDice
      )

      val result = checker.check(
        checkable,
        difficulty,
        bonusDice,
        penaltyDice
      )

      result shouldBe expected

      checkMarkedWithSuccess(checkable) shouldBe markUsedWithSuccess
    }
  }
}
