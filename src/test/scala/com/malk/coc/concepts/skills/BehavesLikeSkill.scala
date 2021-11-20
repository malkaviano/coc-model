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
    }
  }
}
