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
import com.rkss.rpg.coc.concepts.internal._
import com.rkss.rpg.coc.concepts.results._

final class MakingASkillRollSpec
    extends AnyFeatureSpec
    with GivenWhenThen
    with Matchers
    with SkillRollScenario {

  info("As a player I want to make a skill roll")
  info("So I can check if I succeeded using my skill or characteristic")

  val mythos = CthulhuMythosSkillImpl()

  mythos.modify(ValueModification(CthulhuMythos, 10))

  Seq(
    SkillRollSpec(
      PrimaryCharacteristic(Strength, 50),
      RegularDifficulty,
      BonusDice(0),
      PenaltyDice(0),
      Seq(10),
      SkillRollExtremeSuccess,
      SkillRollDiceResult(10)
    ),
    SkillRollSpec(
      SkillImpl(Accounting, 5, 20, 15),
      RegularDifficulty,
      BonusDice(0),
      PenaltyDice(1),
      Seq(12, 15),
      SkillRollHardSuccess,
      SkillRollDiceResult(15, Seq(12))
    ),
    SkillRollSpec(
      SkillImpl(FirstAid, 30, 20, 20),
      HardDifficulty,
      BonusDice(2),
      PenaltyDice(0),
      Seq(50, 40, 30),
      SkillRollHardSuccess,
      SkillRollDiceResult(30, Seq(40, 50))
    ),
    SkillRollSpec(
      SkillImpl(SubmachineGun, 15, 20, 20),
      ExtremeDifficulty,
      BonusDice(2),
      PenaltyDice(0),
      Seq(50, 40, 30),
      SkillRollFailure,
      SkillRollDiceResult(30, Seq(40, 50))
    ),
    SkillRollSpec(
      SkillImpl(Dodge, 20, 20, 20),
      ExtremeDifficulty,
      BonusDice(1),
      PenaltyDice(1),
      Seq(50),
      SkillRollFailure,
      SkillRollDiceResult(50)
    ),
    SkillRollSpec(
      mythos,
      RegularDifficulty,
      BonusDice(1),
      PenaltyDice(0),
      Seq(50, 30),
      SkillRollFailure,
      SkillRollDiceResult(30, Seq(50))
    )
  ).foreach(spec => ScenariosFor(makingASkillRoll(spec)))
}
