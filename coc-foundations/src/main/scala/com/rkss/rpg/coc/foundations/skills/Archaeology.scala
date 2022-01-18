package com.rkss.rpg.coc.foundations.skills

trait Archaeology extends BasicSkill

object Archaeology {
  def create(occupationPoints: Int = 0, personalPoints: Int = 0): Archaeology = {
    new SimpleSkill(1, occupationPoints, personalPoints) with Archaeology
  }
}
