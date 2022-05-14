package com.rkss.rpg.coc.concepts.internal

import com.rkss.rpg.coc.concepts.roll._

trait WithNaming[+A <: SkillRollNaming] {
  def name: A
}
