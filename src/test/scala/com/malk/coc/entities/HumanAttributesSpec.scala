package com.malk.coc.entities

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.malk.coc.concepts.characteristics._
import com.malk.coc.helpers.Dice

class HumanAttributesSpec extends AnyFunSpec with Matchers {
  import com.malk.coc.rules.HumanAgingEffectOnEducation.implicits._
  import com.malk.coc.rules.HumanMobility._
  import com.malk.coc.rules.HumanAgingEffectOnAppearance._
  import com.malk.coc.rules.HumanAgingEffectOnBody._

  describe("Human MOV") {
    val str = Strength(50)
    val dex = Dexterity(50)
    val siz = Size(50)
    val age = Dice.randomAge(40, 49)
    val con = Constitution(45)
    val app = Appearance(65)
    val edu = Education(48)

    val baseMOV = 8

    describe(s"when ${age} - ${str} - ${dex} - ${siz}") {
      val expected = 8 -1 - 1

      val human = Human(
        age,
        str,
        siz,
        dex,
        con,
        app,
        edu
      )

      it(s"should have MOV ${expected}") {
        human.MOV shouldBe expected
      }
    }
  }
}
