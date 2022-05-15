package com.rkss.rpg.coc.fundamentals.skills

import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.behaviors.skill._

final case class CthulhuMythosSkillImpl()
    extends Skill[CthulhuMythos.type](CthulhuMythos, 0, 0, 0)
    with SkillRollBehavior[CthulhuMythos.type] {
  override val tags: Seq[SkillTag] = Seq.empty[SkillTag]
}
