package com.malk.coc.entities

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.malk.coc.concepts.characteristics._
import com.malk.coc.helpers.DiceHelper
import com.malk.coc.concepts.attributes.MovementRate
import com.malk.coc.concepts.attributes.Build
import com.malk.coc.concepts.attributes.DamageBonus
import com.malk.coc.concepts.abstractions.Body
import com.malk.coc.concepts.abstractions.Brain

class HumanAttributesSpec extends AnyFunSpec with Matchers {
  import com.malk.coc.helpers.DiceHelper.implicits._
  import com.malk.coc.rules.HumanAgingEffectOnEducation.implicits._
  import com.malk.coc.rules.HumanMobility._
  import com.malk.coc.rules.HumanAgingEffectOnAppearance._

  describe("Human Attributes") {
    val str = Strength(50)
    val dex = Dexterity(50)
    val siz = Size(50)
    val age = DiceHelper.randomAge(40, 49)
    val con = Constitution(45)
    val app = Appearance(65)
    val edu = Education(48)
    val luck = Luck(34)
    val int = Intelligence(56)
    val pow = Power(43)

    val body = Body(str, con, dex, siz)
    val brain = Brain(int, pow)

    val human = Human(
      age,
      body,
      app,
      edu,
      luck,
      brain
    )

    describe("Human MovementRate (MOV)") {
      describe(
        s"when Age ${human.Age} - STR ${human.STR} - DEX ${human.DEX} - SIZ ${human.SIZ}"
      ) {

        val mov = MovementRate(8 - 1 - 1)

        it(s"should have MOV ${mov.value}") {
          human.MOV shouldBe mov.value
        }

      }
    }

    describe("Human Current Hit Points (HP)") {
      it(s"should have Current Hit Points (HP) equal ${body.maximumHitPoints.value}") {
        human.HP shouldBe body.maximumHitPoints.value
      }

      it(s"should change Current Hit Points (HP) from ${body.maximumHitPoints.value} to ${20}") {
        human.HP = 20

        human.HP shouldBe 20
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
  }
}
