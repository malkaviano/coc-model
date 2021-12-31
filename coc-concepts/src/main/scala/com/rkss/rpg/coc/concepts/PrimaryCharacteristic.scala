package com.rkss.rpg.coc.concepts

import com.rkss.rpg.coc.concepts.skill.roll._

private[coc] trait PrimaryCharacteristic
    extends EntityWithDifficultyValue
    with SkillRollable
    with SkillPushable {
  def name: String
}
