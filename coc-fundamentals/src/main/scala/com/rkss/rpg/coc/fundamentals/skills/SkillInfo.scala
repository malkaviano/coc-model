package com.rkss.rpg.coc.fundamentals.skills

import com.rkss.rpg.coc.concepts.skill._

final case class SkillInfo(
    val baseValue: Int,
    val tags: Seq[SkillTag] = Seq.empty[SkillTag]
)
