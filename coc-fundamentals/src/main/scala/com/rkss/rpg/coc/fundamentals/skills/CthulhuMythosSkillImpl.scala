package com.rkss.rpg.coc.fundamentals.skills

import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.behaviors.skill._
import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.behaviors._

final case class CthulhuMythosSkillImpl()
    extends SystemSkill[CthulhuMythos.type]
    with SkillRollBehavior[CthulhuMythos.type]
    with SkillPushable[CthulhuMythos.type]
    with PushableSkillRollBehavior[CthulhuMythos.type]
    with WithDifficultyValueBehavior
    with WithValueModificationBehavior[CthulhuMythos.type] {
  override val name = CthulhuMythos
  override val baseValue: Int = 0
  override val tags: Seq[SkillTag] = Seq.empty[SkillTag]
}
