package com.rkss.rpg.coc.foundations.skills

import com.rkss.rpg.coc.concepts._

class SimpleSkill private[foundations](
    val id: Identification,
    val baseValue: Int,
    val occupationPoints: Int,
    val personalPoints: Int
)
