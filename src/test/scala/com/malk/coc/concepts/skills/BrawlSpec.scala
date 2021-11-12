package com.malk.coc.concepts.skills

class BrawlSpec extends BehavesLikeSkill {
  val skillName = "Fighting (Brawl)"

  val skill = Brawl(spent = 10)

  behavesLikeSkill(skill, skillName, 25, false, 35)
}