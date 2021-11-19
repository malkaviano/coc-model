package com.malk.coc.occupations

import com.malk.coc.concepts.skills.CreditRating
import com.malk.coc.traits.Skill

final case class Occupation(
    val name: String,
    val occupationSkills: Set[Skill],
    val creditRating: CreditRating
)
