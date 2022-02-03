package com.rkss.rpg.coc.concepts.skill

import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.concepts._

trait Skill[A <: SkillName]
    extends EntityWithDifficultyValue
    with SkillRollable[A]
    with EntityWithModificationValue
    with EntityWithModifiableValue[A]
    with EntityWithNameTag[A] {
  def tags: Seq[SkillTag]
}
