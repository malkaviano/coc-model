package com.rkss.rpg.coc.concepts

import com.rkss.rpg.coc.concepts.skill.roll._

trait PrimaryCharacteristic
    extends EntityWithDifficultyValue
    with EntityWithModificationValue
    with ModifiableValue
    with SkillRollable
    with SkillPushable
