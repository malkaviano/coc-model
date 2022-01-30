package com.rkss.rpg.coc.concepts.skill.improvement

import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.concepts.skill._

final case class SkillImproved[A <: SkillName](
    val name: A,
    val value: Int,
    val improvement: Int,
    val rolled: Option[SkillRollDiceResult],
    val isSanityGainEligible: Boolean
)
