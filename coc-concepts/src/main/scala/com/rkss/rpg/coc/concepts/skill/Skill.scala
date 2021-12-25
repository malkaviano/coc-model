package com.rkss.rpg.coc.concepts.skill

import com.rkss.rpg.coc.concepts.skill.roll._

trait Skill extends SkillRollable {
  def name: String

  def baseValue: Int
}
