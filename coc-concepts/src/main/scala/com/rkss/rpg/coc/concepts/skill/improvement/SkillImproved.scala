package com.rkss.rpg.coc.concepts.skill.improvement

import com.rkss.rpg.coc.concepts.skill.roll._

final case class SkillImproved(
    val improvement: Int,
    val rolled: Option[SkillRollDiceResult],
    val isSanityGainEligible: Boolean
)
