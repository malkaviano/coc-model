package com.rkss.rpg.coc.behaviors.skill

import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.concepts.skill.check._

private[coc] trait SkillSuccessfullyUsedBehavior {
  self: Skill[_] with SkillSuccessMark with SkillSuccessMarkable =>

  protected var _wasSuccessfullyUsed: Boolean = false

  override def wasSuccessfullyUsed: Boolean = _wasSuccessfullyUsed

  override def markUsedWithSuccess(): Unit = {
    _wasSuccessfullyUsed = true
  }
}
