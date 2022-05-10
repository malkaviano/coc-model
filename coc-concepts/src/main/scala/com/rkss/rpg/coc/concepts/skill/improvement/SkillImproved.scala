package com.rkss.rpg.coc.concepts.skill.improvement

import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.concepts._

final case class SkillImproved[A <: SkillName](
    val name: A,
    val value: Int,
    val improvement: Int,
    val rolled: Option[DiceRolled],
    val isSanityGainEligible: Boolean
)
