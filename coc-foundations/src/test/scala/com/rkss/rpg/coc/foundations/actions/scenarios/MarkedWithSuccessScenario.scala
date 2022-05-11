package com.rkss.rpg.coc.foundations.actions

import com.rkss.rpg.coc.concepts.roll._
import com.rkss.rpg.coc.concepts.skill.check._

trait MarkedWithSuccessScenario {
  def checkMarkedWithSuccess(
      checkable: SkillRollCheckable[_]
  ): Boolean = {
    checkable.isInstanceOf[SkillSuccessMark] &&
    checkable.asInstanceOf[SkillSuccessMark].wasSuccessfullyUsed
  }
}
