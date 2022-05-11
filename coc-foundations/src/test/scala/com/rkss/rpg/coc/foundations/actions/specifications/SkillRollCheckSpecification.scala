package com.rkss.rpg.coc.foundations.actions

import com.rkss.rpg.coc.concepts.roll._
import com.rkss.rpg.coc.foundations.results._

final case class SkillRollCheckSpecification[A <: SkillRollNaming](
    checkable: SkillRollCheckable[A],
    rolled: Seq[Int],
    expected: SkillRollChecked[A],
    markUsedWithSuccess: Boolean,
    opposing: Option[SkillRollCheckable[SkillRollNaming]] =
      Option.empty[SkillRollCheckable[SkillRollNaming]]
)
