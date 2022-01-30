package com.rkss.rpg.coc.concepts.skill.improvement

import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.concepts._

final case class SkillImproved(
    val name: NameTag,
    val value: Int,
    val improvement: Int,
    val rolled: Option[SkillRollDiceResult],
    val isSanityGainEligible: Boolean
)
