package com.rkss.rpg.coc.foundations.skills

trait Anthropology extends BasicSkill

object Anthropology {
  def create(occupationPoints: Int = 0, personalPoints: Int = 0): Anthropology = {
    new SimpleSkill(1, occupationPoints, personalPoints) with Anthropology
  }
}
