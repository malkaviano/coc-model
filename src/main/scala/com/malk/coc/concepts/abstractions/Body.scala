package com.malk.coc.concepts.abstractions

import com.malk.coc.concepts.characteristics.Strength
import com.malk.coc.concepts.characteristics.Constitution
import com.malk.coc.concepts.characteristics.Dexterity
import com.malk.coc.concepts.characteristics.Size
import com.malk.coc.concepts.attributes.Build
import com.malk.coc.concepts.attributes.DamageBonus
import com.malk.coc.concepts.dices.TetrahedronDice
import com.malk.coc.concepts.dices.CubeDice

final case class Body private (
    characteristics: (Strength, Constitution, Dexterity, Size)
)(
    private val tetrahedronDice: TetrahedronDice,
    private val cubeDice: CubeDice
) {
  val constitution: Constitution = characteristics._2

  val strength: Strength = characteristics._1

  val size: Size = characteristics._4

  val dexterity: Dexterity = characteristics._3

  val build: Build = Build(this)

  val damageBonus: DamageBonus = DamageBonus(this)(tetrahedronDice, cubeDice)
}

object Body {
  def apply(
      str: Strength,
      con: Constitution,
      dex: Dexterity,
      siz: Size
  )(implicit
      tetrahedronDice: TetrahedronDice,
      cubeDice: CubeDice
  ): Body = {
    Body((str, con, dex, siz))(tetrahedronDice, cubeDice)
  }
}
