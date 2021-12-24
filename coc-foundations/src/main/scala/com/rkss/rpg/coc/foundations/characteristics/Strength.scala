package com.rkss.rpg.coc.foundations.characteristics

final case class Strength(override protected val baseValue: Int)
    extends GenericCharacteristic("Strength", baseValue)
