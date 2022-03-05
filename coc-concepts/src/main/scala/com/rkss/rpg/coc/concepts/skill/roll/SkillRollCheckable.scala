package com.rkss.rpg.coc.concepts.skill.roll

import com.rkss.rpg.coc.concepts.commons._

trait SkillRollCheckable[+A <: SkillRollNaming]
    extends EntityWithDifficultyValue
    with EntityWithModificationValue
    with EntityWithNameTag[A]
    with SkillRollable[A]
