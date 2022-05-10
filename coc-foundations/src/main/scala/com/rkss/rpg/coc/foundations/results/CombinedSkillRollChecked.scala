package com.rkss.rpg.coc.foundations.results

import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.concepts.results._

final case class CombinedSkillRollChecked[
    A <: SkillRollNaming,
    B <: SkillRollNaming
](
    successful: Boolean,
    checked1: SkillRolled[A],
    checked2: SkillRolled[B],
    requiredAllToPass: Boolean
)
