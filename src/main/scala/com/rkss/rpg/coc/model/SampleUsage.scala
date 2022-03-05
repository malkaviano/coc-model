package com.rkss.rpg.script // Package is outside coc on purpose to check visibility

import com.rkss.rpg.coc.helpers.factories._
import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.foundations.actions._
import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.concepts.characteristic._
import com.rkss.rpg.coc.helpers.converters._
import com.rkss.rpg.coc.concepts.skill.improvement._

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

  val scene3Difficulty = DifficultyConverter.fromSkills(
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

  val rafterSize = CharacteristicFactory.characteristic(Size, 150)
  val cecilStrength = CharacteristicFactory.characteristic(Strength, 40)
  val martinStrength = CharacteristicFactory.characteristic(Strength, 45)

  val result4 = skillRollChecker.check(
    martinStrength,
    BonusDice(0),
    PenaltyDice(0),
    rafterSize,
    cecilStrength
  )

  val sceneResult4 = if (result4.successful) {
    "freed"
  } else {
    "failed to free"
  }

  val scene4 = s"""
  | Cecil's fellow investigator, Rodger, is trapped beneath a fallen rafter.
  | The Keeper rules that the rafter has a ${Size} of ${rafterSize
    .value()}.
  | Cecil's ${Strength} is only ${cecilStrength.value()},
  | which is more than 100 below the rafter's ${Size},
  | making it impossible for him to lift it on his own,
  | according to the rule on physical human limits.
  | Luckily, Martin (${Strength} ${martinStrength
    .value()}) is there to help.
  | Cecil's ${Strength} is lowest,
  | so it is subtracted first from the rafter's ${Size},
  | leaving the rafter's ${Size} at ${rafterSize
    .value() - cecilStrength.value()} (${rafterSize
    .value()}-${cecilStrength.value()}).
  | This is over 90, but less than 100 points above Martin's ${Strength},
  | so he can attempt a skill roll to move the rafter, requiring an Extreme success.
  | Martin rolled ${result4.checked.rolled.value}
  | Martin $sceneResult4 Rodger
  """.stripMargin

  println(scene4)

  if (!result4.successful) {
    val harveyStrength = CharacteristicFactory.characteristic(Strength, 20)
    val helenStrength = CharacteristicFactory.characteristic(Strength, 60)
    val belindaStrength = CharacteristicFactory.characteristic(Strength, 75)

    val result = skillRollChecker.check(
      belindaStrength,
      BonusDice(0),
      PenaltyDice(0),
      rafterSize,
      harveyStrength,
      cecilStrength,
      martinStrength
    )

    val sceneResult = if (result.successful) {
      "freed"
    } else {
      "trapped"
    }

    val scene = s"""
    | Cecil has ${Strength} ${cecilStrength
      .value()}; the most he can attempt to lift is ${Size} ${cecilStrength
      .value() + 100}.
    | Martin has ${Strength} ${martinStrength
      .value()}; the most he can attempt to lift is ${Size} ${martinStrength
      .value() + 100}.
    | At that moment the rest of the group arrive.
    | There are now five investigators attempting to lift the rafter:
    | Cecil (${Strength} ${cecilStrength.value()}),
    | Harvey (${Strength} ${harveyStrength.value()}),
    | Martin (${Strength} ${martinStrength.value()}),
    | Helen (${Strength} ${helenStrength.value()})
    | and Belinda (${Strength} ${belindaStrength.value()}).
    | Harvey has ${Strength} ${harveyStrength.value()};
    | the most he can attempt to lift is ${Size} ${harveyStrength
      .value() + 100}.
    | Helen has ${Strength} ${helenStrength.value()};
    | the most she can attempt to lift is ${Size} 160.
    | Belinda has ${Strength} ${belindaStrength.value() + 100};
    | the most she can attempt to lift is ${Size} ${belindaStrength
      .value() + 100}.
    | Subtracting Harvey's ${Strength} from the rafter leaves ${Size} 130;
    | deducting Cecil's ${Strength} then leaves ${Size} 90;
    | finally, subtracting Martin's ${Strength} leaves ${Size} 45.
    | This has reduced the difficulty level to ${result.checked.difficulty}.
    | The Keeper rules that they can all lay hands on the rafter and attempt the lift,
    | but since one attempt has already been made,
    | that this will constitute a pushed skill roll.
    | Neither Helen's nor Belinda's ${Strength} have been factored in yet,
    | so they are both able to attempt the pushed skill roll to lift the rafter.
    | Belinda rolls ${result.checked.rolled.value}
    | Rodger is $sceneResult.
    """.stripMargin

    println(scene)
  }

  val malcolmCharm = SkillFactory.basicSkill(
    Charm,
    tenSidedDice.roll.value,
    sixSidedDice.roll.value
  )

  val hughCharm = SkillFactory.basicSkill(
    Charm,
    tenSidedDice.roll.value,
    sixSidedDice.roll.value
  )

  val result5 =
    skillRollChecker.check(
      malcolmCharm,
      BonusDice(1),
      PenaltyDice(0),
      hughCharm,
      BonusDice(0),
      PenaltyDice(0)
    )

  val sceneResult5 = if (result5.attacker.successful) {
    "Malcolm"
  } else if (result5.defender.successful) {
    "Hugh"
  } else {
    "No"
  }

  val scene5 = s"""
  | Two rival investigators, Malcolm and Hugh,
  | are vying for the affection of Lady Greene.
  | Only one can gain her hand in marriage,
  | thus the Keeper determines that an opposed roll is needed
  | to determine the outcome of their wooing.
  | It is decided that each should make an opposed Charm roll.
  | The Keeper reviews the events of the scenario so far:
  | Malcolm has visited Lady Greene twice,
  | each time lavishing expensive gifts upon her,
  | while Hugh has only visited once and brought no gifts at all.
  | The Keeper states that Malcolm has an advantage
  | and will get a bonus die in the opposed roll.
  | Malcolm ${Charm} is ${malcolmCharm.value()}
  | Hugh ${Charm} is ${hughCharm.value()}
  | Malcolm rolled ${result5.attacker.checked.rolled.value} ${result5.attacker.checked.result}
  | Hugh rolled ${result5.defender.checked.rolled.value} ${result5.defender.checked.result}
  | $sceneResult5 proposal of marriage to Lady Greene is accepted.
  """.stripMargin

  println(scene5)

  val developmentPhaseResults = s"""
  | A game has finished after a couple of sessions of play,
  | and Harvey has checks against several skills.
  | ${developmentPhase(harveyPsychology)}
  | ${developmentPhase(harveyElectricalRepair)}
  | ${developmentPhase(harveyMechanicalRepair)}
  | ${developmentPhase(harveyPersuade)}
  """.stripMargin

  println(developmentPhaseResults)

  def developmentPhase[A <: ImprovableSkillName](
      skill: SkillImprovable[A]
  ): String = {
    skill.improvementCheck match {
      case SkillImproved(
            name,
            value,
            improvement,
            Some(diceRolled),
            isSanityGainEligible
          ) =>
        s"${name}(${value}) improved by ${improvement} with a roll of ${diceRolled.value}"
      case SkillImproved(
            name,
            value,
            improvement,
            None,
            isSanityGainEligible
          ) =>
        s"${name}(${value}) was not used with success"
    }
  }
}
