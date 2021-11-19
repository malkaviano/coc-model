package com.malk.coc.entities

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
import org.scalamock.scalatest.MockFactory

import com.malk.coc.concepts.dices._
import com.malk.coc.occupations.Occupation

class InvestigatorSpec extends AnyFunSpec with Matchers with MockFactory {
  describe("Generating random investigator") {
    it("should create an Investigator") {
      import com.malk.coc.helpers.InvestigatorAttributes.implicits._
      import com.malk.coc.helpers.InvestigatorCharacteristics.implicits._
      import com.malk.coc.helpers.InvestigatorOccupationTemplates.implicits._
      import com.malk.coc.helpers.DiceHelper.implicits._

      val rollD10 = mockFunction[(Int, Int), Int]
      val tenSidedDice = TenSidedDice(rollD10)

      rollD10.stubs((1, 10)).returning(6)

      val rollD100 = mockFunction[(Int, Int), Int]
      val hundredSidedDice = HundredSidedDice(rollD100)

      rollD100.stubs((1, 100)).returning(78)

      val rollD6 = mockFunction[(Int, Int), Int]
      implicit val sixSidedDice = SixSidedDice(rollD6)

      rollD6.stubs((1, 6)).returning(4)

      val rollD4 = mockFunction[(Int, Int), Int]
      implicit val fourSidedDice = FourSidedDice(rollD4)

      rollD4.stubs((1, 4)).returning(2)

      /*
       TODO: Spent personal points
       */

      val occupationTemplate = randomOccupationTemplate

      val occupation = Occupation(
        occupationTemplate,
        body,
        brain,
        edu,
        app
      )

      Investigator(
        age,
        body,
        app,
        edu,
        brain,
        luck,
        occupation
      )(fourSidedDice, sixSidedDice, tenSidedDice, hundredSidedDice)

      pending
    }
  }
}
