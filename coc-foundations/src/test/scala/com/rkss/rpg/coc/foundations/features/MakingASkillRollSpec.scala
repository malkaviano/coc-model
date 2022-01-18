package com.rkss.rpg.coc.foundations.features

import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.GivenWhenThen
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.coc.foundations.specs.scenarios.SkillRollScenario
import com.rkss.rpg.coc.foundations.characteristics._
import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.foundations.specs._
import com.rkss.rpg.coc.foundations.skills._

final class MakingASkillRollSpec
    extends AnyFeatureSpec
    with GivenWhenThen
    with Matchers
    with SkillRollScenario {

  info("As a player I want to make a skill roll")
  info("So I can check if I succeeded using my skill or characteristic")

  Seq(
    SkillRollSpec(
      Strength(50),
      RegularDifficulty,
      BonusDice(0),
      PenaltyDice(0),
      Seq(10),
      ExtremeSuccess,
      SkillRollDiceResult(10)
    ),
    SkillRollSpec(
      BasicSkill(5, 20, 15),
      RegularDifficulty,
      BonusDice(0),
      PenaltyDice(1),
      Seq(12, 15),
      HardSuccess,
      SkillRollDiceResult(15, Seq(12))
    ),
    SkillRollSpec(
      BasicSkill(30, 20, 20),
      HardDifficulty,
      BonusDice(2),
      PenaltyDice(0),
      Seq(50, 40, 30),
      RegularSuccess,
      SkillRollDiceResult(30, Seq(40, 50))
    ),
    SkillRollSpec(
      CombatSkill(15, 20, 20),
      ExtremeDifficulty,
      BonusDice(2),
      PenaltyDice(0),
      Seq(50, 40, 30),
      Failure,
      SkillRollDiceResult(30, Seq(40, 50))
    )
  ).foreach(spec => ScenariosFor(makingASkillRoll(spec)))
}
