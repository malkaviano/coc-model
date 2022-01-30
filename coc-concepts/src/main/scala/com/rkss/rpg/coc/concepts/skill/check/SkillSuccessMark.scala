package com.rkss.rpg.coc.concepts.skill.check

import com.rkss.rpg.coc.concepts.skill._

trait SkillSuccessMark { self: Skill[_] =>
  def wasSuccessfullyUsed: Boolean
}
