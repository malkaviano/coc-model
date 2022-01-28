package com.rkss.rpg.coc.rules.skill.behaviors

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
import com.rkss.rpg.coc.rules.testing.fakes.FakeSkillWithSuccessCheck
import com.rkss.rpg.coc.concepts.skill._

final class SkillSuccessfullyUsedBehaviorSpec extends AnyFunSpec with Matchers {
  describe("Skill check used with success") {
    describe("Used with success") {
      describe("A skill not checked yet") {
        it("returns false") {
          val skill = FakeSkillWithSuccessCheck(Cryptography, 20, 30, 10)

          skill.successCheck shouldBe false
        }
      }

      describe("A skill checked with success") {
        it("returns true") {
          val skill = FakeSkillWithSuccessCheck(Disguise, 20, 30, 10)

          skill.checkUsedWithSuccess()

          skill.successCheck shouldBe true
        }
      }
    }
  }
}
