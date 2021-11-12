package com.malk.coc.concepts.skills

class CryptographySpec extends BehavesLikeSkill {
  val skillName = "Science (Cryptography)"

  val skill = Cryptography(spent = 10)

  behavesLikeSkill(skill, skillName, 1, true, 11)
}