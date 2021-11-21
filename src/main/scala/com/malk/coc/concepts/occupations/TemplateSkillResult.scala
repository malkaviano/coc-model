package com.malk.coc.concepts.occupations

import com.malk.coc.traits.Skill

final case class TemplateSkillResult(
    val occupationFixedSkills: Set[Skill],
    val occupationChooseSkills: Seq[(Int, Seq[(Int, Set[Skill])])],
    val personalSkills: Set[Skill],
    val cannotSpendPointsSkills: Set[Skill],
    val excludedSkills: Set[Skill]
)
