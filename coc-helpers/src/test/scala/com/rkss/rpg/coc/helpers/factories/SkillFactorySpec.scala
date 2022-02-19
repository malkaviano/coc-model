package com.rkss.rpg.coc.helpers.factories

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.fundamentals.skills._
import com.rkss.rpg.coc.concepts.characteristic._
import com.rkss.rpg.coc.fundamentals.characteristics._

final class SkillFactorySpec extends AnyFunSpec with Matchers {
  describe("Skill Factory") {
    describe("creating a basic skill") {
      it("should return the correct basic skill") {
        val firstAid = SkillFactory.basicSkill(FirstAid, 0, 0)

        firstAid shouldBe SkillImpl(FirstAid, 30, 0, 0)
      }
    }

    describe("creating a combat skill") {
      it("should return the correct combat skill") {
        val handgun = SkillFactory.combatSkill(Handgun, 0, 0)

        handgun shouldBe SkillImpl(Handgun, 20, 0, 0)
      }
    }

    describe("creating a dodge skill") {
      it("should return a dodge skill") {
        val dodge =
          SkillFactory.dodgeSkill(PrimaryCharacteristic(Dexterity, 60), 0, 0)

        dodge shouldBe SkillImpl(Dodge, 30, 0, 0)
      }
    }

    describe("creating a language other skill") {
      it("should return the correct language other skill") {
        val japanese =
          SkillFactory.languageOwnSkill(
            PrimaryCharacteristic(Education, 60),
            JapaneseLanguage,
            0,
            0
          )

        japanese shouldBe SkillImpl(
          JapaneseLanguage,
          60,
          0,
          0,
          Seq(LanguageOwn)
        )
      }
    }

    describe("creating a language own skill") {
      it("should return the correct language own skill") {
        val japanese =
          SkillFactory.languageOtherSkill(
            RussianLanguage,
            0,
            0
          )

        japanese shouldBe SkillImpl(
          RussianLanguage,
          1,
          0,
          0,
          Seq(LanguageOther)
        )
      }
    }

    describe("creating a CthulhuMythos skill") {
      it("should return a CthulhuMythos skill") {
        SkillFactory.cthulhuMythosSkill shouldBe CthulhuMythosSkillImpl()
      }
    }

    describe("creating a CreditRating skill") {
      it("should return a CreditRating skill") {
        SkillFactory.creditRatingSkill(15, 10, 5) shouldBe CreditRatingSkillImpl(
          15,
          10,
          5
        )
      }
    }
  }
}
