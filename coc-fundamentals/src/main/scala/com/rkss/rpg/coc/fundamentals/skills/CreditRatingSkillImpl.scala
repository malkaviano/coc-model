package com.rkss.rpg.coc.fundamentals.skills

import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.behaviors.skill._

final case class CreditRatingSkillImpl(
    override val baseValue: Int,
    override val occupationPoints: Int,
    override val personalPoints: Int
) extends Skill[CreditRating.type](
      CreditRating,
      baseValue,
      occupationPoints,
      personalPoints
    )
    with SkillRollBehavior[CreditRating.type] {
  override val tags: Seq[SkillTag] = Seq.empty[SkillTag]
}
