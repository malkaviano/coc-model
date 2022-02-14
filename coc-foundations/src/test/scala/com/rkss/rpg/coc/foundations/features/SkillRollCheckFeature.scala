package com.rkss.rpg.coc.foundations.features

import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.GivenWhenThen
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.coc.helpers.factories._
import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.concepts.results._
import com.rkss.rpg.coc.foundations.results._
import com.rkss.rpg.coc.foundations.specifications._
import com.rkss.rpg.coc.foundations.scenarios._
import com.rkss.rpg.coc.concepts.characteristic.Strength

final class SkillRollCheckFeature
    extends AnyFeatureSpec
    with GivenWhenThen
    with Matchers
    with SkillRollCheckScenario {

  info("I want to execute an action")
  info("The keeper asks for a skill roll")
  info("The keeper decides the difficulty")
  info("The keeper decides the bonus and penalty dice")
  info("I do a skill roll to check if the action was successful")
  info(
    "And in case of success I mark my skill with a tick if no bonus dice was used"
  )

  Seq(
    SkillRollCheckSpec(
      SkillFactory.basicSkill(ComputerUse, 10, 5),
      Seq(10, 5),
      SkillRollChecked(
        true,
        SkillRolled(
          ComputerUse,
          20,
          RegularDifficulty,
          BonusDice(1),
          PenaltyDice(2),
          SkillRollHardSuccess,
          SkillRollDiceResult(10, Seq(5))
        )
      ),
      true
    ),
    SkillRollCheckSpec(
      CharacteristicFactory.characteristic(Strength, 50),
      Seq(10, 40),
      SkillRollChecked(
        true,
        SkillRolled(
          Strength,
          25,
          HardDifficulty,
          BonusDice(1),
          PenaltyDice(0),
          SkillRollHardSuccess,
          SkillRollDiceResult(10, Seq(40))
        )
      ),
      false
    ),
    SkillRollCheckSpec(
      SkillFactory.combatSkill(Brawl, 10, 5),
      Seq(1, 15),
      SkillRollChecked(
        true,
        SkillRolled(
          Brawl,
          20,
          HardDifficulty,
          BonusDice(1),
          PenaltyDice(0),
          SkillRollCriticalSuccess,
          SkillRollDiceResult(1, Seq(15))
        )
      ),
      false
    ),
    SkillRollCheckSpec(
      SkillFactory.languageOtherSkill(RussianLanguage, 10, 5),
      Seq(40, 80),
      SkillRollChecked(
        false,
        SkillRolled(
          RussianLanguage,
          3,
          ExtremeDifficulty,
          BonusDice(1),
          PenaltyDice(1),
          SkillRollFailure,
          SkillRollDiceResult(40)
        )
      ),
      false
    )
  ).foreach(spec => ScenariosFor(makingASkillRollCheck(spec)))
}