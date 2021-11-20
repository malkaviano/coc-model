package com.malk.coc.concepts.occupations

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
import com.malk.coc.concepts.skills._
import com.malk.coc.traits.Skill
import com.malk.coc.rules.TwoEduEitherTwoStrOrDexRule
import com.malk.coc.helpers.SkillHelper
import com.malk.coc.concepts.characteristics.Dexterity
import com.malk.coc.concepts.characteristics.Education

class TribeMemberTemplateSpec extends AnyFunSpec with Matchers {
  import com.malk.coc.helpers.InvestigatorCharacteristics.implicits._
  import com.malk.coc.helpers.DiceHelper.implicits._

  describe("TRIBE MEMBER occupation") {
    val occupationTemplate = new TribeMemberTemplate
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

    val nonTrainableSkills = Set(CthulhuMythos())

    val excludedSkills = SkillHelper.uncommonSkills ++ SkillHelper.modernSkills

    val implicitBody = body
    val implicitBrain = brain
    val implicitEdu = edu
    val implicitApp = app

    val selfSkills = Set(
      Dodge(implicitBody.dexterity)(),
      LanguageOwn(implicitEdu)()
    )

    val personalSkills: Set[Skill] = SkillHelper.filteredSkills(
      Set(CreditRating(), CthulhuMythos()) ++ excludedSkills + Dodge(
        Dexterity(0)
      )() + LanguageOwn(Education(0))()
    ) ++ selfSkills

    val occupationSkillPointsRule = new TwoEduEitherTwoStrOrDexRule

    it("should have name TRIBE MEMBER") {
      occupationTemplate.name shouldBe "TRIBE MEMBER"
    }

    describe("getting template skills") {
      it(s"should have start ${startCreditRating}") {
        occupationTemplate.startCreditRating shouldBe startCreditRating
      }

      it(s"should have maximum ${maximumCreditRating}") {
        occupationTemplate.maximumCreditRating shouldBe maximumCreditRating
      }

      val result = occupationTemplate.templateSkills(
        implicitBody,
        implicitBrain,
        implicitEdu,
        implicitApp
      )

      it(s"should have a list of fixed skills") {
        result._1 should contain theSameElementsAs fixedSkills
      }

      it(s"should have a list of optional skills") {
        result._2 should contain theSameElementsAs optionalSkills
      }

      it(s"should have a list of personal skills") {
        result._3 should contain theSameElementsAs personalSkills
      }

      it(s"should have a list of non trainable skills") {
        result._4 should contain theSameElementsAs nonTrainableSkills
      }
    }

    it(
      "should have Occupation Skill Points Rule equal TwoEduEitherTwoStrOrDexRule"
    ) {
      occupationTemplate.occupationSkillPointsRule.name shouldBe occupationSkillPointsRule.name
    }
  }
}
