package com.rkss.rpg.script // Package is outside coc on purpose to check visibility

import com.rkss.rpg.coc.helpers.factories._
import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.foundations.actions._
import com.rkss.rpg.coc.concepts.skill.roll._

object SampleUsage extends App {
  import com.rkss.rpg.helpers.dice.Bag._

  val skillRollChecker = SkillRollAction(hundredSidedDice)

  val harveySpotHidden = SkillFactory.basicSkill(
    SpotHidden,
    tenSidedDice.roll.value,
    sixSidedDice.roll.value
  )
  val harveyPsychology = SkillFactory.basicSkill(
    Psychology,
    tenSidedDice.roll.value,
    sixSidedDice.roll.value
  )

  val result = skillRollChecker.check(
    harveyPsychology,
    harveySpotHidden,
    RegularDifficulty,
    BonusDice(0),
    PenaltyDice(0),
    false
  )

  val sceneResult = if (result.successful) {
    "anticipated"
  } else {
    "did not anticipate"
  }

  val scene1 = s"""
    | A deranged cultist suddenly draws a gun on Harvey.
    | The Keeper asks for either a Spot Hidden(${harveySpotHidden.value()}) roll
    | or a Psychology(${harveyPsychology.value()}) roll from Harvey.
    | A success on either will allow Harvey to anticipate the attacker's action,
    | and perhaps give Harvey a chance to act first.
    | A successful Spot Hidden would allow him to see the gun being drawn by the cultist,
    | while a successful Psychology would allow Harvey to anticipate the cultist's aggressive intent.
    | Harvey rolled ${result.checked1.rolled.value}
    | Harvey $sceneResult the cultist's intent
 """.stripMargin

  println(scene1)

  val harveyMechanicalRepair = SkillFactory.basicSkill(
    MechanicalRepair,
    tenSidedDice.roll.value,
    sixSidedDice.roll.value
  )
  val harveyElectricalRepair = SkillFactory.basicSkill(
    ElectricalRepair,
    tenSidedDice.roll.value,
    sixSidedDice.roll.value
  )

  val result2 = skillRollChecker.check(
    harveyMechanicalRepair,
    harveyElectricalRepair,
    RegularDifficulty,
    BonusDice(0),
    PenaltyDice(0),
    true
  )

  val sceneResult2 = if (result2.successful) {
    "repaired"
  } else {
    "did not repair"
  }

  val scene2 = s"""
    | Later, Harvey attempts to repair an electric turbine.
    | The item is both mechanical and electrical,
    | so the Keeper asks for a combined Mechanical Repair(${harveyMechanicalRepair.value()})
    | and Electrical Repair(${harveyElectricalRepair.value()}) roll.
    | And both should pass.
    | Harvey rolled ${result2.checked1.rolled.value}
    | Harvey $sceneResult2 the turbine
  """.stripMargin

  println(scene2)
}
