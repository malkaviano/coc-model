package com.rkss.rpg.coc.foundations.actions

import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.GivenWhenThen
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.helpers.dice._
import com.rkss.rpg.coc.behaviors.testing._
import com.rkss.rpg.coc.foundations.actions._
import com.rkss.rpg.coc.concepts.skill.check._

trait OpposedSkillRollCheckScenario {
  self: AnyFeatureSpec with GivenWhenThen with Matchers =>

  def makingAnOpposedSkillRollCheck[A <: SkillRollNaming, B <: SkillRollNaming](
      spec: OpposedSkillRollCheckSpecification[A, B]
  ): Unit = {

    val OpposedSkillRollCheckSpecification(
      attacker,
      defender,
      attackerRolled,
      defenderRolled,
      expected,
      attackerMarkUsedWithSuccess,
      defenderMarkUsedWithSuccess
    ) = spec

    Scenario(s"Making an opposed skill roll check ${attacker.name} x ${defender.name}") {
      Given(s"Attacker Skill / Characteristic value is ${attacker.value()}")

      Given(s"Defender Skill / Characteristic value is ${defender.value()}")

      val attackerBonusDice = expected.attacker.checked.bonusDice
      And(s"The attacker bonus dice is $attackerBonusDice")

      val defenderBonusDice = expected.defender.checked.bonusDice
      And(s"The defender bonus dice is $defenderBonusDice")

      val attackerPenaltyDice = expected.attacker.checked.penaltyDice
      And(s"The attacker penalty dice is $attackerPenaltyDice")

      val defenderPenaltyDice = expected.defender.checked.penaltyDice
      And(s"The defender penalty dice is $defenderPenaltyDice")

      When(
        s"Attacker rolled ${attackerRolled.mkString(", ")} in the hundred dice"
      )

      When(
        s"Defender rolled ${defenderRolled.mkString(", ")} in the hundred dice"
      )
      val hundredSidedDice =
        HundredSidedDice(TestingProps.fakeRng(attackerRolled ++ defenderRolled))

      Then(s"The result should be $expected")

      val checker = SkillRollAction(
        hundredSidedDice
      )

      val result = checker.check(
        attacker,
        attackerBonusDice,
        attackerPenaltyDice,
        defender,
        defenderBonusDice,
        defenderPenaltyDice
      )

      result shouldBe expected

      checkMarkedWithSuccess(attacker) shouldBe attackerMarkUsedWithSuccess

      checkMarkedWithSuccess(defender) shouldBe defenderMarkUsedWithSuccess
    }
  }

  private def checkMarkedWithSuccess(
      checkable: SkillRollCheckable[_]
  ): Boolean = {
    checkable.isInstanceOf[SkillSuccessMark] &&
    checkable.asInstanceOf[SkillSuccessMark].wasSuccessfullyUsed
  }
}
