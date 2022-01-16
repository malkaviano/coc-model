package com.rkss.rpg.coc.foundations.skills

trait Appraise extends BasicSkill

object Appraise {
  def create(occupationPoints: Int = 0, personalPoints: Int = 0): Appraise = {
    new SimpleSkill(5, occupationPoints, personalPoints) with Appraise
  }
}
