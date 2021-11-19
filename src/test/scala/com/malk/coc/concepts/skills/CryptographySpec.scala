package com.malk.coc.concepts.skills

class CryptographySpec extends BehavesLikeSkill {
  val skillName = "Science (Cryptography)"

  val skill = Cryptography()

  behavesLikeSkill(skill, skillName, 1, true, 11)
}