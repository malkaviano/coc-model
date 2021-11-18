package com.malk.coc.helpers

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.malk.coc.concepts.skills._
import com.malk.coc.concepts.occupations.OccupationSkillPoints
import org.scalamock.scalatest.MockFactory

class SkillHelperSpec extends AnyFunSpec with Matchers with MockFactory {
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

    describe("Choosing Skills") {
      Seq((1, 3, 4), (4, 2, 6), (10, 4, 12)).foreach(t => {
        val skills = Set(
          (t._1, SkillHelper.fighting),
          (t._2, SkillHelper.firearms)
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
