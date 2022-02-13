package com.rkss.rpg.coc.foundations.specifications

import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.foundations.results._

final case class CombinedSkillRollCheckSpec[A <: SkillRollNaming](
  checkables: Seq[SkillRollCheckable[A]],
  rolled: Seq[Int],
  expected: CombinedSkillRollChecked[A],
  allMustPass: Boolean,
  markUsedWithSuccess: Seq[Boolean]
)