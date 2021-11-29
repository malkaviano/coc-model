package com.malk.coc.abstractions

import com.malk.coc.traits.Skill

final case class OccupationTemplateChoice(val take: Int, val options: Set[Skill])