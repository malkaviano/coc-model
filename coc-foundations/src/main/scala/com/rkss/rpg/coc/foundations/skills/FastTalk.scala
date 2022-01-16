package com.rkss.rpg.coc.foundations.skills

trait FastTalk extends BasicSkill

object FastTalk {
  def create(occupationPoints: Int = 0, personalPoints: Int = 0): FastTalk = {
    new SimpleSkill(5, occupationPoints, personalPoints) with FastTalk
  }
}
