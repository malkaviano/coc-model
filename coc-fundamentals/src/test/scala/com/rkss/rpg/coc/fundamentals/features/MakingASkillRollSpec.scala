package com.rkss.rpg.coc.fundamentals.features

import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.GivenWhenThen
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.coc.fundamentals.scenarios._
import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.fundamentals.specs._
import com.rkss.rpg.coc.fundamentals.characteristics._
import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.fundamentals.skills._
import com.rkss.rpg.coc.concepts.characteristic._

final class MakingASkillRollSpec
    extends AnyFeatureSpec
    with GivenWhenThen
    with Matchers
    with SkillRollScenario {

  info("As a player I want to make a skill roll")
  info("So I can check if I succeeded using my skill or characteristic")

  Seq(
    SkillRollSpec(
      PrimaryCharacteristic(Strength, 50),
      RegularDifficulty,
      BonusDice(0),
      PenaltyDice(0),
      Seq(10),
      ExtremeSuccess,
      SkillRollDiceResult(10)
    ),
    SkillRollSpec(
      BasicSkill(Accounting, 5, 20, 15),
      RegularDifficulty,
      BonusDice(0),
      PenaltyDice(1),
      Seq(12, 15),
      HardSuccess,
      SkillRollDiceResult(15, Seq(12))
    ),
    SkillRollSpec(
      BasicSkill(FirstAid, 30, 20, 20),
      HardDifficulty,
      BonusDice(2),
      PenaltyDice(0),
      Seq(50, 40, 30),
      RegularSuccess,
      SkillRollDiceResult(30, Seq(40, 50))
    ),
    SkillRollSpec(
      CombatSkill(SubmachineGun, 15, 20, 20),
      ExtremeDifficulty,
      BonusDice(2),
      PenaltyDice(0),
      Seq(50, 40, 30),
      Failure,
      SkillRollDiceResult(30, Seq(40, 50))
    ),
    SkillRollSpec(
      CombatSkill(Dodge, 20, 20, 20),
      ExtremeDifficulty,
      BonusDice(1),
      PenaltyDice(1),
      Seq(50),
      Failure,
      SkillRollDiceResult(50)
    )
  ).foreach(spec => ScenariosFor(makingASkillRoll(spec)))
}
