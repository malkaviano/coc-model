package com.rkss.rpg.coc.concepts.skill

import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.concepts._

trait Skill[A <: SkillName]
    extends EntityWithDifficultyValue
    with SkillRollable
    with EntityWithModificationValue
    with GenericEntityWithModifiableValue[A]
    with EntityWithNameTag {
  def tags: Seq[SkillTag]
}
