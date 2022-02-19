package com.rkss.rpg.coc.foundations.actions

import scala.annotation.tailrec

import com.rkss.rpg.helpers.dice._
import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.concepts.skill.check._
import com.rkss.rpg.coc.concepts.results._
import com.rkss.rpg.coc.foundations.results._
import com.rkss.rpg.coc.concepts.characteristic._
import com.rkss.rpg.coc.concepts.skill._

final class SkillRollAction private (implicit
    val hundredSidedDice: HundredSidedDice
) {
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

  private def difficultyValue(opposingValue: Int) = {
    opposingValue match {
      case x if x < 50 => RegularDifficulty
      case x if x < 90 => HardDifficulty
      case _           => ExtremeDifficulty
    }
  }

  private def activeResistanceRoll[
      A <: SkillRollNaming,
      B <: SkillRollNaming
  ](
      attackerRoll: SkillRolled[A],
      defenderRoll: SkillRolled[B],
      skillValue: Int,
      opposingValue: Int
  ) = {
    val attackerRollResult =
      attackerRoll.result.value > defenderRoll.result.value
    val defenderRollResult =
      attackerRoll.result.value < defenderRoll.result.value

    val successTie =
      (attackerRollResult == defenderRollResult) && attackerRoll.result
        .isInstanceOf[SkillRollSuccessResult]

    successTie match {
      case true =>
        defenderRoll.name match {
          case name: DefenseSkillName =>
            (false, true)
          case name: AttackSkillName =>
            (true, false)
          case _ =>
            (skillValue > opposingValue, skillValue < opposingValue)
        }
      case _ => (attackerRollResult, defenderRollResult)
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
    val roll = skills.head.roll(difficulty, bonusDice, penaltyDice)

    val rolls = roll +: skills.tail.map(
      _.roll(difficulty, bonusDice, penaltyDice, roll.rolled)
    )

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

  def check[A <: SkillRollNaming, B <: SkillRollNaming](
      skill: SkillRollCheckable[A],
      bonusDice: BonusDice,
      penaltyDice: PenaltyDice,
      opposing: SkillRollCheckable[B]
  ): SkillRollChecked[A] = {
    val opposingValue =
      opposing.value()

    val difficulty = difficultyValue(opposingValue)

    val SkillRollChecked(successful, checked) =
      check(skill, difficulty, bonusDice, penaltyDice)

    SkillRollChecked(
      successful,
      checked
    )
  }

  def check[
      A <: PhysicalCharacteristicName,
      B <: PhysicalCharacteristicName
  ](
      skill: Characteristic[A],
      bonusDice: BonusDice,
      penaltyDice: PenaltyDice,
      opposing: Characteristic[B],
      helping: Seq[Characteristic[A]]
  ): SkillRollChecked[A] = {
    val helpingValue = helping.foldLeft(0)((acc, char) => acc + char.value())

    val opposingValue =
      opposing.value() - helpingValue

    val difficulty = difficultyValue(opposingValue)

    val SkillRollChecked(successful, checked) =
      check(skill, difficulty, bonusDice, penaltyDice)

    SkillRollChecked(
      successful,
      checked
    )
  }

  @tailrec
  def check[
      A <: SkillRollNaming,
      B <: SkillRollNaming
  ](
      skill: SkillRollCheckable[A],
      bonusDice: BonusDice,
      penaltyDice: PenaltyDice,
      opposing: SkillRollCheckable[B],
      opposingBonusDice: BonusDice,
      opposingPenaltyDice: PenaltyDice
  ): OpposedSkillRollChecked[A, B] = {
    val attackerRoll = skill.roll(RegularDifficulty, bonusDice, penaltyDice)

    val defenderRoll =
      opposing.roll(RegularDifficulty, opposingBonusDice, opposingPenaltyDice)

    val (attackerResult, defenderResult) =
      activeResistanceRoll(attackerRoll, defenderRoll, skill.value(), opposing.value())

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
          if attackerRoll.result
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
