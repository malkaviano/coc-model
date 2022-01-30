package com.rkss.rpg.coc.concepts

trait EntityWithNameTag[A <: NameTag] {
  def name: A
}
