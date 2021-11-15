package com.malk.coc.rules

import com.malk.coc.concepts.characteristics.Age
import com.malk.coc.concepts.abstractions.Body
import com.malk.coc.concepts.dices.TetrahedronDice
import com.malk.coc.concepts.dices.CubeDice

object HumanAgingEffectOnBody {
  implicit def modifiedBody(
      age: Age,
      body: Body
  )(implicit
      tetrahedronDice: TetrahedronDice,
      cubeDice: CubeDice
  ): Body = {
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
}
