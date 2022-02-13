package com.rkss.rpg.coc.foundations.specifications

import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.foundations.results._

final case class SkillRollCheckSpec[A <: SkillRollNaming](
  checkable: SkillRollCheckable[A],
  rolled: Seq[Int],
  expected: SkillRollChecked[A],
  markUsedWithSuccess: Boolean
)