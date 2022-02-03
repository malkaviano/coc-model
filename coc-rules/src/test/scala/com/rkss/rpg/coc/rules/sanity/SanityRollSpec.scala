package com.rkss.rpg.coc.rules.sanity

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should

import com.rkss.rpg.coc.rules.testing.fakes._
import com.rkss.rpg.coc.rules.testing.TestingProps
import com.rkss.rpg.helpers.dice._
import com.rkss.rpg.coc.concepts.sanity._
import com.rkss.rpg.coc.concepts._
import com.rkss.rpg.coc.concepts.characteristic._

final class SanityRollSpec extends AnyFunSpec with should.Matchers {
  describe("Sanity Check") {
    val sanity = FakeSanity(FakeGenericCharacteristic(Power, 40))

    val expected =
      SanityRolled(
        sanity.current,
        sanity.maximum,
        SuccessResult,
        RollDiceResult(10)
      )

    it should behave like sanityRoll(sanity, Seq(10), expected)
  }

  private def sanityRoll(
      sanity: FakeSanity,
      check: Seq[Int],
      expected: SanityRolled
  ) = {
    val hundredSidedDice = HundredSidedDice(
      TestingProps.fakeRng(check)
    )

    it(s"return $expected") {
      val sanityRoll = SanityRoll(sanity)(hundredSidedDice)

      val result = sanityRoll.result

      result shouldBe expected
    }
  }
}
