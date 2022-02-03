package com.rkss.rpg.coc.fundamentals.skills

import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.rules.skill.behaviors._
import com.rkss.rpg.coc.concepts.skill.roll._

final case class CthulhuMythosSkill()
    extends Skill[CthulhuMythos.type]
    with SkillRollBehavior[CthulhuMythos.type]
    with SkillPushable[CthulhuMythos.type]
    with PushableSkillRollBehavior[CthulhuMythos.type]
    with WithDifficultyValueBehavior
    with WithModificationValueBehavior[CthulhuMythos.type] {
  override val name = CthulhuMythos
  override val baseValue: Int = 0
  override val tags: Seq[SkillTag] = Seq.empty[SkillTag]
}
