package com.malk.coc.concepts.skills

class FastTalkSpec extends BehavesLikeSkill {
  val skillName = "Fast Talk"

  val skill = FastTalk()

  behavesLikeSkill(skill, skillName, 5, true, 15)
}
