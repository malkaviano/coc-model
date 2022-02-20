package com.rkss.rpg.coc.foundations.specifications

import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.foundations.results._

final case class CombinedSkillRollCheckSpec(
  checkable1: SkillRollCheckable[SkillRollNaming],
  checkable2: SkillRollCheckable[SkillRollNaming],
  rolled: Seq[Int],
  expected: CombinedSkillRollChecked[SkillRollNaming, SkillRollNaming],
  markUsedWithSuccess: Seq[Boolean]
)