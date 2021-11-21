package com.malk.coc.concepts.skills

class CreditRatingSpec extends BehavesLikeSkill with BehavesLikeSkillComparing {
  val skillName = "Credit Rating"

  val skill = CreditRating(0, 30)

  behavesLikeSkill(skill, skillName, 0, true, 30)

  behavesLikeSkillComparing(skill, skillName, 0, true)

  describe("Spending over the maximum") {
    it("should not allow going over maximum") {
      skill.spend(10)

      skill.value shouldBe 30
    }
  }
}
