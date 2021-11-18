package com.malk.coc.helpers

import com.malk.coc.concepts.skills._
import com.malk.coc.traits.Skill

object SkillHelper {
  val fighting: Set[Skill] = Set(
    Axe(0),
    Brawl(0),
    Chainsaw(0),
    Flail(0),
    Garrote(0),
    Spear(0),
    Sword(0),
    Whip(0)
  )

  def chooseSkill(optionalSkill: Set[(Int, Set[Skill])]): Set[Skill] = ???
}
