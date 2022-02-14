package com.rkss.rpg.coc.foundations.actions

import scala.annotation.tailrec

import com.rkss.rpg.helpers.dice._
import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.concepts.skill.check._
import com.rkss.rpg.coc.concepts.results._
import com.rkss.rpg.coc.foundations.results._

final class SkillRollAction private(implicit val hundredSidedDice: HundredSidedDice) {
  private def markWithSuccess(
      skill: SkillRollCheckable[_],
      bonusDice: BonusDice,
      penaltyDice: PenaltyDice
  ): Unit = {
    if (
      bonusDice.value <= penaltyDice.value && skill
        .isInstanceOf[SkillSuccessMarkable]
    ) {
      skill.asInstanceOf[SkillSuccessMarkable].markUsedWithSuccess()
    }
  }

  def check[A <: SkillRollNaming](
      checkable: SkillRollCheckable[A],
      difficulty: SkillRollDifficultyLevel,
      bonusDice: BonusDice,
      penaltyDice: PenaltyDice
  ): SkillRollChecked[A] = {
    val roll = checkable.roll(difficulty, bonusDice, penaltyDice)

    val passed = roll.result.isInstanceOf[SkillRollSuccessResult]

    if (passed) {
      markWithSuccess(checkable, bonusDice, penaltyDice)
    }

    SkillRollChecked(
      passed,
      roll
    )
  }

  def check(
      skills: Seq[SkillRollCheckable[SkillRollNaming]],
      difficulty: SkillRollDifficultyLevel,
      bonusDice: BonusDice,
      penaltyDice: PenaltyDice,
      allMustPass: Boolean
  ): CombinedSkillRollChecked[SkillRollNaming] = {
    val rolls = skills.map(_.roll(difficulty, bonusDice, penaltyDice))

    val passed = allMustPass match {
      case true =>
        rolls.foldLeft(true)((acc, roll) =>
          acc && roll.result
            .isInstanceOf[SkillRollSuccessResult]
        )
      case _ =>
        rolls.foldLeft(false)((acc, roll) =>
          acc || roll.result
            .isInstanceOf[SkillRollSuccessResult]
        )
    }

    if (passed) {
      rolls
        .filter(_.result.isInstanceOf[SkillRollSuccessResult])
        .foreach(roll => {
          skills
            .find(_.name == roll.name)
            .foreach(markWithSuccess(_, bonusDice, penaltyDice))
        })
    }

    CombinedSkillRollChecked(
      passed,
      rolls,
      allMustPass
    )
  }

  def check[A <: SkillName, B <: SkillName](
      skill: Skill[A],
      bonusDice: BonusDice,
      penaltyDice: PenaltyDice,
      opposing: Skill[B],
      contributing: Seq[Skill[_]]
  ): AidedSkillRollChecked[A, B] = {
    val reduction =
      contributing.foldLeft(0)((acc, skill) => acc + skill.value())

    val opposingValue =
      opposing.value() - reduction

    val difficulty = opposingValue match {
      case x if x < 50 => RegularDifficulty
      case x if x < 90 => HardDifficulty
      case _           => ExtremeDifficulty
    }

    val SkillRollChecked(successful, checked) =
      check(skill, difficulty, bonusDice, penaltyDice)

    AidedSkillRollChecked(successful, checked, contributing, opposing, opposingValue)
  }

  @tailrec
  def check[
      A <: SkillName,
      B <: SkillName
  ](
      skill: Skill[A],
      bonusDice: BonusDice,
      penaltyDice: PenaltyDice,
      opposing: Skill[B],
      opposingBonusDice: BonusDice,
      opposingPenaltyDice: PenaltyDice
  ): OpposedSkillRollChecked[A, B] = {
    val attackerRoll = skill.roll(RegularDifficulty, bonusDice, penaltyDice)

    val defenderRoll =
      opposing.roll(RegularDifficulty, bonusDice, penaltyDice)

    val attackerRollResult =
      attackerRoll.result.value > defenderRoll.result.value
    val defenderRollResult =
      attackerRoll.result.value < defenderRoll.result.value

    val (attackerResult, defenderResult) =
      attackerRollResult == defenderRollResult match {
        case true =>
          (skill.value() > opposing.value(), skill.value() < opposing.value())
        case _ => (attackerRollResult, defenderRollResult)
      }

    val result = OpposedSkillRollChecked(
      SkillRollChecked(
        attackerResult,
        attackerRoll
      ),
      SkillRollChecked(
        defenderResult,
        defenderRoll
      )
    )

    result.attacker.successful == result.defender.successful match {
      case true
          if result.attacker.checked.result
            .isInstanceOf[SkillRollSuccessResult] =>
        check(
          skill,
          bonusDice,
          penaltyDice,
          opposing,
          opposingBonusDice,
          opposingPenaltyDice
        )
      case _ => {
        if (result.attacker.successful) {
          markWithSuccess(skill, bonusDice, penaltyDice)
        } else if (result.defender.successful) {
          markWithSuccess(opposing, bonusDice, penaltyDice)
        }

        result
      }
    }
  }
}

object SkillRollAction {
  def apply(implicit hundredSidedDice: HundredSidedDice): SkillRollAction = {
    new SkillRollAction
  }
}