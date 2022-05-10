package com.rkss.rpg.coc.concepts.skill.roll

import com.rkss.rpg.coc.concepts.internal._

trait SkillRollCheckable[+A <: SkillRollNaming]
    extends WithDifficultyValue
    with WithModificationValue
    with WithNaming[A]
    with SkillRollable[A]
