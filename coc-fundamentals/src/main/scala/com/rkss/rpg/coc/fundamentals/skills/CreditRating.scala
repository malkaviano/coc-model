package com.rkss.rpg.coc.fundamentals.skills

import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.rules.skill.behaviors._
import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.concepts.skill.allocation._

final case class CreditRatingSkill(
    override val baseValue: Int,
    override val occupationPoints: Int,
    override val personalPoints: Int
) extends Skill[CreditRating.type]
    with SkillRollBehavior[CreditRating.type]
    with SkillPushable[CreditRating.type]
    with PushableSkillRollBehavior[CreditRating.type]
    with WithDifficultyValueBehavior
    with WithModificationValueBehavior[CreditRating.type]
    with SkillWithPointsAllocation {
  override val name = CreditRating
  override val tags: Seq[SkillTag] = Seq.empty[SkillTag]
}
