package com.rkss.rpg.coc.concepts.characteristic

import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.concepts._

trait GenericCharacteristic[A <: CharacteristicName]
    extends EntityWithDifficultyValue
    with EntityWithModificationValue
    with GenericEntityWithModifiableValue[A]
    with SkillRollable
    with SkillPushable
    with EntityWithNameTag
