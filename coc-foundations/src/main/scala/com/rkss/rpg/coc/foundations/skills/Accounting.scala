package com.rkss.rpg.coc.foundations.skills

trait Accounting extends BasicSkill

object Accounting {
  def create(occupationPoints: Int = 0, personalPoints: Int = 0): Accounting = {
    new SimpleSkill(5, occupationPoints, personalPoints)
      with Accounting
  }
}
