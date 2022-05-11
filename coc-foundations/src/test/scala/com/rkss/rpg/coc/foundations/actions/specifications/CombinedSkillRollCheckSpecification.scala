package com.rkss.rpg.coc.foundations.actions

import com.rkss.rpg.coc.concepts.roll._
import com.rkss.rpg.coc.foundations.results._

final case class CombinedSkillRollCheckSpecification(
    checkable1: SkillRollCheckable[SkillRollNaming],
    checkable2: SkillRollCheckable[SkillRollNaming],
    rolled: Seq[Int],
    expected: CombinedSkillRollChecked[SkillRollNaming, SkillRollNaming],
    markUsedWithSuccess: Seq[Boolean]
)
