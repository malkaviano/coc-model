package com.rkss.rpg.coc.foundations.actions

import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.GivenWhenThen
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.coc.foundations.actions._
import com.rkss.rpg.coc.behaviors.testing._
import com.rkss.rpg.helpers.dice._

trait CombinedSkillRollCheckScenario extends MarkedWithSuccessScenario {
  self: AnyFeatureSpec with GivenWhenThen with Matchers =>

  def makingACombinedSkillRollCheck(
      spec: CombinedSkillRollCheckSpecification
  ): Unit = {

    val CombinedSkillRollCheckSpecification(
      checkable1,
      checkable2,
      rolled,
      expected,
      markUsedWithSuccess
    ) = spec

    val values = Seq(checkable1.value(), checkable2.value())

    Scenario(
      s"Making a skill roll check ${checkable1.name} and ${checkable2.name}"
    ) {
      Given(s"My Skill / Characteristic value is $values")

      val difficulty = expected.checked1.difficulty
      And(s"The difficulty is ${difficulty}")

      val bonusDice = expected.checked1.bonusDice
      And(s"The bonus dice is ${bonusDice}")

      val penaltyDice = expected.checked1.penaltyDice
      And(s"The penalty dice is ${penaltyDice}")

      val bothShouldPass = if (expected.requiredAllToPass) {
        "Both should pass"
      } else {
        "Only one needs to pass"
      }
      And(s"$bothShouldPass")

      When(s"I roll a ${rolled.mkString(", ")} in the hundred dice")
      val hundredSidedDice = HundredSidedDice(TestingProps.fakeRng(rolled))

      Then(s"The result should be $expected")

      val checker = SkillRollAction(
        hundredSidedDice
      )

      checker.check(
        checkable1,
        checkable2,
        difficulty,
        bonusDice,
        penaltyDice,
        expected.requiredAllToPass
      ) shouldBe expected

      checkMarkedWithSuccess(checkable1) shouldBe markUsedWithSuccess(0)
      checkMarkedWithSuccess(checkable2) shouldBe markUsedWithSuccess(1)
    }
  }
}
