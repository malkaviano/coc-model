package com.malk.coc.helpers

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
import com.malk.coc.concepts.skills.languages.own.LanguageOwn
import com.malk.coc.concepts.skills._
import com.malk.coc.traits.OccupationTemplate
import com.malk.coc.concepts.occupations.InvestigatorSkillPoints
import com.malk.coc.concepts.skills.languages.Language
import com.malk.coc.concepts.characteristics.Appearance
import com.malk.coc.concepts.abstractions.Brain
import com.malk.coc.concepts.occupations.TemplateSkillResult
import com.malk.coc.concepts.characteristics.Education
import com.malk.coc.concepts.abstractions.Body
import com.malk.coc.traits.Skill
import com.malk.coc.concepts.characteristics.Dexterity

class OccupationSkillPickerSpec extends AnyFunSpec with Matchers {
  import com.malk.coc.helpers.InvestigatorCharacteristics.implicits._
  import com.malk.coc.helpers.DiceHelper.implicits._
  import com.malk.coc.helpers.InvestigatorAttributes.implicits._

  val implicitBody = body
  val implicitBrain = brain
  val implicitEdu = edu
  val implicitApp = app

  val templateLanguage = language

  describe("picking occupation skills") {
    it("should return template occupation skills") {
      val picker =
        new OccupationSkillPicker(
          templateFixture(
            occupationFixedSkills =
              Set(CreditRating(0, 30), CthulhuMythos(), ComputerUse()),
            excludedSkills = Set(ComputerUse()),
            cannotSpendPointsSkills = Set(CthulhuMythos())
          )
        )

      picker.occupationSkills should contain theSameElementsAs Set(
        CreditRating(0, 30)
      )
    }

    describe("when occupation skill has LanguageOwn") {
      it("should return right LanguageOwn") {
        val picker = new OccupationSkillPicker(
          templateFixture(occupationFixedSkills =
            Set(
              CreditRating(0, 30),
              LanguageOwn(Education(0))(templateLanguage)
            )
          )
        )

        val result =
          picker.occupationSkills.filter(_.isInstanceOf[LanguageOwn]).head

        result.value shouldBe LanguageOwn(implicitEdu)(templateLanguage).value
      }
    }

    describe("when occupation skill has Dodge") {
      it("should return right Dodge") {
        val picker = new OccupationSkillPicker(
          templateFixture(occupationFixedSkills =
            Set(
              CreditRating(0, 30),
              Dodge(Dexterity(0))()
            )
          )
        )

        val result =
          picker.occupationSkills.filter(_.isInstanceOf[Dodge]).head

        result.value shouldBe Dodge(implicitBody.dexterity)().value
      }
    }

    it("should return right Credit Rating") {
      val picker = new OccupationSkillPicker(
        templateFixture(occupationFixedSkills =
          Set(
            CreditRating(),
            Dodge(Dexterity(0))()
          )
        )
      )

      val result =
        picker.occupationSkills.filter(_.isInstanceOf[CreditRating]).head

      result.value shouldBe CreditRating(5, 40).value
    }

    describe("when picking any skill") {
      val picker =
        new OccupationSkillPicker(
          templateFixture(
            occupationFixedSkills = Set(
              CreditRating(0, 30),
              LanguageOwn(Education(0))(templateLanguage),
              LibraryUse(),
              Psychology()
            ),
            occupationChooseSkills = Seq(
              (
                1,
                Seq(
                  (
                    1,
                    SkillHelper.languageOtherSkills
                  )
                )
              ),
              (
                4,
                Seq(
                  (
                    4,
                    Set(
                      CthulhuMythos(),
                      ComputerUse(),
                      Electronics(),
                      Axe(),
                      Handgun(),
                      FastTalk(),
                      Stealth()
                    )
                  )
                )
              )
            ),
            cannotSpendPointsSkills = Set(CthulhuMythos()),
            excludedSkills = SkillHelper.uncommonSkills ++ SkillHelper.modernSkills
          )
        )

      it("should have nine skills") {
        picker.occupationSkills should have size 9
      }
    }
  }

  describe("return all skills") {
    it("should return right LanguageOwn") {
      val picker = new OccupationSkillPicker(
        templateFixture(occupationFixedSkills =
          Set(
            CreditRating(0, 30)
          )
        )
      )

      val result =
        picker
          .personalSkills(picker.occupationSkills)
          .filter(_.isInstanceOf[LanguageOwn])
          .head

      result.value shouldBe LanguageOwn(implicitEdu)(templateLanguage).value
    }

    it("should return right Dodge") {
      val picker = new OccupationSkillPicker(
        templateFixture(occupationFixedSkills =
          Set(
            CreditRating(0, 30)
          )
        )
      )

      val result =
        picker
          .personalSkills(picker.occupationSkills)
          .filter(_.isInstanceOf[Dodge])
          .head

      result.value shouldBe Dodge(implicitBody.dexterity)().value

    }
  }

  private def templateFixture(
      occupationFixedSkills: Set[Skill],
      occupationChooseSkills: Seq[(Int, Seq[(Int, Set[Skill])])] = Seq.empty,
      cannotSpendPointsSkills: Set[Skill] = Set.empty,
      excludedSkills: Set[Skill] = Set.empty
  ): OccupationTemplate = {
    new OccupationTemplate {
      def name: String = "TESTING"

      def startCreditRating: CreditRating = CreditRating(5, 50)

      def occupationSkillPoints: InvestigatorSkillPoints = ???

      def templateSkills: TemplateSkillResult = TemplateSkillResult(
        occupationFixedSkills,
        occupationChooseSkills,
        cannotSpendPointsSkills,
        excludedSkills
      )

      def body: Body = implicitBody

      def brain: Brain = implicitBrain

      def edu: Education = implicitEdu

      def app: Appearance = implicitApp

      def language: Language = templateLanguage

    }
  }
}
