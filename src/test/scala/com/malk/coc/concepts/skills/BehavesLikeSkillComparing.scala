package com.malk.coc.concepts.skills

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.malk.coc.traits.Skill

trait BehavesLikeSkillComparing extends AnyFunSpec with Matchers {
  def behavesLikeSkillComparing(
      skill: Skill,
      skillName: String,
      skillBase: Int,
      skillCanPush: Boolean
  ): Unit = {
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
