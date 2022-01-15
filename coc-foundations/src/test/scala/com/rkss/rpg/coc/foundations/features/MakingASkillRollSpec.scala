package com.rkss.rpg.coc.foundations.features

import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.GivenWhenThen
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.coc.foundations.specs.scenarios.SkillRollScenario
import com.rkss.rpg.coc.foundations.characteristics._
import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.foundations.specs._
import com.rkss.rpg.coc.foundations.skills._
import com.rkss.rpg.coc.concepts._

final class MakingASkillRollSpec
    extends AnyFeatureSpec
    with GivenWhenThen
    with Matchers
    with SkillRollScenario {

  info("As a player I want to make a skill roll")
  info("So I can check if I succeeded using my skill or characteristic")

  Seq(
    SkillRollSpec(
      AnyCharacteristic(CharacteristicStrength, 50),
      RegularDifficulty,
      BonusDice(0),
      PenaltyDice(0),
      Seq(10),
      ExtremeSuccess,
      SkillRollDiceResult(10)
    ),
    SkillRollSpec(
      SimpleSkill(SkillAccounting, 5, 20, 15),
      RegularDifficulty,
      BonusDice(0),
      PenaltyDice(1),
      Seq(12, 15),
      HardSuccess,
      SkillRollDiceResult(15, Seq(12))
    ),
    SkillRollSpec(
      CombatSkill(SkillHandgun, 20, 20, 10),
      HardDifficulty,
      BonusDice(2),
      PenaltyDice(1),
      Seq(50, 25),
      RegularSuccess,
      SkillRollDiceResult(25, Seq(50))
    )
  ).foreach(spec => ScenariosFor(makingASkillRoll(spec)))
}
