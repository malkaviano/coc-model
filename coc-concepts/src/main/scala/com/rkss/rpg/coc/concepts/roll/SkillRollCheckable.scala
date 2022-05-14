package com.rkss.rpg.coc.concepts.roll

import com.rkss.rpg.coc.concepts.internal._

trait SkillRollCheckable[+A <: SkillRollNaming]
    extends WithNaming[A]
    with SkillRollable[A]
