package com.malk.coc.externals.abstractions

import com.malk.coc.concepts.characteristics.Strength
import com.malk.coc.concepts.characteristics.Constitution
import com.malk.coc.concepts.characteristics.Dexterity
import com.malk.coc.concepts.characteristics.Size

final case class Body private (characteristics: (Strength, Constitution, Dexterity, Size)) {
  def constitution: Constitution = characteristics._2

  def strength: Strength = characteristics._1

  def size: Size = characteristics._4

  def dexterity: Dexterity = characteristics._3
}

object Body {
  def apply(str: Strength, con: Constitution, dex: Dexterity, siz: Size): Body = {
    Body((str, con, dex, siz))
  }
}