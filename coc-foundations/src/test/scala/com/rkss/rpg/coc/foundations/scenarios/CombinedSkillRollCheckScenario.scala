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

trait CombinedSkillRollCheckScenario {
  self: AnyFeatureSpec with GivenWhenThen with Matchers =>

  def makingACombinedSkillRollCheck(
      spec: CombinedSkillRollCheckSpec[SkillRollNaming]
  ): Unit = {

    val CombinedSkillRollCheckSpec(
      checkables,
      rolled,
      expected,
      allMustPass,
      markUsedWithSuccess
    ) = spec

    val names = checkables.map(_.name).mkString(", ")

    val values = checkables.map(_.value())

    Scenario(s"Making a skill roll check $names") {
      Given(s"My Skill / Characteristic value is $values")

      val difficulty = expected.checked.head.difficulty
      And(s"The difficulty is ${difficulty}")

      val bonusDice = expected.checked.head.bonusDice
      And(s"The bonus dice is ${bonusDice}")

      val penaltyDice = expected.checked.head.penaltyDice
      And(s"The penalty dice is ${penaltyDice}")

      When(s"I roll a ${rolled.mkString(", ")} in the hundred dice")
      val hundredSidedDice = HundredSidedDice(TestingProps.fakeRng(rolled))

      Then(s"The result should be $expected")

      val checker = SkillRollAction(
        hundredSidedDice
      )

      checker.check(
        checkables,
        difficulty,
        bonusDice,
        penaltyDice,
        allMustPass
      ) shouldBe expected

      checkables.zip(markUsedWithSuccess).foreach { case (skill, marked) =>
        checkMarkedWithSuccess(skill) shouldBe marked
      }
    }
  }

  private def checkMarkedWithSuccess(
      checkable: SkillRollCheckable[_]
  ): Boolean = {
    checkable.isInstanceOf[SkillSuccessMark] &&
      checkable.asInstanceOf[SkillSuccessMark].wasSuccessfullyUsed
  }
}
