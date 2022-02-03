package com.rkss.rpg.coc.helpers.wrappers

import com.rkss.rpg.coc.concepts.skill._

final case class SkillInfo(
    val baseValue: Int,
    val tags: Seq[SkillTag] = Seq.empty[SkillTag]
)
