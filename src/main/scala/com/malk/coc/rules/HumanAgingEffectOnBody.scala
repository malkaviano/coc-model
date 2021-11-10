package com.malk.coc.rules

import com.malk.coc.concepts.characteristics.Strength
import com.malk.coc.concepts.characteristics.Constitution
import com.malk.coc.concepts.characteristics.Dexterity
import com.malk.coc.concepts.characteristics.Size
import com.malk.coc.concepts.characteristics.Age

object HumanAgingEffectOnBody {
  def modifiedPhysical(
      age: Age,
      str: Strength,
      con: Constitution,
      dex: Dexterity,
      siz: Size
  ): (
      Strength,
      Constitution,
      Dexterity,
      Size
  ) = {
    age.value match {
      case x if x >= 80 =>
        (
          str.copy(value = str.value - 26),
          con.copy(value = con.value - 26),
          dex.copy(value = dex.value - 28),
          siz
        )
      case x if x >= 70 =>
        (
          str.copy(value = str.value - 13),
          con.copy(value = con.value - 13),
          dex.copy(value = dex.value - 14),
          siz
        )
      case x if x >= 60 =>
        (
          str.copy(value = str.value - 6),
          con.copy(value = con.value - 6),
          dex.copy(value = dex.value - 8),
          siz
        )
      case x if x >= 50 =>
        (
          str.copy(value = str.value - 3),
          con.copy(value = con.value - 3),
          dex.copy(value = dex.value - 4),
          siz
        )
      case x if x >= 40 =>
        (
          str.copy(value = str.value - 2),
          con.copy(value = con.value - 2),
          dex.copy(value = dex.value - 1),
          siz
        )
      case x if x >= 20 =>
        (
          str,
          con,
          dex,
          siz
        )
      case _ =>
        (
          str.copy(value = str.value - 3),
          con,
          dex,
          siz.copy(value = siz.value - 2)
        )
    }

  }
}
