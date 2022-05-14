package com.rkss.rpg.script // Package is outside coc on purpose to check visibility

import com.rkss.rpg.coc.helpers.factories._
import com.rkss.rpg.coc.concepts.skill._

object SampleUsage extends App {
  import com.rkss.rpg.helpers.dice.Bag._

  val harveySpotHidden = SkillFactory.basicSkill(
    SpotHidden,
    tenSidedDice.roll.value,
    sixSidedDice.roll.value
  )

  val harveyPsychology = SkillFactory.basicSkill(
    Psychology,
    tenSidedDice.roll.value,
    sixSidedDice.roll.value
  )
}
