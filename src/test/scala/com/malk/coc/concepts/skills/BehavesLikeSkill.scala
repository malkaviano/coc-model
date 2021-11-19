package com.malk.coc.concepts.skills

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.malk.coc.traits.Skill

trait BehavesLikeSkill extends AnyFunSpec with Matchers {
  def behavesLikeSkill(
      skill: Skill,
      skillName: String,
      base: Int,
      canPush: Boolean,
      spent: Int
  ): Unit = {
    describe(s"The ${skillName} skill") {
      it(s"should have name ${skillName}") {
        skill.name shouldBe skillName
      }

      it(s"should have base equal ${base}") {
        skill.base shouldBe base
      }

      it(s"should have canPush equal ${canPush}") {
        skill.canPush shouldBe canPush
      }

      it(s"should have value equal ${base}") {
        skill.value shouldBe base
      }

      describe(s"spend ${spent}") {
        val expected = skill.value + spent

        it(s"should have value equal ${expected}") {
          skill.spend(spent)

          skill.value shouldBe expected
        }
      }
    }
  }
}
