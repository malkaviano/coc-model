package com.malk.coc.concepts.skills

class SleightOfHandSpec extends BehavesLikeSkill {
  val skillName = "Sleight of Hand"

  val skill = SleightOfHand(spent = 10)

  behavesLikeSkill(skill, skillName, 10, true, 20)
}
