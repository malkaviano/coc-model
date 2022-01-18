package com.rkss.rpg.coc.foundations.skills

import com.rkss.rpg.coc.concepts.skill.FightingSkill

trait Axe extends CombatSkill

object Axe {
  def create(occupationPoints: Int = 0, personalPoints: Int = 0): Axe = {
    new SimpleSkill(15, occupationPoints, personalPoints, Seq(FightingSkill)) with Axe
  }
}
