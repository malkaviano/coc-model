package com.rkss.rpg.coc.concepts.roll

trait SkillRollCheckable[+A <: SkillRollNaming] extends SkillRollable[A] {
  def name: A
}
