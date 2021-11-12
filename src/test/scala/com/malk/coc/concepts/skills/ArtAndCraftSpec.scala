package com.malk.coc.concepts.skills

class ArtAndCraftSpec extends BehavesLikeGenericSkill {
  val skillName = "Art and Craft"

  val skill = new ArtAndCraft(10) {}

  behavesLikeGenericSkill(skill, skillName, 5, true)
}