package com.rkss.rpg.coc.foundations.skills

trait AnimalHandling extends BasicSkill

object AnimalHandling {
  def create(occupationPoints: Int = 0, personalPoints: Int = 0): AnimalHandling = {
    new SimpleSkill(5, occupationPoints, personalPoints) with AnimalHandling
  }
}
