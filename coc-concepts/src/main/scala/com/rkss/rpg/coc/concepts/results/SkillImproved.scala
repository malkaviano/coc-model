package com.rkss.rpg.coc.concepts.results

import com.rkss.rpg.coc.concepts.skill._

final case class SkillImproved[A <: ImprovableSkillName](
    val name: A,
    val value: Int,
    val improvement: Int,
    val rolled: Option[DiceRolled],
    val isSanityGainEligible: Boolean
)
