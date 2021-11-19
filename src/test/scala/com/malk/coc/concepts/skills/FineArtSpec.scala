package com.malk.coc.concepts.skills

class FineArtSpec extends BehavesLikeSkill {
  val skillName = "Art and Craft (Fine Art)"

  val skill = FineArt()

  behavesLikeSkill(skill, skillName, 5, true, 15)
}
