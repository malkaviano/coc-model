package com.rkss.rpg.coc.foundations.actions

import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.GivenWhenThen
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.coc.helpers.factories._
import com.rkss.rpg.coc.concepts.characteristic._
import com.rkss.rpg.coc.foundations.results._
import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.concepts.results._

final class AidedSkillRollCheckFeature
    extends AnyFeatureSpec
    with GivenWhenThen
    with Matchers
    with AidedSkillRollCheckScenario {
  info("I want to execute an action")
  info("But the value is beyond human limits")
  info("So others contribute to diminish to humanly possible")
  info("The characteristic opposing after diminishing sets the difficulty")
  info("The keeper decides the bonus and penalty dice")
  info("I do a skill roll to check if the action was successful")
  info(
    "And in case of success I mark my skill with a tick if no bonus dice was used"
  )

  Seq(
    AidedSkillRollCheckSpecification(
      CharacteristicFactory.characteristic(Strength, 70),
      Seq(10),
      SkillRollChecked(
        true,
        SkillRolled(
          Strength,
          14,
          ExtremeDifficulty,
          BonusDice(0),
          PenaltyDice(0),
          SkillRollExtremeSuccess,
          SkillRollDiceResult(10)
        )
      ),
      false,
      CharacteristicFactory.characteristic(Strength, 200),
      Seq(
        CharacteristicFactory.characteristic(Strength, 20),
        CharacteristicFactory.characteristic(Strength, 20)
      )
    )
  ).foreach(spec => ScenariosFor(makingAnAidedSkillRollCheck(spec)))
}
