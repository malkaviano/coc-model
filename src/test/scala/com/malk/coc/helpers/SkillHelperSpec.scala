package com.malk.coc.helpers

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.malk.coc.concepts.skills._
import com.malk.coc.concepts.occupations.OccupationSkillPoints
import org.scalamock.scalatest.MockFactory

class SkillHelperSpec extends AnyFunSpec with Matchers with MockFactory {
  describe("Skill Helper") {
    describe("Common Skills") {
      val commonSkills = Set(

      )

      it(s"should be a list of common skills") {
        SkillHelper.commonSkills should contain theSameElementsAs commonSkills
      }
    }

    describe("Interpersonal Skills") {
      val interpersonalSkills = Set(

      )

      it(s"should be a list of interpersonal skills") {
        SkillHelper.interpersonalSkills should contain theSameElementsAs interpersonalSkills
      }
    }

    describe("Survival Skills") {
      val survivalSkills = Set(

      )

      it(s"should be a list of survival skills") {
        SkillHelper.survivalSkills should contain theSameElementsAs survivalSkills
      }
    }

    describe("Art / Craft Skills") {
      val artAndCraftSkills = Set(

      )

      it(s"should be a list of Art / Craft skills") {
        SkillHelper.artAndCraftSkills should contain theSameElementsAs artAndCraftSkills
      }
    }

    describe("Science Skills") {
      val scienceSkills = Set(

      )

      it(s"should be a list of science skills") {
        SkillHelper.scienceSkills should contain theSameElementsAs scienceSkills
      }
    }

    describe("Lore Skills") {
      val loreSkills = Set(

      )

      it(s"should be a list of lore skills") {
        SkillHelper.loreSkills should contain theSameElementsAs loreSkills
      }
    }

    describe("Language Other Skills") {
      val languageOtherSkills = Set(

      )

      it(s"should be a list of Language Other skills") {
        SkillHelper.languageOtherSkills should contain theSameElementsAs languageOtherSkills
      }
    }

    describe("Language Other Skills") {
      val pilotSkills = Set(

      )

      it(s"should be a list of pilot skills") {
        SkillHelper.pilotSkills should contain theSameElementsAs pilotSkills
      }
    }

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
        SkillHelper.fightingSkills should contain theSameElementsAs fightingSkills
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
        SkillHelper.firearmsSkills should contain theSameElementsAs firearmsSkills
      }
    }

    describe("Choosing Skills") {
      Seq((1, 3, 4), (4, 2, 6), (10, 4, 12)).foreach(t => {
        val skills = Set(
          (t._1, SkillHelper.fightingSkills),
          (t._2, SkillHelper.firearmsSkills)
        )

        describe(s"when pick ${t._3} from ${skills}") {
          val result = SkillHelper.chooseSkills(skills)

          it(s"should return ${result}") {
            result should have size (t._3)
          }
        }
      })
    }

    describe("Spending points on Credit Rating") {
      val rollRange = mockFunction[(Int, Int), Int]

      val startingCreditRating = CreditRating(15)
      val maximumCreditRating = CreditRating(45)

      Seq(
        (
          30,
          OccupationSkillPoints(100),
          maximumCreditRating,
          OccupationSkillPoints(70)
        ),
        (
          20,
          OccupationSkillPoints(10),
          CreditRating(25),
          OccupationSkillPoints(0)
        )
      ).foreach(t => {
        val spend = t._1
        val occupationSkillPoints = t._2
        val expected = t._3
        val remainingPoints = t._4

        describe(s"when ${startingCreditRating}") {
          describe(s"when max is ${maximumCreditRating}") {
            describe(s"spending ${spend} points on Credit Rating") {
              describe(s"when ${occupationSkillPoints}") {
                it(s"should return ${expected}") {
                  rollRange.stubs((0, 30)).returning(spend)

                  val result = SkillHelper.spendPointsOnCreditRating(
                    startingCreditRating,
                    maximumCreditRating,
                    occupationSkillPoints
                  )(rollRange)

                  result shouldBe expected
                }

                it(s"should discount points from OccupationSkillPoints") {
                  occupationSkillPoints shouldBe remainingPoints
                }
              }
            }
          }
        }
      })
    }
  }
}
