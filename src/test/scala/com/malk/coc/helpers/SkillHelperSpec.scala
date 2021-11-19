package com.malk.coc.helpers

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.malk.coc.concepts.skills._
import com.malk.coc.concepts.occupations.InvestigatorSkillPoints
import org.scalamock.scalatest.MockFactory
import com.malk.coc.traits._

class SkillHelperSpec extends AnyFunSpec with Matchers with MockFactory {
  describe("Skill Helper") {
    describe("filtered Skills") {
      val modernEraSkill: Set[Skill] = Set(
        ComputerUse(0),
        Electronics(0)
      )

      val filteredSkills: Set[Skill] = SkillHelper.allSkills -- modernEraSkill

      it(s"should be a list of filtered skills") {
        SkillHelper.excludedSkills(modernEraSkill) should contain theSameElementsAs filteredSkills
      }
    }

    describe("Interpersonal Skills") {
      val interpersonalSkills = Set(
        Charm(0),
        FastTalk(0),
        Intimidate(0),
        Persuade(0)
      )

      it(s"should be a list of interpersonal skills") {
        SkillHelper.interpersonalSkills should contain theSameElementsAs interpersonalSkills
      }
    }

    describe("Uncommon Skills") {
      val uncommonSkills = Set(
        AnimalHandling(0),
        Hypnosis(0),
        Demolitions(0),
        Artillery(0),
        Diving(0),
        ReadLips(0)
      )

      it(s"should be a list of Uncommon skills") {
        SkillHelper.uncommonSkills should contain theSameElementsAs uncommonSkills
      }
    }

    describe("Modern Skills") {
      val modernSkills = Set(
        ComputerUse(0),
        Electronics(0)
      )

      it(s"should be a list of Modern skills") {
        SkillHelper.modernSkills should contain theSameElementsAs modernSkills
      }
    }

    describe("Survival Skills") {
      val survivalSkills = Set(
        Arctic(0),
        Desert(0),
        Sea(0),
        WildernessTerrain(0)
      )

      it(s"should be a list of survival skills") {
        SkillHelper.survivalSkills should contain theSameElementsAs survivalSkills
      }
    }

    describe("Art / Craft Skills") {
      val artAndCraftSkills = Set(
        Acting(0),
        FineArt(0),
        Forgery(0),
        Photography(0)
      )

      it(s"should be a list of Art / Craft skills") {
        SkillHelper.artAndCraftSkills should contain theSameElementsAs artAndCraftSkills
      }
    }

    describe("Science Skills") {
      val scienceSkills = Set(
        Astronomy(0),
        Biology(0),
        Botany(0),
        Chemistry(0),
        Cryptography(0),
        Engineering(0),
        Forensics(0),
        Geology(0),
        Mathematics(0),
        Meteorology(0),
        Pharmacy(0),
        Physics(0),
        Zoology(0)
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

    describe("Pilot Skills") {
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

      it(s"should be a list of firearms skills") {
        SkillHelper.firearmsSkills should contain theSameElementsAs firearmsSkills
      }
    }

    describe("Specialization Skills") {
      val specializationsSkills = Set(
        Astronomy(0),
        Biology(0),
        Botany(0),
        Chemistry(0),
        Cryptography(0),
        Engineering(0),
        Forensics(0),
        Geology(0),
        Mathematics(0),
        Meteorology(0),
        Pharmacy(0),
        Physics(0),
        Zoology(0),
        Acting(0),
        FineArt(0),
        Forgery(0),
        Photography(0),
        Arctic(0),
        Desert(0),
        Sea(0),
        WildernessTerrain(0)
      )

      it(s"should be a list of specialization skills") {
        SkillHelper.specializationsSkills should contain theSameElementsAs specializationsSkills
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

      Seq(
        (
          30,
          InvestigatorSkillPoints(100),
          CreditRating(45),
          InvestigatorSkillPoints(70),
          CreditRating(15),
          CreditRating(45)
        ),
        (
          20,
          InvestigatorSkillPoints(10),
          CreditRating(25),
          InvestigatorSkillPoints(0),
          CreditRating(15),
          CreditRating(45)
        ),
        (
          20,
          InvestigatorSkillPoints(10),
          CreditRating(45),
          InvestigatorSkillPoints(10),
          CreditRating(45),
          CreditRating(45)
        )
      ).foreach(t => {
        val spend = t._1
        val occupationSkillPoints = t._2
        val expected = t._3
        val remainingPoints = t._4
        val startingCreditRating = t._5
        val maximumCreditRating = t._6

        describe(s"when ${startingCreditRating}") {
          describe(s"when max is ${maximumCreditRating}") {
            describe(s"spending ${spend} points on Credit Rating") {
              describe(s"when ${occupationSkillPoints}") {
                it(s"should return ${expected}") {
                  rollRange
                    .stubs(
                      (
                        0,
                        maximumCreditRating.value - startingCreditRating.value
                      )
                    )
                    .returning(spend)

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
