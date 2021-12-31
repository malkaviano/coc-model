package com.rkss.rpg.coc.concepts.skill

import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.concepts.RollableEntity

trait Skill extends RollableEntity with SkillRollable {
  def name: String

  def occupationPoints: Int

  def personalPoints: Int
}
