package com.rkss.rpg.coc.foundations.results

import com.rkss.rpg.coc.concepts.skill.roll._

final case class CombinedSkillRollChecked[A <: SkillRollNaming](
    successful: Boolean,
    checked: Seq[SkillRolled[A]],
    requiredAllToPass: Boolean
)
