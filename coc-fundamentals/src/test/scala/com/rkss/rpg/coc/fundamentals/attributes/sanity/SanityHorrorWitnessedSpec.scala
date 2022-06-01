package com.rkss.rpg.coc.fundamentals.attributes.sanity

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.coc.fundamentals.skills._
import com.rkss.rpg.coc.concepts.horror._
import com.rkss.rpg.coc.fundamentals.attributes._
import com.rkss.rpg.coc.concepts.characteristic._
import com.rkss.rpg.coc.fundamentals.characteristics._
import com.rkss.rpg.helpers.dice._
import com.rkss.rpg.coc.behaviors.testing._

final class SanityHorrorWitnessedSpec extends AnyFunSpec with Matchers {
  describe("An horror witnessed") {

    describe("when sanity is 40") {
      Seq(MummyHorror, SkeletonHorror, ZombieHorror).foreach(horror => {
        describe(s"when encountering a ${horror.name} for the first time") {
          val sanity =
            Sanity(Characteristic(Power, 40), CthulhuMythosSkillImpl())

          describe("and passing the sanity roll") {
            val expected = 40 - horror.success

            it(s"should reduce sanity to $expected") {
              val hundredSidedDice =
                HundredSidedDice(TestingProps.fakeRng(Seq(1)))

              sanity.horrorWitnessed(horror)(hundredSidedDice)

              sanity.current shouldBe expected
            }
          }
        }

        describe(s"when encountering a ${horror.name} multiple times") {
          val sanity =
            Sanity(Characteristic(Power, 40), CthulhuMythosSkillImpl())

          val expected = 40 - horror.maximum

          it(s"should not reduce bellow $expected") {
            (40 to 55).foreach(i =>
              sanity.horrorWitnessed(horror)(
                HundredSidedDice(TestingProps.fakeRng(Seq(i)))
              )
            )

            sanity.current shouldBe expected
          }
        }
      })

      describe("when losing 5 or more points with a single encounter") {
        pending
      }
    }
  }
}
