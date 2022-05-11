package com.rkss.rpg.coc.foundations.results

import com.rkss.rpg.coc.concepts.roll._
import com.rkss.rpg.coc.concepts.results._

final case class SkillRollChecked[A <: SkillRollNaming](
    successful: Boolean,
    checked: SkillRolled[A]
)
