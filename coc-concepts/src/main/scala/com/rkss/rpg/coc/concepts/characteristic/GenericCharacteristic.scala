package com.rkss.rpg.coc.concepts.characteristic

import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.concepts._

trait GenericCharacteristic[A <: CharacteristicName]
    extends EntityWithDifficultyValue
    with EntityWithModificationValue
    with EntityWithModifiableValue[A]
    with SkillRollable[A]
    with SkillPushable[A]
    with EntityWithNameTag[A]
