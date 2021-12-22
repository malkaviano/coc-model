package com.rkss.rpg.coc.foundations.characteristics

final case class Strength(override protected val base: Int)
    extends GenericCharacteristic("Strength", base)
