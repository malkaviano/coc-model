package com.rkss.rpg.coc.fundamentals.skills

import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.behaviors.skill._
import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.concepts.skill.allocation._
import com.rkss.rpg.coc.behaviors._

final case class CreditRatingSkillImpl(
    override val baseValue: Int,
    override val occupationPoints: Int,
    override val personalPoints: Int
) extends SystemSkill[CreditRating.type]
    with SkillRollBehavior[CreditRating.type]
    with SkillPushable[CreditRating.type]
    with PushableSkillRollBehavior[CreditRating.type]
    with WithDifficultyValueBehavior
    with WithModificationValueBehavior[CreditRating.type]
    with SkillWithPointsAllocation {
  override val name = CreditRating
  override val tags: Seq[SkillTag] = Seq.empty[SkillTag]
}
