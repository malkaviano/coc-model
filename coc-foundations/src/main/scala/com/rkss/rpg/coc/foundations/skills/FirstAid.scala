package com.rkss.rpg.coc.foundations.skills

trait FirstAid extends BasicSkill

object FirstAid {
  def create(occupationPoints: Int = 0, personalPoints: Int = 0): FirstAid = {
    new SimpleSkill(30, occupationPoints, personalPoints) with FirstAid
  }
}
