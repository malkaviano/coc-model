package com.malk.coc.entities

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.malk.coc.concepts.characteristics._
import com.malk.coc.helpers.DiceHelper
import com.malk.coc.concepts.attributes.Build
import com.malk.coc.concepts.attributes.DamageBonus
import com.malk.coc.concepts.abstractions.Body
import com.malk.coc.concepts.abstractions.Brain
import com.malk.coc.rules.HumanAgingRules
import com.malk.coc.concepts.attributes.Sanity
import com.malk.coc.concepts.attributes.MaximumMagicPoints

class HumanAttributesSpec extends AnyFunSpec with Matchers {
  import com.malk.coc.helpers.DiceHelper.implicits._

  describe("Human Attributes") {
    val str = Strength(50)
    val dex = Dexterity(50)
    val siz = Size(50)
    val age = DiceHelper.randomAge(40, 49)
    val con = Constitution(45)
    val app = Appearance(65)
    val edu = Education(48)
    val int = Intelligence(56)
    val pow = Power(43)

    val body = Body(str, con, dex, siz)
    val brain = Brain(int, pow)

    implicit val humanAgingRules = new HumanAgingRules(age)

    val sanity = Sanity(80)
    val mp = MaximumMagicPoints(30)

    val human = Human(
      age,
      body,
      app,
      edu,
      brain,
      sanity,
      mp
    )

    describe("Human attributes") {
      it("should have Age") {
        human.Age shouldBe age.value
      }

      describe("Human MovementRate (MOV)") {
        describe(
          s"when Age ${human.Age} - STR ${human.STR} - DEX ${human.DEX} - SIZ ${human.SIZ}"
        ) {

          val mov = humanAgingRules movFor body

          it(s"should have MOV ${mov.value}") {
            human.MOV shouldBe mov.value
          }

        }
      }

      describe("Human Current Hit Points (HP)") {
        it(
          s"should have Current Hit Points (HP) equal ${body.maximumHitPoints.value}"
        ) {
          human.HP shouldBe body.maximumHitPoints.value
        }
      }

      describe("Human Build") {
        val build = Build(body)

        it(s"should have Build equal ${build.value}") {
          human.Build shouldBe build.value
        }
      }

      describe("Human Damage Bonus (DB)") {
        import com.malk.coc.helpers.DiceHelper.implicits._

        val db = DamageBonus(body)

        it(s"should have DB equal ${db.value}") {
          human.DB shouldBe db.value
        }
      }

      describe("Magic Points (MP)") {
        it(s"should have MP 30") {
          human.MP shouldBe 30
        }
      }

      describe("Sanity (SAN)") {
        it(s"should have SAN 80") {
          human.SAN shouldBe 80
        }
      }
    }
  }
}
