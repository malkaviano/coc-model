package com.malk.coc.helpers

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.malk.coc.concepts.skills._
// import com.malk.coc.traits.Skill

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

    describe("Firearms Skills") {
      val firearmsSkills = Set(
        Bow(0),
        Handgun(0),
        HeavyWeapons(0),
        Flamethrower(0),
        MachineGun(0),
        RifleAndShotgun(0),
        SubmachineGun(0)
      )

      it(s"should be a list of fighting skills") {
        SkillHelper.firearms should contain theSameElementsAs firearmsSkills
      }
    }

    describe("Choose Skill") {
      Seq((1, 3, 4), (4, 2, 6), (10, 4, 12)).foreach(t => {
        val skills = Set(
          (t._1, SkillHelper.fighting),
          (t._2, SkillHelper.firearms)
        )

        describe(s"when pick ${t._3} from ${skills}") {
          val result = SkillHelper.chooseSkill(skills)

          it(s"should return ${result}") {
            result should have size (t._3)
          }
        }
      })
    }
  }
}
