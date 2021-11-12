package com.malk.coc.concepts.skills

class FineArtSpec extends BehavesLikeSkill {
  val skillName = "Art and Craft (Fine Art)"

  val skill = FineArt(spent = 10)

  behavesLikeSkill(skill, skillName, 5, true, 15)
}
