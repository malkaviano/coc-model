package com.malk.coc.concepts.skills

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.malk.coc.traits.GenericSkill

trait BehavesLikeGenericSkill extends AnyFunSpec with Matchers {
  def behavesLikeGenericSkill(
      skill: GenericSkill,
      skillName: String,
      base: Int,
      canPush: Boolean
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
    }
  }
}
