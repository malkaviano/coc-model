package com.malk.coc.rules

import scala.annotation.tailrec

import com.malk.coc.concepts.attributes.Age
import com.malk.coc.abstractions.Body
import com.malk.coc.abstractions.dices.FourSidedDice
import com.malk.coc.abstractions.dices.SixSidedDice
import com.malk.coc.concepts.characteristics.Education
import com.malk.coc.abstractions.dices.HundredSidedDice
import com.malk.coc.abstractions.dices.TenSidedDice
import com.malk.coc.concepts.characteristics.Appearance
import com.malk.coc.concepts.attributes.MovementRate
import com.malk.coc.helpers.CharacteristicModifications.Modification
import com.malk.coc.concepts.characteristics._

class HumanAgingRules(age: Age)(implicit
    fourSidedDice: FourSidedDice,
    sixSidedDice: SixSidedDice,
    tenSidedDice: TenSidedDice,
    hundredSidedDice: HundredSidedDice
) {
  def on(body: Body): Body = {
    age.value match {
      case x if x >= 80 =>
        modifyBody(
          body,
          Modification[Strength](-26),
          Modification[Constitution](-26),
          Modification[Dexterity](-28),
          Modification[Size](0)
        )
      case x if x >= 70 =>
        modifyBody(
          body,
          Modification[Strength](-13),
          Modification[Constitution](-13),
          Modification[Dexterity](-14),
          Modification[Size](0)
        )
      case x if x >= 60 =>
        modifyBody(
          body,
          Modification[Strength](-6),
          Modification[Constitution](-6),
          Modification[Dexterity](-8),
          Modification[Size](0)
        )
      case x if x >= 50 =>
        modifyBody(
          body,
          Modification[Strength](-3),
          Modification[Constitution](-3),
          Modification[Dexterity](-4),
          Modification[Size](0)
        )
      case x if x >= 40 =>
        modifyBody(
          body,
          Modification[Strength](-2),
          Modification[Constitution](-2),
          Modification[Dexterity](-1),
          Modification[Size](0)
        )
      case x if x >= 20 =>
        body
      case _ =>
        modifyBody(
          body,
          Modification[Strength](-3),
          Modification[Constitution](0),
          Modification[Dexterity](0),
          Modification[Size](-2)
        )
    }
  }

  def on(edu: Education): Education = {
    val result = age.value match {
      case x if x < 20  => edu - Modification[Education](5)
      case x if x >= 60 => checkEDUIncrease(edu, 4)
      case x if x >= 50 => checkEDUIncrease(edu, 3)
      case x if x >= 40 => checkEDUIncrease(edu, 2)
      case _            => checkEDUIncrease(edu)
    }

    if (result.value >= 100) Education(99) else result
  }

  def on(app: Appearance): Appearance = {
    if (age.value < 40) {
      app
    } else {
      val x = (age - 40).value

      app - Modification[Appearance](((x / 10) + 1) * 5)
    }
  }

  def movFor(body: Body): MovementRate = {
    val result =
      if (
        body.strength.value < body.size.value && body.dexterity.value < body.size.value
      )
        7
      else if (
        body.strength.value > body.size.value && body.dexterity.value > body.size.value
      )
        9
      else
        8

    val delta = (age - 40).value

    val value = if (delta < 0) {
      result
    } else {
      result - ((delta / 10) + 1)
    }

    MovementRate(value)
  }

  @tailrec
  private def checkEDUIncrease(edu: Education, times: Int = 1): Education = {
    import com.malk.coc.rules.RollRules.RollResult.implicits._

    val newEdu =
      if (!RollRules.characteristicCheck((edu))) edu + Modification[Education](tenSidedDice.roll) else edu

    if (times == 1) newEdu else checkEDUIncrease(newEdu, times - 1)
  }

  private def modifyBody(
      body: Body,
      str: Modification[Strength],
      con: Modification[Constitution],
      dex: Modification[Dexterity],
      siz: Modification[Size]
  ): Body = {
    Body(
      body.strength + str,
      body.constitution + con,
      body.dexterity + dex,
      body.size + siz
    )
  }
}
