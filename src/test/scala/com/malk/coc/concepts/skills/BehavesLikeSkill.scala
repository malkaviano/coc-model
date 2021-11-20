package com.malk.coc.concepts.skills

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.malk.coc.traits.Skill

trait BehavesLikeSkill extends AnyFunSpec with Matchers {
  def behavesLikeSkill(
      skill: Skill,
      skillName: String,
      skillBase: Int,
      skillCanPush: Boolean,
      spent: Int
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

        describe("when another instance of same skill has same name") {
          it("should be equal") {
            val sameSkill = new Skill {
              def base: Int = skillBase
              def canPush: Boolean = skillCanPush
              def name: String = skillName
            }

            skill shouldBe sameSkill
          }
        }

        describe("when another instance of same skill has different name") {
          it("should not be equal") {
            val notSameSkill = new Skill {
              def base: Int = skillBase
              def canPush: Boolean = skillCanPush
              def name: String = "GG"
            }

            skill should not be notSameSkill
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
