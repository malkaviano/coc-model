package com.rkss.rpg.coc.concepts.skill.improvement

import com.rkss.rpg.helpers.traits.DiceResult
import com.rkss.rpg.coc.concepts.skill.Skill

final case class SkillImprovementResult(
    val skillTested: Skill,
    val improvedValue: Int,
    val result: Option[DiceResult],
    val sanityGained: Boolean
)
