package com.malk.coc.rules

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
import org.scalamock.scalatest.MockFactory

import com.malk.coc.concepts.characteristics._
import com.malk.coc.concepts.dices.SixSidedDice
import com.malk.coc.traits.Characteristic
import com.malk.coc.concepts.dices.FourSidedDice
import com.malk.coc.concepts.abstractions.Body
import com.malk.coc.concepts.abstractions.Brain
import com.malk.coc.concepts.attributes.Luck
import com.malk.coc.concepts.attributes.Age

class InvestigatorGeneratorSpec
    extends AnyFunSpec
    with Matchers
    with MockFactory {
  val rollD6 = mockFunction[(Int, Int), Int]
  implicit val sixSidedDice = SixSidedDice(rollD6)

  val rollD4 = mockFunction[(Int, Int), Int]
  implicit val fourSidedDice = FourSidedDice(rollD4)

  describe("Generating random Strength using 3D6 * 5") {
    val str = Strength(60)

    behaveLike3D6Mult5(
      () => InvestigatorGenerator.randomStrength,
      Seq(3, 4, 5),
      str
    )
  }

  describe("Generating random Constitution using 3D6 * 5") {
    val con = Constitution(50)

    behaveLike3D6Mult5(
      () => InvestigatorGenerator.randomConstitution,
      Seq(3, 2, 5),
      con
    )
  }

  describe("Generating random Dexterity using 3D6 * 5") {
    val dex = Dexterity(65)

    behaveLike3D6Mult5(
      () => InvestigatorGenerator.randomDexterity,
      Seq(6, 2, 5),
      dex
    )
  }

  describe("Generating random Appearance using 3D6 * 5") {
    val app = Appearance(75)

    behaveLike3D6Mult5(
      () => InvestigatorGenerator.randomAppearance,
      Seq(4, 6, 5),
      app
    )
  }

  describe("Generating random Power using 3D6 * 5") {
    val pow = Power(30)

    behaveLike3D6Mult5(
      () => InvestigatorGenerator.randomPower,
      Seq(1, 2, 3),
      pow
    )
  }

  describe("Generating random Size using (2D6 + 6) * 5") {
    val siz = Size(60)

    behaveLike2D6Plus6Mult5(
      () => InvestigatorGenerator.randomSize,
      Seq(4, 2),
      siz
    )
  }

  describe("Generating random Intelligence using (2D6 + 6) * 5") {
    val int = Intelligence(65)

    behaveLike2D6Plus6Mult5(
      () => InvestigatorGenerator.randomIntelligence,
      Seq(4, 3),
      int
    )
  }

  describe("Generating random Education using (2D6 + 6) * 5") {
    val int = Education(85)

    behaveLike2D6Plus6Mult5(
      () => InvestigatorGenerator.randomEducation,
      Seq(5, 6),
      int
    )
  }

  describe("Generating random Body") {
    val expected = Body(Strength(15), Constitution(15), Dexterity(15), Size(40))

    it(s"should equal ${expected}") {
      Seq(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1).foreach(
        rollD6.expects((1, 6)).once().returning(_)
      )

      import InvestigatorGenerator.implicits._

      val result = InvestigatorGenerator.randomBody

      result shouldBe expected
    }
  }

  describe("Generating random Brain") {
    val expected = Brain(Intelligence(40), Power(15))

    it(s"should equal ${expected}") {
      Seq(1, 1, 1, 1, 1).foreach(rollD6.expects((1, 6)).once().returning(_))

      import InvestigatorGenerator.implicits._

      val result = InvestigatorGenerator.randomBrain

      result shouldBe expected
    }
  }

  describe("Generating random Age") {
    val age = InvestigatorGenerator.randomAge

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
            rollD6.expects((1, 6)).once().returning(_)
          )

          val result = InvestigatorGenerator.randomLuck(sixSidedDice, age1)

          result shouldBe luck2
        }
      }
    }

    describe(s"when ${age2}") {
      it(s"should return ${luck1}") {
        Seq(1, 1, 1).foreach(
          rollD6.expects((1, 6)).once().returning(_)
        )

        val result = InvestigatorGenerator.randomLuck(sixSidedDice, age2)

        result shouldBe luck1
      }
    }
  }

  // describe("Generating random investigator") {
  //   import InvestigatorGenerator.implicits._

  //   Human(
  //     age,
  //     body,
  //     app,
  //     edu,
  //     luck,
  //     brain,
  //     sanity,
  //     mp
  //   )
  // }

  private def behaveLike3D6Mult5(
      func: => () => Characteristic,
      rolls: Seq[Int],
      expected: Characteristic
  ): Unit = {
    it(s"should return ${expected}") {
      rolls.foreach(rollD6.expects((1, 6)).once().returning(_))

      func() shouldBe expected
    }
  }

  private def behaveLike2D6Plus6Mult5(
      func: => () => Characteristic,
      rolls: Seq[Int],
      expected: Characteristic
  ): Unit = {
    it(s"should return ${expected}") {
      rolls.foreach(rollD6.expects((1, 6)).once().returning(_))

      func() shouldBe expected
    }
  }
}
