package com.rkss.rpg.coc.fundamentals.scenarios

import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.GivenWhenThen
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.coc.rules.testing.TestingProps
import com.rkss.rpg.helpers.dice.HundredSidedDice
import com.rkss.rpg.coc.fundamentals.specs._

trait SanityRollScenario {
  self: AnyFeatureSpec with GivenWhenThen with Matchers =>

  def makingASanityRoll(spec: SanityRollSpec): Unit = {
    val (sanity, result, rolled) = (
      spec.entity,
      spec.result,
      spec.rolled
    )

    val expected = spec.expected

    Scenario(s"Making a sanity roll for ${sanity}") {
      Given(s"My current Sanity points are ${sanity.current}")

      When(s"I roll a ${rolled} in the hundred dice")
      val hundredSidedDice =
        HundredSidedDice(TestingProps.fakeRng(Seq(rolled)))

      Then(s"The result should be $expected")
      sanity.roll(
        hundredSidedDice
      ) shouldBe expected
    }
  }
}
