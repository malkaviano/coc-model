package com.rkss.rpg.coc.foundations.skills

import com.rkss.rpg.coc.concepts.skill._

class SimpleSkill private[foundations](
    val baseValue: Int,
    val occupationPoints: Int,
    val personalPoints: Int,
    val tags: Seq[SkillTag] = Seq.empty[SkillTag]
)
