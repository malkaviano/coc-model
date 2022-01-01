package com.rkss.rpg.coc.concepts.skill

import com.rkss.rpg.helpers.traits.DiceResult

final case class SkillImprovementResult(
    val skillTested: Skill,
    val improvedValue: Int,
    val result: Option[DiceResult],
    val sanityGained: Boolean
)
