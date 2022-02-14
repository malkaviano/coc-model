package com.rkss.rpg.coc.foundations.results

import com.rkss.rpg.coc.concepts.skill.roll._

final case class SkillRollChecked[A <: SkillRollNaming](
    successful: Boolean,
    checked: SkillRolled[A]
)
