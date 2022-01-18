package com.rkss.rpg.coc.foundations.skills

import com.rkss.rpg.coc.concepts.skill._

trait AnimalHandling extends BasicSkill

object AnimalHandling {
  def create(occupationPoints: Int = 0, personalPoints: Int = 0): AnimalHandling = {
    new SimpleSkill(5, occupationPoints, personalPoints, Seq(UncommonSkill)) with AnimalHandling
  }
}
