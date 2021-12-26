package com.rkss.rpg.coc.concepts

import com.rkss.rpg.coc.concepts.skill.roll._

trait PrimaryCharacteristic extends RollableEntity with SkillRollable with SkillPushable {
  def name: String
}
