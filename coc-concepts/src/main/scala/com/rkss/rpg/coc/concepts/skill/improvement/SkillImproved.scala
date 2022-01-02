package com.rkss.rpg.coc.concepts.skill.improvement

import com.rkss.rpg.coc.concepts.skill.Skill
import com.rkss.rpg.coc.concepts.skill.roll.SkillRollDiceResult

final case class SkillImproved(
    val skillTested: Skill,
    val improvedValue: Int,
    val rolled: Option[SkillRollDiceResult],
    val sanityGained: Boolean
)
