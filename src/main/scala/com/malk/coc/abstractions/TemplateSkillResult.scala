package com.malk.coc.abstractions

import com.malk.coc.traits.Skill

final case class TemplateSkillResult(
    val occupationFixedSkills: Set[Skill],
    val occupationChooseSkills: Seq[OccupationTemplateChoice],
    val cannotSpendPointsSkills: Set[Skill],
    val excludedSkills: Set[Skill]
)
