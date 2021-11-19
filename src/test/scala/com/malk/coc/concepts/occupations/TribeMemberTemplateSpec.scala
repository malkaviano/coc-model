package com.malk.coc.concepts.occupations

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
import com.malk.coc.concepts.skills._
import com.malk.coc.traits.Skill
import com.malk.coc.rules.TwoEduEitherTwoStrOrDexRule

class TribeMemberTemplateSpec extends AnyFunSpec with Matchers {
  describe("TRIBE MEMBER occupation") {
    val occupation = new TribeMemberTemplate
    val startCreditRating = CreditRating()
    val maximumCreditRating = CreditRating()

    maximumCreditRating.spend(15)

    val fixedSkills: Set[Skill] = Set(
      Climb(),
      NaturalWorld(),
      Listen(),
      Occult(),
      SpotHidden(),
      Swim()
    )

    val optionalSkills: Set[(Int, Set[Skill])] = Set(
      (1, Set(Sea(), Desert(), Arctic(), WildernessTerrain())),
      (
        1,
        Set(
          Axe(),
          Brawl(),
          Chainsaw(),
          Flail(),
          Garrote(),
          Spear(),
          Sword(),
          Whip(),
          Throw()
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
