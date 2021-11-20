package com.malk.coc.concepts.skills.languages

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

trait BehavesLikeLanguageSkill extends AnyFunSpec with Matchers {
  import com.malk.coc.traits.Skill

  def behavesLikeLanguageSkill(
      skill: Skill,
      skillName: String,
      skillBase: Int,
      skillCanPush: Boolean,
      spent: Int,
      ownSameLanguage: Skill,
      ownDifferentLanguage: Skill,
      otherSameLanguage: Skill,
      otherDifferentLanguage: Skill
  ): Unit = {
    describe(s"The ${skillName} skill") {
      it(s"should have name ${skillName}") {
        skill.name shouldBe skillName
      }

      it(s"should have base equal ${skillBase}") {
        skill.base shouldBe skillBase
      }

      it(s"should have canPush equal ${skillCanPush}") {
        skill.canPush shouldBe skillCanPush
      }

      it(s"should have value equal ${skillBase}") {
        skill.value shouldBe skillBase
      }

      describe(s"spend ${spent}") {
        val expected = skill.value + spent

        it(s"should have value equal ${expected}") {
          skill.spend(spent)

          skill.value shouldBe expected
        }
      }

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
            val sameSkill = new Skill {
              def base: Int = 20
              def canPush: Boolean = !skillCanPush
              def name: String = skillName
            }

            Set(skill) -- Set(sameSkill) shouldBe Set.empty
          }
        }
      }
    }
  }
}
