package com.rkss.rpg.coc.foundations.actions

import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.GivenWhenThen
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.coc.foundations.actions._
import com.rkss.rpg.coc.behaviors.testing._
import com.rkss.rpg.helpers.dice._
import com.rkss.rpg.coc.concepts.characteristic._

trait AidedSkillRollCheckScenario {
  self: AnyFeatureSpec with GivenWhenThen with Matchers =>

  def makingAnAidedSkillRollCheck[
      A <: PhysicalCharacteristicName,
      B <: PhysicalCharacteristicName
  ](
      spec: AidedSkillRollCheckSpec[A, B]
  ): Unit = {

    val AidedSkillRollCheckSpec(
      checkable,
      rolled,
      expected,
      markUsedWithSuccess,
      opposing,
      helping
    ) = spec

    Scenario(s"Making skill roll check ${checkable.name} above human limits") {
      Given(s"My Skill / Characteristic value is ${checkable.value()}")

      And(s"Opposing value is ${opposing.value()}")

      And(s"Helping value is ${helping.map(_.value()).mkString(", ")}")

      val penaltyDice = expected.checked.penaltyDice
      And(s"The penalty dice is ${penaltyDice}")

      val bonusDice = expected.checked.bonusDice
      And(s"The bonus dice is ${bonusDice}")

      val difficulty = expected.checked.difficulty
      And(s"The difficulty is ${difficulty}")

      When(s"I roll a ${rolled.mkString(", ")} in the hundred dice")
      val hundredSidedDice = HundredSidedDice(TestingProps.fakeRng(rolled))

      Then(s"The result should be $expected")

      val checker = SkillRollAction(
        hundredSidedDice
      )

      val result = checker.check(
        checkable,
        bonusDice,
        penaltyDice,
        opposing,
        helping:_*
      )

      result shouldBe expected
    }
  }
}
