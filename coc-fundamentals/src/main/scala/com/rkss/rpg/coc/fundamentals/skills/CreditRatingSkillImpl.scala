package com.rkss.rpg.coc.fundamentals.skills

import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.behaviors.skill._
import com.rkss.rpg.coc.fundamentals._

final case class CreditRatingSkillImpl(
    val baseValue: Int,
    val occupationPoints: Int,
    val personalPoints: Int
) extends BaseRollable[CreditRating.type](
      CreditRating,
      baseValue + occupationPoints + personalPoints
    )
    with SystemSkill[CreditRating.type]
    with SkillRollBehavior[CreditRating.type] {
  override val tags: Seq[SkillTag] = Seq.empty[SkillTag]
}
