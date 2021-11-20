package com.malk.coc.helpers

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.malk.coc.concepts.skills._
import com.malk.coc.concepts.occupations.InvestigatorSkillPoints
import org.scalamock.scalatest.MockFactory
import com.malk.coc.traits._

import com.malk.coc.concepts.skills.languages.other._

class SkillHelperSpec extends AnyFunSpec with Matchers with MockFactory {
  describe("Skill Helper") {
    describe("filtered Skills") {
      val modernEraSkill: Set[Skill] = Set(
        ComputerUse(),
        Electronics()
      )

      val filteredSkills: Set[Skill] = SkillHelper.allSkills -- modernEraSkill

      it(s"should be a list of filtered skills") {
        SkillHelper.filteredSkills(
          modernEraSkill
        ) should contain theSameElementsAs filteredSkills
      }
    }

    describe("Interpersonal Skills") {
      val interpersonalSkills = Set(
        Charm(),
        FastTalk(),
        Intimidate(),
        Persuade()
      )

      it(s"should be a list of interpersonal skills") {
        SkillHelper.interpersonalSkills should contain theSameElementsAs interpersonalSkills
      }
    }

    describe("Uncommon Skills") {
      val uncommonSkills = Set(
        AnimalHandling(),
        Hypnosis(),
        Demolitions(),
        Artillery(),
        Diving(),
        ReadLips()
      )

      it(s"should be a list of Uncommon skills") {
        SkillHelper.uncommonSkills should contain theSameElementsAs uncommonSkills
      }
    }

    describe("Modern Skills") {
      val modernSkills = Set(
        ComputerUse(),
        Electronics()
      )

      it(s"should be a list of Modern skills") {
        SkillHelper.modernSkills should contain theSameElementsAs modernSkills
      }
    }

    describe("Survival Skills") {
      val survivalSkills = Set(
        Arctic(),
        Desert(),
        Sea(),
        WildernessTerrain()
      )

      it(s"should be a list of survival skills") {
        SkillHelper.survivalSkills should contain theSameElementsAs survivalSkills
      }
    }

    describe("Art / Craft Skills") {
      val artAndCraftSkills = Set(
        Acting(),
        FineArt(),
        Forgery(),
        Photography()
      )

      it(s"should be a list of Art / Craft skills") {
        SkillHelper.artAndCraftSkills should contain theSameElementsAs artAndCraftSkills
      }
    }

    describe("Science Skills") {
      val scienceSkills = Set(
        Astronomy(),
        Biology(),
        Botany(),
        Chemistry(),
        Cryptography(),
        Engineering(),
        Forensics(),
        Geology(),
        Mathematics(),
        Meteorology(),
        Pharmacy(),
        Physics(),
        Zoology()
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
        ArabicLanguageOther(),
        ChineseLanguageOther(),
        EnglishLanguageOther(),
        FrenchLanguageOther(),
        GermanLanguageOther(),
        ItalianLanguageOther(),
        JapaneseLanguageOther(),
        PolishLanguageOther(),
        PortugueseLanguageOther(),
        RussianLanguageOther(),
        SpanishLanguageOther(),
        SpanishLanguageOther(),
        SpanishLanguageOther(),
        TurkishLanguageOther()
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
        Axe(),
        Brawl(),
        Chainsaw(),
        Flail(),
        Garrote(),
        Spear(),
        Sword(),
        Whip()
      )

      it(s"should be a list of fighting skills") {
        SkillHelper.fightingSkills should contain theSameElementsAs fightingSkills
      }
    }

    describe("Firearms Skills") {
      val firearmsSkills = Set(
        Bow(),
        Handgun(),
        HeavyWeapons(),
        Flamethrower(),
        MachineGun(),
        RifleAndShotgun(),
        SubmachineGun()
      )

      it(s"should be a list of firearms skills") {
        SkillHelper.firearmSkills should contain theSameElementsAs firearmsSkills
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

    describe("Helper Skills should be immutable") {
      Seq(
        (SkillHelper.modernSkills.head, SkillHelper.modernSkills.head),
        (SkillHelper.allSkills.head, SkillHelper.allSkills.head),
        (SkillHelper.fightingSkills.head, SkillHelper.fightingSkills.head)
      ).foreach {
        case (skill, original) => {
          describe(s"when spend 50 on ${skill}") {
            it("should not change value of the original skill") {
              val oldValue = skill.value

              skill.spend(50)

              original.value shouldBe oldValue
            }
          }
        }
      }
    }

    describe("Spending points on Credit Rating") {
      val rollRange = mockFunction[(Int, Int), Int]

      Seq(
        (
          30,
          InvestigatorSkillPoints(100),
          45,
          InvestigatorSkillPoints(70),
          15,
          45
        ),
        (
          20,
          InvestigatorSkillPoints(10),
          25,
          InvestigatorSkillPoints(0),
          15,
          45
        ),
        (
          20,
          InvestigatorSkillPoints(10),
          45,
          InvestigatorSkillPoints(10),
          45,
          45
        )
      ).foreach(t => {
        val spend = t._1
        val occupationSkillPoints = t._2
        val expected = CreditRating()
        val remainingPoints = t._4
        val startingCreditRating = CreditRating()
        val maximumCreditRating = CreditRating()

        expected.spend(t._3)
        startingCreditRating.spend(t._5)
        maximumCreditRating.spend(t._6)

        describe(
          s"when initial Credit Rating value is ${startingCreditRating.value}"
        ) {
          describe(
            s"when maximum Credit Rating value is ${maximumCreditRating.value}"
          ) {
            describe(s"spending ${spend} points on Credit Rating") {
              describe(s"when ${occupationSkillPoints}") {
                it(s"should return Credit Rating value ${expected.value}") {
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

                it(s"should have ${remainingPoints}") {
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
