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

  val skill1 = SkillFactory.basicSkill(ComputerUse, 10, 5).asInstanceOf[SkillRollCheckable[SkillRollNaming]]
  val skill2 = SkillFactory.basicSkill(Mathematics, 10, 0).asInstanceOf[SkillRollCheckable[SkillRollNaming]]

  val skills: Seq[SkillRollCheckable[SkillRollNaming]] = Seq(
      skill1, skill2
  )

  val expected : Seq[SkillRolled[SkillRollNaming]]= Seq(
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
    )
  )

  Seq(
    CombinedSkillRollCheckSpec(
      skills,
      Seq(10),
      CombinedSkillRollChecked(
        true,
        expected,
        true
      ),
      true,
      Seq(true, true)
    )
  ).foreach(spec => ScenariosFor(makingACombinedSkillRollCheck(spec)))
}