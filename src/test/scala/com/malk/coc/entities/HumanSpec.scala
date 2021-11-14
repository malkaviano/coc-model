package com.malk.coc.entities

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.malk.coc.concepts.characteristics.Sanity
import com.malk.coc.helpers.Dice
import com.malk.coc.concepts.characteristics.Strength
import com.malk.coc.concepts.characteristics.Size
import com.malk.coc.concepts.characteristics.Dexterity
import com.malk.coc.concepts.characteristics.Constitution
import com.malk.coc.concepts.characteristics.Appearance
import com.malk.coc.concepts.characteristics.Education
import com.malk.coc.concepts.characteristics.Luck
import com.malk.coc.concepts.characteristics.Intelligence
import com.malk.coc.concepts.characteristics.Power
import com.malk.coc.concepts.abstractions.Body
import com.malk.coc.concepts.abstractions.Brain

class HumanSpec extends AnyFunSpec with Matchers {
  describe("Human") {
    val age = Dice.randomAge()

    // TODO: Refactor with random data
    val str = Strength(50)
    val siz = Size(60)
    val dex = Dexterity(70)
    val con = Constitution(45)
    val app = Appearance(65)
    val edu = Education(48)
    val luck = Luck(34)
    val int = Intelligence(56)
    val pow = Power(43)

    val body = Body(str, con, dex, siz)
    val brain = Brain(int, pow)

    import com.malk.coc.rules.HumanAgingEffectOnEducation.implicits._
    import com.malk.coc.rules.HumanMobility._
    import com.malk.coc.rules.HumanAgingEffectOnAppearance._
    import com.malk.coc.rules.HumanAgingEffectOnBody._

    val human = Human(
      age,
      body,
      app,
      edu,
      luck,
      brain
    )

    it("should have Age") {
      human.Age shouldBe age.value
    }

    describe("Sanity") {
      val sanity = Sanity(99)

      it(s"should have default ${sanity}") {
        human.Sanity shouldBe sanity.value
      }

      describe("when custom Sanity is used") {
        val sanity = Sanity(81)

        val human = Human(
          age,
          body,
          app,
          edu,
          luck,
          brain,
          sanity
        )

        it(s"should have ${sanity}") {
          human.Sanity shouldBe sanity.value
        }
      }
    }
  }

}
