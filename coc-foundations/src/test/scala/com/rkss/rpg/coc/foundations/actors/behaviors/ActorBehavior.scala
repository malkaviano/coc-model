package com.rkss.rpg.coc.foundations.actors

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.coc.concepts.actor._

trait ActorBehavior extends AnyFunSpec with Matchers {
  def actorBehaviors(actor: Actor, spec: ActorSpecification): Unit = {
    val ActorSpecification(
      nature,
      definedCharacteristics,
      undefinedCharacteristics,
      skills,
      sanity,
      damageBonus,
      build,
      hitPoints,
      magicPoints,
      sanityLoss,
      movementRate,
      attacks,
      defense
    ) = spec

    describe(s"when actor nature is ${actor.nature}") {

      describe("Characteristics") {
        definedCharacteristics.foreach(name => {
          it(s"should have $name") {
            actor.characteristic(
              name
            ) shouldBe defined
          }
        })

        undefinedCharacteristics.foreach(name => {
          it(s"shouldn't have $name") {
            actor.characteristic(
              name
            ) should not be defined
          }
        })
      }

      describe("Skills") {
        skills.foreach(name => {
          it(s"have $name") {
            actor.skills(
              name
            ) shouldBe defined
          }
        })
      }

      describe("Damage Bonus") {
        it(s"return $damageBonus") {
          val result = actor.damageBonus match {
            case Some(value) => Some(value.current)
            case None        => None
          }

          result shouldBe damageBonus
        }
      }

      describe("Build") {
        it(s"return ${build}") {
          val result = actor.build match {
            case Some(value) => Some(value.current)
            case None        => None
          }

          result shouldBe build
        }
      }

      describe("HP") {
        it(s"return $hitPoints") {
          val result = actor.hitPoints match {
            case Some(value) => Some(value.current)
            case None        => None
          }

          result shouldBe hitPoints
        }
      }

      describe("MP") {
        it(s"return $magicPoints") {
          actor.magicPoints shouldBe magicPoints
        }
      }

      describe("MOV") {
        it(s"return $movementRate") {
          actor.movementRate shouldBe movementRate
        }
      }

      describe("Sanity") {
        it(s"return $sanity") {
          actor.sanity shouldBe sanity
        }
      }

      describe("Sanity Loss") {
        it(s"return $sanityLoss") {
          actor.sanityLoss shouldBe sanityLoss
        }
      }

      describe("Defense") {
        it(s"should be $defense") {
          actor.defense.name shouldBe defense
        }
      }

      describe("Attacks") {
        it(s"should be $attacks") {
          actor.attacks.map(_.name) shouldBe attacks
        }
      }
    }
  }
}
