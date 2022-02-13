package com.rkss.rpg.coc.foundations.results

import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.concepts.skill.roll._

final case class CombinedSkillRollChecked[A <: SkillName](
      successful: Boolean,
      check: Seq[SkillRolled[A]]
  )