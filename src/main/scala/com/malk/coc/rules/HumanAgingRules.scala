package com.malk.coc.rules

import scala.annotation.tailrec

import com.malk.coc.concepts.characteristics.Age
import com.malk.coc.concepts.abstractions.Body
import com.malk.coc.concepts.dices.TetrahedronDice
import com.malk.coc.concepts.dices.CubeDice
import com.malk.coc.concepts.characteristics.Education
import com.malk.coc.concepts.dices.HundredSidedDice
import com.malk.coc.concepts.dices.DeltohedronDice
import com.malk.coc.concepts.characteristics.Appearance

class HumanAgingRules(age: Age)(implicit
    tetrahedronDice: TetrahedronDice,
    cubeDice: CubeDice,
    deltohedronDice: DeltohedronDice,
    hundredSidedDice: HundredSidedDice
) {
  def on(body: Body): Body = {
    age.value match {
      case x if x >= 80 =>
        Body(
          body.strength.copy(value = body.strength.value - 26),
          body.constitution.copy(value = body.constitution.value - 26),
          body.dexterity.copy(value = body.dexterity.value - 28),
          body.size
        )
      case x if x >= 70 =>
        Body(
          body.strength.copy(value = body.strength.value - 13),
          body.constitution.copy(value = body.constitution.value - 13),
          body.dexterity.copy(value = body.dexterity.value - 14),
          body.size
        )
      case x if x >= 60 =>
        Body(
          body.strength.copy(value = body.strength.value - 6),
          body.constitution.copy(value = body.constitution.value - 6),
          body.dexterity.copy(value = body.dexterity.value - 8),
          body.size
        )
      case x if x >= 50 =>
        Body(
          body.strength.copy(value = body.strength.value - 3),
          body.constitution.copy(value = body.constitution.value - 3),
          body.dexterity.copy(value = body.dexterity.value - 4),
          body.size
        )
      case x if x >= 40 =>
        Body(
          body.strength.copy(value = body.strength.value - 2),
          body.constitution.copy(value = body.constitution.value - 2),
          body.dexterity.copy(value = body.dexterity.value - 1),
          body.size
        )
      case x if x >= 20 =>
        Body(
          body.strength,
          body.constitution,
          body.dexterity,
          body.size
        )
      case _ =>
        Body(
          body.strength.copy(value = body.strength.value - 3),
          body.constitution,
          body.dexterity,
          body.size.copy(value = body.size.value - 2)
        )
    }
  }

  def on(edu: Education): Education = {
    val result = age.value match {
      case x if x < 20  => edu.copy(edu.value - 5)
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
      val x = age.value - 40

      (app - (((x / 10) + 1) * 5)).asInstanceOf[Appearance]
    }
  }

  @tailrec
  private def checkEDUIncrease(edu: Education, times: Int = 1): Education = {
    val newEdu =
      if (hundredSidedDice.roll > edu.value) edu + deltohedronDice.roll else edu

    if (times == 1) newEdu else checkEDUIncrease(newEdu, times - 1)
  }
}
