package com.malk.coc.concepts.skills.languages

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

trait BehavesLikeLanguageSkill extends AnyFunSpec with Matchers {
  import com.malk.coc.traits.Skill

  def checkLanguageBehavior(
      skill: Skill,
      skillsToCompare: (Skill, Skill, Skill, Skill)
  ): Unit = {
    val ownSameLanguage: Skill = skillsToCompare._1
    val ownDifferentLanguage: Skill = skillsToCompare._2
    val otherSameLanguage: Skill = skillsToCompare._3
    val otherDifferentLanguage: Skill = skillsToCompare._4

    describe(s"Comparing ${skill}") {
      it("should be equal to itself") {
        skill shouldBe skill
      }

      describe("when another instance of same skill type") {
        describe("when language is the same") {
          it("should be equal") {
            skill shouldBe ownSameLanguage
          }
        }

        describe("when language is different") {
          it("should not be equal") {
            skill should not be ownDifferentLanguage
          }
        }
      }

      describe("when another instance of different skill type") {
        describe("when language is the same") {
          it("should be equal") {
            skill shouldBe otherSameLanguage
          }
        }

        describe("when language is different") {
          it("should not be equal") {
            skill should not be otherDifferentLanguage
          }
        }
      }

      describe("when used inside a Collection") {
        it("should find skill") {
          Set(skill) -- Set(ownSameLanguage) shouldBe Set.empty
        }
      }
    }
  }
}
