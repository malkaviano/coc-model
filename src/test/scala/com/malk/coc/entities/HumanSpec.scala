package com.malk.coc.entities

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.malk.coc.helpers.DiceHelper
import com.malk.coc.concepts.characteristics.Strength
import com.malk.coc.concepts.characteristics.Dexterity
import com.malk.coc.concepts.characteristics.Constitution
import com.malk.coc.concepts.characteristics.Appearance
import com.malk.coc.concepts.characteristics.Education
import com.malk.coc.concepts.characteristics.Intelligence
import com.malk.coc.concepts.characteristics.Power
import com.malk.coc.concepts.abstractions.Body
import com.malk.coc.concepts.abstractions.Brain
import com.malk.coc.rules.HumanAgingRules
import com.malk.coc.concepts.attributes.Sanity
import com.malk.coc.concepts.attributes.MaximumMagicPoints
import com.malk.coc.concepts.characteristics.Size

class HumanSpec extends AnyFunSpec with Matchers {
  import com.malk.coc.helpers.DiceHelper.implicits._

  describe("Human") {
    val age = DiceHelper.randomAge()

    // TODO: Refactor with random data
    val str = Strength(50)
    val siz = Size(60)
    val dex = Dexterity(70)
    val con = Constitution(45)
    val app = Appearance(65)
    val edu = Education(48)
    val int = Intelligence(56)
    val pow = Power(43)

    val body = Body(str, con, dex, siz)
    val brain = Brain(int, pow)

    implicit val humanAgingRules = new HumanAgingRules(age)

    val sanity = Sanity(80)

    val mp = MaximumMagicPoints(34)

    val human = Human(
      age,
      body,
      app,
      edu,
      brain,
      sanity,
      mp
    )

    it("should have Age") {
      human.Age shouldBe age.value
    }
  }
}
