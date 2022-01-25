package com.rkss.rpg.coc.concepts.characteristic

import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.concepts._

trait PrimaryCharacteristic
    extends EntityWithDifficultyValue
    with EntityWithModificationValue
    with ModifiableValue
    with SkillRollable
    with SkillPushable {
  def name: CharacteristicName
}