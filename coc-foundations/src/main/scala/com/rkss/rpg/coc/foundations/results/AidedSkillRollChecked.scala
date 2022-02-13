package com.rkss.rpg.coc.foundations.results

import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.concepts.skill.roll._

final case class AidedSkillRollChecked[A <: SkillName, B <: SkillName](
    successful: Boolean,
    check: SkillRolled[A],
    aidedBy: Seq[Skill[_]],
    opposedBy: Skill[B],
    opposedValue: Int
)
