package com.rkss.rpg.coc.fundamentals.features

import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.GivenWhenThen
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.coc.fundamentals.scenarios._
import com.rkss.rpg.coc.fundamentals.characteristics._
import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.fundamentals.specs._
import com.rkss.rpg.helpers.dice.HundredSidedDice
import com.rkss.rpg.coc.rules.testing.TestingProps
import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.fundamentals.skills._
import com.rkss.rpg.coc.concepts.characteristic._

final class PushingASkillRollSpec
    extends AnyFeatureSpec
    with GivenWhenThen
    with Matchers
    with PushSkillRollScenario {

  info("As a player I want to push a skill roll")
  info("So I can try to succeeded my previous failed roll")

  val fumble = BasicSkill(Track, 10, 10, 0)

  fumble.roll()(HundredSidedDice(TestingProps.fakeRng(Seq(100))))

  val success = BasicSkill(Disguise, 5, 30, 15)

  success.roll()(HundredSidedDice(TestingProps.fakeRng(Seq(1))))

  val failure = BasicSkill(MechanicalRepair, 10, 20, 14)

  failure.roll(penaltyDice = PenaltyDice(1))(
    HundredSidedDice(TestingProps.fakeRng(Seq(95, 80)))
  )

  val failure2 = BasicSkill(History, 5, 20, 14)

  failure2.roll(bonusDice = BonusDice(1))(
    HundredSidedDice(TestingProps.fakeRng(Seq(95, 80)))
  )

  val criticalSuccess = BasicSkill(SpanishLanguage, 1,10, 5, Seq(LanguageOther))

  criticalSuccess.roll()(HundredSidedDice(TestingProps.fakeRng(Seq(95))))

  val hardSuccess =
    BasicSkill(RussianLanguage, 60, 10, 5, Seq(LanguageOwn))

  hardSuccess.roll()(HundredSidedDice(TestingProps.fakeRng(Seq(95))))

  Seq(
    // No previous roll
    PushSkillRollSpec(
      PrimaryCharacteristic(Dexterity, 50),
      Option(HardDifficulty),
      Option(BonusDice(1)),
      Option(PenaltyDice(2)),
      Seq(10),
      ExtremeSuccess,
      SkillRollDiceResult(10),
      None
    ),
    // Fumble
    PushSkillRollSpec(
      fumble,
      None,
      None,
      None,
      Seq(10),
      ExtremeSuccess,
      SkillRollDiceResult(10),
      None
    ),
    // Rolled Success
    PushSkillRollSpec(
      success,
      None,
      Option(BonusDice(2)),
      None,
      Seq(10),
      ExtremeSuccess,
      SkillRollDiceResult(10),
      None
    ),
    // Failures\
    PushSkillRollSpec(
      failure,
      None,
      None,
      None,
      Seq(10, 12),
      HardSuccess,
      SkillRollDiceResult(12, Seq(10)),
      Some(
        SkillRolled(
          failure.name,
          failure.value(),
          RegularDifficulty,
          BonusDice(0),
          PenaltyDice(1),
          HardSuccess,
          SkillRollDiceResult(12, Seq(10)),
          true
        )
      )
    ),
    PushSkillRollSpec(
      failure2,
      None,
      Option(BonusDice(1)),
      Option(PenaltyDice(2)),
      Seq(55, 12),
      Failure,
      SkillRollDiceResult(55, Seq(12)),
      Some(
        SkillRolled(
          failure2.name,
          failure2.value(),
          RegularDifficulty,
          BonusDice(1),
          PenaltyDice(2),
          Failure,
          SkillRollDiceResult(55, Seq(12)),
          true
        )
      )
    ),
    PushSkillRollSpec(
      criticalSuccess,
      None,
      Option(BonusDice(0)),
      Option(PenaltyDice(0)),
      Seq(1),
      Failure,
      SkillRollDiceResult(1),
      Some(
        SkillRolled(
          criticalSuccess.name,
          criticalSuccess.value(),
          RegularDifficulty,
          BonusDice(0),
          PenaltyDice(0),
          CriticalSuccess,
          SkillRollDiceResult(1),
          true
        )
      )
    ),
    PushSkillRollSpec(
      hardSuccess,
      None,
      Option(BonusDice(0)),
      Option(PenaltyDice(0)),
      Seq(25),
      HardSuccess,
      SkillRollDiceResult(25),
      Some(
        SkillRolled(
          hardSuccess.name,
          hardSuccess.value(),
          RegularDifficulty,
          BonusDice(0),
          PenaltyDice(0),
          HardSuccess,
          SkillRollDiceResult(25),
          true
        )
      )
    )
  ).foreach(spec => ScenariosFor(pushingASkillRoll(spec)))
}
