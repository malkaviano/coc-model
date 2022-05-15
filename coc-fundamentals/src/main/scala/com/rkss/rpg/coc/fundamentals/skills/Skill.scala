package com.rkss.rpg.coc.fundamentals.skills

import com.rkss.rpg.coc.fundamentals._
import com.rkss.rpg.coc.concepts.skill._

abstract class Skill[A <: SkillName](
    val name: A,
    val baseValue: Int,
    val occupationPoints: Int,
    val personalPoints: Int,
    val minimum: Int = 0,
    val maximum: Int = 100000
) extends BaseRollable[A](
      name,
      baseValue + occupationPoints + personalPoints,
      minimum,
      maximum
    ) {
  def tags: Seq[SkillTag]
}
