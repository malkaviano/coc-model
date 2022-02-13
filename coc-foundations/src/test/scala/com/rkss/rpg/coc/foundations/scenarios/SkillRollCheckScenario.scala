package com.rkss.rpg.coc.foundations.scenarios

import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.GivenWhenThen
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.foundations.specifications._
import com.rkss.rpg.coc.foundations.actions._
import com.rkss.rpg.coc.concepts.skill.check._
import com.rkss.rpg.coc.behaviors.testing._
import com.rkss.rpg.helpers.dice._

trait SkillRollCheckScenario {
  self: AnyFeatureSpec with GivenWhenThen with Matchers =>

  def makingASkillRollCheck[A <: SkillRollNaming](
      spec: SkillRollCheckSpec[A]
  ): Unit = {

    val SkillRollCheckSpec(
      checkable,
      rolled,
      expected,
      markUsedWithSuccess
    ) = spec

    Scenario(s"Making a skill roll check ${checkable.name}") {
      Given(s"My Skill / Characteristic value is ${checkable.value()}")

      val difficulty = expected.checked.difficulty
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

      checker.check(
        checkable,
        difficulty,
        bonusDice,
        penaltyDice
      ) shouldBe expected

      checkMarkedWithSuccess(checkable) shouldBe markUsedWithSuccess
    }
  }

  private def checkMarkedWithSuccess(
      checkable: SkillRollCheckable[_]
  ): Boolean = {
    checkable.isInstanceOf[SkillSuccessMark] &&
      checkable.asInstanceOf[SkillSuccessMark].wasSuccessfullyUsed
  }
}
