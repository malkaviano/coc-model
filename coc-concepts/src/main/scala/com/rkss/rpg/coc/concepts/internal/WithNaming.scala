package com.rkss.rpg.coc.concepts.internal

import com.rkss.rpg.helpers.traits._

trait WithNaming[+A <: GlobalNameTag] {
  def name: A
}
