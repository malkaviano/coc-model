package com.rkss.rpg.coc.rules.behaviors

import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.rules._

private[coc] trait ImprovableSkillBehavior {
  self: Skill with SkillRollBehavior with SkillImprovable with SkillImprovement =>

  private val _improvedValue: Int = 0

  override def improvedValue: Int = _improvedValue

  private var _usedWithSuccess: Boolean = false

  override def usedWithSuccess: Boolean = _usedWithSuccess

  override def tickSuccessfullyUsed(): Unit = _usedWithSuccess = true

  override def improveSkill(): Unit = {
    ???
  }
}
