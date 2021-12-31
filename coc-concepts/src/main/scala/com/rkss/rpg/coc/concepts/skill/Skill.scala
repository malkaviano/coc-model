package com.rkss.rpg.coc.concepts.skill

import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.concepts.EntityWithDifficultyValue

trait Skill extends EntityWithDifficultyValue with SkillRollable {
  def name: String

  def occupationPoints: Int

  def personalPoints: Int
}
