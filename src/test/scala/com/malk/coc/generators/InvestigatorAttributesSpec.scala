package com.malk.coc.generators

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
import org.scalamock.scalatest.MockFactory

import com.malk.coc.concepts.dices._
import com.malk.coc.concepts.attributes.Luck
import com.malk.coc.concepts.attributes.Age
import com.malk.coc.concepts.skills.languages._

class InvestigatorAttributesSpec
    extends AnyFunSpec
    with Matchers
    with MockFactory {
  val rollD6 = mockFunction[DiceRange, Int]
  implicit val sixSidedDice = SixSidedDice(rollD6)

  val rollD4 = mockFunction[DiceRange, Int]
  implicit val fourSidedDice = FourSidedDice(rollD4)

  describe("Generating random Age") {
    val age = InvestigatorAttributes.randomAge

    it("should be between 15 and 89") {
      age.value should (be >= 15 and be <= 89)
    }
  }

  describe("Generating random Luck") {
    val luck1 = Luck(15)
    val luck2 = Luck(45)
    val age1 = Age(18)
    val age2 = Age(25)

    describe(s"when ${age1}") {
      describe(s"when generated Lucks are ${luck1} and ${luck2}") {
        it(s"should return ${luck2}") {
          Seq(1, 1, 1, 3, 3, 3).foreach(
            rollD6.expects(DiceRange(1, 6)).once().returning(_)
          )

          val result =
            InvestigatorAttributes.randomLuck(sixSidedDice, age1)

          result shouldBe luck2
        }
      }
    }

    describe(s"when ${age2}") {
      it(s"should return ${luck1}") {
        Seq(1, 1, 1).foreach(
          rollD6.expects(DiceRange(1, 6)).once().returning(_)
        )

        val result = InvestigatorAttributes.randomLuck(sixSidedDice, age2)

        result shouldBe luck1
      }
    }
  }

  describe("Generating random language") {
    val languages: Set[Language] = Set(
      Arabic,
      English,
      German,
      Japanese,
      Portuguese,
      Spanish,
      Chinese,
      French,
      Italian,
      Polish,
      Russian,
      Turkish
    )

    it(s"should return one of ${languages}") {
      val result = InvestigatorAttributes.randomLanguage

      languages should contain (result)
    }
  }
}
