package com.rkss.rpg.coc.foundations.features

import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.GivenWhenThen
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.coc.foundations.specifications._
import com.rkss.rpg.coc.foundations.scenarios._
import com.rkss.rpg.coc.helpers.factories._
import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.foundations.results._
import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.concepts.results._
import com.rkss.rpg.coc.concepts.characteristic._

final class CombinedSkillRollCheckFeature
    extends AnyFeatureSpec
    with GivenWhenThen
    with Matchers
    with CombinedSkillRollCheckScenario {

  info("I want to execute an action")
  info("The keeper asks for a skill roll using two skills")
  info(
    "The keeper decides if both skill rolls need to be a success or just one"
  )
  info("The keeper decides the difficulty")
  info("The keeper decides the bonus and penalty dice")
  info("I do a skill roll to check if the action was successful")
  info(
    "And in case of success I mark the skills that succeeded with a tick if no bonus dice was used"
  )

  import com.rkss.rpg.coc.helpers.converters.SkillConversion.implicits._

  val computerUse = SkillFactory
    .basicSkill(ComputerUse, 10, 5)

  val mathematics = SkillFactory
    .basicSkill(Mathematics, 10, 0)

  val education =
    CharacteristicFactory
      .characteristic(Education, 30)

  val intimidate =
    SkillFactory
      .basicSkill(Intimidate, 0, 0)

  Seq(
    CombinedSkillRollCheckSpec(
      computerUse,
      mathematics,
      Seq(10),
      CombinedSkillRollChecked(
        true,
        SkillRolled(
          ComputerUse,
          20,
          RegularDifficulty,
          BonusDice(0),
          PenaltyDice(0),
          SkillRollHardSuccess,
          SkillRollDiceResult(10)
        ),
        SkillRolled(
          Mathematics,
          11,
          RegularDifficulty,
          BonusDice(0),
          PenaltyDice(0),
          SkillRollRegularSuccess,
          SkillRollDiceResult(10)
        ),
        true
      ),
      Seq(true, true)
    ),
    CombinedSkillRollCheckSpec(
      education,
      intimidate,
      Seq(100),
      CombinedSkillRollChecked(
        false,
        SkillRolled(
          Education,
          30,
          RegularDifficulty,
          BonusDice(0),
          PenaltyDice(0),
          SkillRollFumble,
          SkillRollDiceResult(100)
        ),
        SkillRolled(
          Intimidate,
          15,
          RegularDifficulty,
          BonusDice(0),
          PenaltyDice(0),
          SkillRollFumble,
          SkillRollDiceResult(100)
        ),
        false
      ),
      Seq(false, false)
    )
  ).foreach(spec => ScenariosFor(makingACombinedSkillRollCheck(spec)))
}
