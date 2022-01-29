package com.rkss.rpg.coc.concepts.skill

import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.concepts._

trait Skill
    extends EntityWithDifficultyValue
    with SkillRollable
    with EntityWithModificationValue
    with EntityWithModifiableValue
    with EntityWithNameTag {
  def tags: Seq[SkillTag]
}
