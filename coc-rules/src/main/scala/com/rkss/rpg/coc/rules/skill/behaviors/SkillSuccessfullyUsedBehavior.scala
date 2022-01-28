package com.rkss.rpg.coc.rules.skill.behaviors

import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.concepts.skill.check._

private[coc] trait SkillSuccessfullyUsedBehavior {
  self: Skill with SkillSuccessCheck with SkillSuccessCheckable =>

  protected var _successCheck: Boolean = false

  override def successCheck: Boolean = _successCheck

  override def checkUsedWithSuccess(): Unit = {
    _successCheck = true
  }
}
