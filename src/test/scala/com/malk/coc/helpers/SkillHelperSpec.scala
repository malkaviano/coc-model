package com.malk.coc.helpers

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.malk.coc.concepts.skills._

class SkillHelperSpec extends AnyFunSpec with Matchers {
  describe("Skill Helper") {
    describe("Fighting Skills") {
      val fightingSkills = Set(
        Axe(0),
        Brawl(0),
        Chainsaw(0),
        Flail(0),
        Garrote(0),
        Spear(0),
        Sword(0),
        Whip(0)
      )

      it(s"should be a list of fighting skills") {
        SkillHelper.fighting should contain theSameElementsAs fightingSkills
      }
    }
  }
}
