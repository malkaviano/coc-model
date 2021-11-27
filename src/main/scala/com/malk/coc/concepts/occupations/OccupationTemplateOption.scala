package com.malk.coc.concepts.occupations

import com.malk.coc.traits.Skill

final case class OccupationTemplateOption(val take: Int, val options: Set[Skill])