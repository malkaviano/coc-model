package com.malk.coc.concepts.abstractions

import com.malk.coc.concepts.characteristics.Strength
import com.malk.coc.concepts.characteristics.Constitution
import com.malk.coc.concepts.characteristics.Dexterity
import com.malk.coc.concepts.characteristics.Size
import com.malk.coc.concepts.attributes.Build

final case class Body private (
    characteristics: (Strength, Constitution, Dexterity, Size)
) {
  val constitution: Constitution = characteristics._2

  val strength: Strength = characteristics._1

  val size: Size = characteristics._4

  val dexterity: Dexterity = characteristics._3

  val build: Build = Build(this)
}

object Body {
  def apply(
      str: Strength,
      con: Constitution,
      dex: Dexterity,
      siz: Size
  ): Body = {
    Body((str, con, dex, siz))
  }
}
