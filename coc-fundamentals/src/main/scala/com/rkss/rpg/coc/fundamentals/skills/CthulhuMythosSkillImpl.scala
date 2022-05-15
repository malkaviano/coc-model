package com.rkss.rpg.coc.fundamentals.skills

import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.behaviors.skill._
import com.rkss.rpg.coc.fundamentals._

final case class CthulhuMythosSkillImpl()
    extends BaseRollable[CthulhuMythos.type](CthulhuMythos, 0)
    with Skill[CthulhuMythos.type]
    with SkillRollBehavior[CthulhuMythos.type] {
  override val tags: Seq[SkillTag] = Seq.empty[SkillTag]
}
