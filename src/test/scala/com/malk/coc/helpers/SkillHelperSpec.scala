package com.malk.coc.helpers

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.malk.coc.concepts.skills._
import com.malk.coc.concepts.occupations.OccupationSkillPoints
import org.scalamock.scalatest.MockFactory
import com.malk.coc.concepts.characteristics.Dexterity
import com.malk.coc.concepts.characteristics.Education

class SkillHelperSpec extends AnyFunSpec with Matchers with MockFactory {
  describe("Skill Helper") {
    describe("All skills") {
      val allSkills = Set(
        Accounting(0),
        Acting(0),
        AnimalHandling(0),
        Anthropology(0),
        Appraise(0),
        Archaeology(0),
        Arctic(0),
        Artillery(0),
        Astronomy(0),
        Axe(0),
        Biology(0),
        Botany(0),
        Bow(0),
        Brawl(0),
        Chainsaw(0),
        Charm(0),
        Chemistry(0),
        Climb(0),
        ComputerUse(0),
        CreditRating(0),
        Cryptography(0),
        CthulhuMythos(0),
        Demolitions(0),
        Desert(0),
        Disguise(0),
        Diving(0),
        Dodge(Dexterity(0))(0),
        DriveAuto(0),
        ElectricalRepair(0),
        Electronics(0),
        Engineering(0),
        FastTalk(0),
        FineArt(0),
        FirstAid(0),
        Flail(0),
        Flamethrower(0),
        Forensics(0),
        Forgery(0),
        Garrote(0),
        Geology(0),
        Handgun(0),
        HeavyWeapons(0),
        History(0),
        Hypnosis(0),
        Intimidate(0),
        Jump(0),
        LanguageOwn(Education(0))(0),
        Law(0),
        LibraryUse(0),
        Listen(0),
        Locksmith(0),
        MachineGun(0),
        Mathematics(0),
        MechanicalRepair(0),
        Medicine(0),
        Meteorology(0),
        NaturalWorld(0),
        Navigate(0),
        Occult(0),
        OperateHeavyMachinery(0),
        Persuade(0),
        Pharmacy(0),
        Photography(0),
        Physics(0),
        Psychoanalysis(0),
        Psychology(0),
        ReadLips(0),
        Ride(0),
        RifleAndShotgun(0),
        Sea(0),
        SleightOfHand(0),
        Spear(0),
        SpotHidden(0),
        Stealth(0),
        SubmachineGun(0),
        Swim(0),
        Sword(0),
        Throw(0),
        Track(0),
        Whip(0),
        WildernessTerrain(0),
        Zoology(0)
      )

      it(s"should be a list of all skills") {
        SkillHelper.allSkills should contain theSameElementsAs allSkills
      }
    }

    describe("Common Skills") {
      val commonSkills = Set(
        Accounting(0),
        Acting(0),
        Anthropology(0),
        Appraise(0),
        Archaeology(0),
        Arctic(0),
        Astronomy(0),
        Axe(0),
        Biology(0),
        Botany(0),
        Bow(0),
        Brawl(0),
        Chainsaw(0),
        Charm(0),
        Chemistry(0),
        Climb(0),
        CreditRating(0),
        Cryptography(0),
        CthulhuMythos(0),
        Desert(0),
        Disguise(0),
        Dodge(Dexterity(0))(0),
        DriveAuto(0),
        ElectricalRepair(0),
        Engineering(0),
        FastTalk(0),
        FineArt(0),
        FirstAid(0),
        Flail(0),
        Flamethrower(0),
        Forensics(0),
        Forgery(0),
        Garrote(0),
        Geology(0),
        Handgun(0),
        HeavyWeapons(0),
        History(0),
        Intimidate(0),
        Jump(0),
        LanguageOwn(Education(0))(0),
        Law(0),
        LibraryUse(0),
        Listen(0),
        Locksmith(0),
        MachineGun(0),
        Mathematics(0),
        MechanicalRepair(0),
        Medicine(0),
        Meteorology(0),
        NaturalWorld(0),
        Navigate(0),
        Occult(0),
        OperateHeavyMachinery(0),
        Persuade(0),
        Pharmacy(0),
        Photography(0),
        Physics(0),
        Psychoanalysis(0),
        Psychology(0),
        Ride(0),
        RifleAndShotgun(0),
        Sea(0),
        SleightOfHand(0),
        Spear(0),
        SpotHidden(0),
        Stealth(0),
        SubmachineGun(0),
        Swim(0),
        Sword(0),
        Throw(0),
        Track(0),
        Whip(0),
        WildernessTerrain(0),
        Zoology(0)
      )

      it(s"should be a list of common skills") {
        SkillHelper.commonSkills should contain theSameElementsAs commonSkills
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

      it(s"should be a list of Uncommon skills") {
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

    describe("Firearm Skills") {
      val firearmSkills = Set(
        Bow(0),
        Handgun(0),
        HeavyWeapons(0),
        Flamethrower(0),
        MachineGun(0),
        RifleAndShotgun(0),
        SubmachineGun(0)
      )

      it(s"should be a list of firearm skills") {
        SkillHelper.firearmSkills should contain theSameElementsAs firearmSkills
      }
    }

    describe("Choosing Skills") {
      Seq((1, 3, 4), (4, 2, 6), (10, 4, 12)).foreach(t => {
        val skills = Set(
          (t._1, SkillHelper.fightingSkills),
          (t._2, SkillHelper.firearmSkills)
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
