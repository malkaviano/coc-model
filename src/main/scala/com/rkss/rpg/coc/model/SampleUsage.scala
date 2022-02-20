package com.rkss.rpg.script // Package is outside coc on purpose to check visibility

import com.rkss.rpg.coc.helpers.factories._
import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.foundations.actions._
import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.concepts.characteristic._
import com.rkss.rpg.coc.helpers.transforms._

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
    | so the Keeper asks for a combined Mechanical Repair(${harveyMechanicalRepair
    .value()})
    | and Electrical Repair(${harveyElectricalRepair.value()}) roll.
    | And both should pass.
    | Harvey rolled ${result2.checked1.rolled.value}
    | Harvey $sceneResult2 the turbine
  """.stripMargin

  println(scene2)

  val harveyPersuade = SkillFactory.basicSkill(
    Persuade,
    tenSidedDice.roll.value,
    sixSidedDice.roll.value
  )

  val librarianPersuade = SkillFactory.basicSkill(
    Persuade,
    tenSidedDice.roll.value,
    sixSidedDice.roll.value
  )

  val librarianPsychology = SkillFactory.basicSkill(
    Psychology,
    tenSidedDice.roll.value,
    sixSidedDice.roll.value
  )

  import com.rkss.rpg.coc.helpers.transforms.SkillConversion.implicits._

  val scene3Difficulty = DifficultyTransformer.fromSkills(
   librarianPersuade,
   librarianPsychology
  )

  val result3 = skillRollChecker.check(
    harveyPersuade,
    scene3Difficulty,
    BonusDice(0),
    PenaltyDice(0)
  )

  val sceneResult3 = if (result3.successful) {
    "persuaded"
  } else {
    "did not persuade"
  }

  val scene3 = s"""
    | Harvey Walters is trying to ${harveyPersuade.name}(${harveyPersuade
    .value()}) the librarian
    | to allow him access to the library on a Sunday,
    | when the library is normally closed.
    | The Keeper considers the librarian's ${librarianPersuade.name}(${librarianPersuade
    .value()})
    | and ${librarianPsychology.name}(${librarianPsychology.value()}) skills
    | (the two skills which are used to oppose ${harveyPersuade.name}).
    | Neither of these is above 50% and so the difficulty level is Regular,
    | requiring Harvey's player to roll equal to or below Harvey's full Persuade
    | skill in order to succeed.
    | Harvey rolled ${result3.checked.rolled.value}
    | Harvey $sceneResult3 the librarian
  """.stripMargin

  println(scene3)

  if (!result3.successful) {
    val harveyStrength = CharacteristicFactory.characteristic(Strength, 20)

    val result = skillRollChecker.check(
      harveyStrength,
      HardDifficulty,
      BonusDice(0),
      PenaltyDice(0)
    )

    val sceneResult = if (result.successful) {
      "opened"
    } else {
      "did not open"
    }

    val scene = s"""
    | Harvey failed to persuade the librarian to open up,
    | so he has decided to force open the back door of the library.
    | Harvey has a ${harveyStrength.name}(${harveyStrength.value()}).
    | The library door is made of thick oak, with a stout iron lock,
    | and the Keeper judges it to be particularly strong.
    | The difficulty level is thus set to Hard,
    | requiring Harvey to roll ${harveyStrength
      .value(HardDifficulty)} or below (half Harvey's STR).
    | Harvey rolled ${result.checked.rolled.value}
    | Harvey $sceneResult the back door.
    """.stripMargin

    println(scene)
  }
}
