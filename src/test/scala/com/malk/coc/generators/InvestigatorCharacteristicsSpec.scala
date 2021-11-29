package com.malk.coc.generators

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
import org.scalamock.scalatest.MockFactory

import com.malk.coc.concepts.characteristics._
import com.malk.coc.abstractions.dices._
import com.malk.coc.traits.Characteristic
import com.malk.coc.abstractions.Body
import com.malk.coc.abstractions.Brain

class InvestigatorCharacteristicsSpec
    extends AnyFunSpec
    with Matchers
    with MockFactory {
  val rollD6 = mockFunction[DiceRange, Int]
  implicit val sixSidedDice = SixSidedDice(rollD6)

  val rollD4 = mockFunction[DiceRange, Int]
  implicit val fourSidedDice = FourSidedDice(rollD4)

  describe("Generating random Strength using 3D6 * 5") {
    val str = Strength(60)

    behaveLike3D6Mult5(
      () => InvestigatorCharacteristics.randomStrength,
      Seq(3, 4, 5),
      str
    )
  }

  describe("Generating random Constitution using 3D6 * 5") {
    val con = Constitution(50)

    behaveLike3D6Mult5(
      () => InvestigatorCharacteristics.randomConstitution,
      Seq(3, 2, 5),
      con
    )
  }

  describe("Generating random Dexterity using 3D6 * 5") {
    val dex = Dexterity(65)

    behaveLike3D6Mult5(
      () => InvestigatorCharacteristics.randomDexterity,
      Seq(6, 2, 5),
      dex
    )
  }

  describe("Generating random Appearance using 3D6 * 5") {
    val app = Appearance(75)

    behaveLike3D6Mult5(
      () => InvestigatorCharacteristics.randomAppearance,
      Seq(4, 6, 5),
      app
    )
  }

  describe("Generating random Power using 3D6 * 5") {
    val pow = Power(30)

    behaveLike3D6Mult5(
      () => InvestigatorCharacteristics.randomPower,
      Seq(1, 2, 3),
      pow
    )
  }

  describe("Generating random Size using (2D6 + 6) * 5") {
    val siz = Size(60)

    behaveLike2D6Plus6Mult5(
      () => InvestigatorCharacteristics.randomSize,
      Seq(4, 2),
      siz
    )
  }

  describe("Generating random Intelligence using (2D6 + 6) * 5") {
    val int = Intelligence(65)

    behaveLike2D6Plus6Mult5(
      () => InvestigatorCharacteristics.randomIntelligence,
      Seq(4, 3),
      int
    )
  }

  describe("Generating random Education using (2D6 + 6) * 5") {
    val int = Education(85)

    behaveLike2D6Plus6Mult5(
      () => InvestigatorCharacteristics.randomEducation,
      Seq(5, 6),
      int
    )
  }

  describe("Generating random Body") {
    val expected = Body(Strength(15), Constitution(15), Dexterity(15), Size(40))

    it(s"should equal ${expected}") {
      Seq(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1).foreach(
        rollD6.expects(DiceRange(1, 6)).once().returning(_)
      )

      import InvestigatorCharacteristics.implicits._

      val result = InvestigatorCharacteristics.randomBody

      result shouldBe expected
    }
  }

  describe("Generating random Brain") {
    val expected = Brain(Intelligence(40), Power(15))

    it(s"should equal ${expected}") {
      Seq(1, 1, 1, 1, 1).foreach(rollD6.expects(DiceRange(1, 6)).once().returning(_))

      import InvestigatorCharacteristics.implicits._

      val result = InvestigatorCharacteristics.randomBrain

      result shouldBe expected
    }
  }

  private def behaveLike3D6Mult5(
      func: => () => Characteristic,
      rolls: Seq[Int],
      expected: Characteristic
  ): Unit = {
    it(s"should return ${expected}") {
      rolls.foreach(rollD6.expects(DiceRange(1, 6)).once().returning(_))

      func() shouldBe expected
    }
  }

  private def behaveLike2D6Plus6Mult5(
      func: => () => Characteristic,
      rolls: Seq[Int],
      expected: Characteristic
  ): Unit = {
    it(s"should return ${expected}") {
      rolls.foreach(rollD6.expects(DiceRange(1, 6)).once().returning(_))

      func() shouldBe expected
    }
  }
}
