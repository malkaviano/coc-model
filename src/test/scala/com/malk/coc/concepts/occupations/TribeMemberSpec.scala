package com.malk.coc.concepts.occupations

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
import com.malk.coc.concepts.skills._
import com.malk.coc.traits.Skill
import com.malk.coc.rules.TwoEduEitherTwoStrOrDexRule

class TribeMemberSpec extends AnyFunSpec with Matchers {
  describe("TRIBE MEMBER occupation") {
    val occupation = new TribeMember
    val startCreditRating = CreditRating(0)
    val maximumCreditRating = CreditRating(15)
    val fixedSkills: Seq[Skill] = Seq(
      Climb(0),
      NaturalWorld(0),
      Listen(0),
      Occult(0),
      SpotHidden(0),
      Swim(0)
    )

    val optionalSkills: Seq[(Int, Seq[Skill])] = Seq(
      (1, Seq(Sea(0), Desert(0), Arctic(0), WildernessTerrain(0))),
      (
        1,
        Seq(
          Axe(0),
          Brawl(0),
          Chainsaw(0),
          Flail(0),
          Garrote(0),
          Spear(0),
          Sword(0),
          Whip(0),
          Throw(0)
        )
      )
    )

    val occupationSkillPointsRule = new TwoEduEitherTwoStrOrDexRule

    it("should have name TRIBE MEMBER") {
      occupation.name shouldBe "TRIBE MEMBER"
    }

    it(s"should have start ${startCreditRating}") {
      occupation.startCreditRating shouldBe startCreditRating
    }

    it(s"should have maximum ${maximumCreditRating}") {
      occupation.maximumCreditRating shouldBe maximumCreditRating
    }

    it(s"should have a list of fixed skills") {
      occupation.fixedSkills should contain theSameElementsAs fixedSkills
    }

    it(s"should have a list of optional skills") {
      occupation.optionalSkills should contain theSameElementsAs optionalSkills
    }

    it(
      "should have Occupation Skill Points Rule equal TwoEduEitherTwoStrOrDexRule"
    ) {
      occupation.occupationSkillPointsRule.name shouldBe occupationSkillPointsRule.name
    }
  }
}
