package com.malk.coc.concepts.occupations

import com.malk.coc.traits.Skill

final case class TemplateSkillResult(
    val occupationFixedSkills: Set[Skill],
    val occupationChooseSkills: Seq[OccupationTemplateOption],
    val cannotSpendPointsSkills: Set[Skill],
    val excludedSkills: Set[Skill]
)
