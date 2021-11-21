package com.malk.coc.concepts.skills

class CreditRatingSpec extends BehavesLikeSkill with BehavesLikeSkillComparing {
  val skillName = "Credit Rating"

  val skill = CreditRating(0, 30)

  behavesLikeSkill(skill, skillName, 0, true, 30)

  behavesLikeSkillComparing(skill, skillName, 0, true)

  describe("when spending over the maximum") {
    it("should not go over maximum") {
      skill.spend(10)

      skill.value shouldBe 30
    }
  }

  describe("when asking if it's possible to spend") {
    val skill = CreditRating(0, 20)

    describe("when points will be over the maximum") {
      it("should return false") {
        val result = skill.canSpend(30)

        result shouldBe false
      }
    }

    describe("when points will be equal or bellow maximum") {
      it("should return true") {
        val result = skill.canSpend(20)

        result shouldBe true
      }
    }
  }
}
