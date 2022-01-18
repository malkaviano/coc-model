package com.rkss.rpg.coc.foundations.features

import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.GivenWhenThen
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.coc.foundations.specs.scenarios._
import com.rkss.rpg.coc.foundations.characteristics._
import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.foundations.specs._
import com.rkss.rpg.helpers.dice.HundredSidedDice
import com.rkss.rpg.coc.rules.testing.TestingProps
import com.rkss.rpg.coc.foundations.skills.BasicSkill
import com.rkss.rpg.coc.concepts.skill._

final class PushingASkillRollSpec
    extends AnyFeatureSpec
    with GivenWhenThen
    with Matchers
    with PushSkillRollScenario {

  info("As a player I want to push a skill roll")
  info("So I can try to succeeded my previous failed roll")

  val fumble = new BasicSkill(Track, 5, 10, 0)

  fumble.roll()(HundredSidedDice(TestingProps.fakeRng(Seq(100))))

  val success = new BasicSkill(Mathematics, 5, 30, 15)

  success.roll()(HundredSidedDice(TestingProps.fakeRng(Seq(1))))

  val failure = new BasicSkill(MechanicalRepair, 1, 20, 14)

  failure.roll(penaltyDice = PenaltyDice(1))(
    HundredSidedDice(TestingProps.fakeRng(Seq(95, 80)))
  )

  val failure2 = new BasicSkill(Physics, 5, 20, 14)

  failure2.roll(bonusDice = BonusDice(1))(
    HundredSidedDice(TestingProps.fakeRng(Seq(95, 80)))
  )

  Seq(
    // No previous roll
    PushSkillRollSpec(
      Dexterity(50),
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
          failure,
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
          failure2,
          RegularDifficulty,
          BonusDice(1),
          PenaltyDice(2),
          Failure,
          SkillRollDiceResult(55, Seq(12)),
          true
        )
      )
    )
  ).foreach(spec => ScenariosFor(pushingASkillRoll(spec)))
}
