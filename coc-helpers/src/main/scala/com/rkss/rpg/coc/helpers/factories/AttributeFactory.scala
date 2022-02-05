package com.rkss.rpg.coc.helpers.factories

import com.rkss.rpg.coc.fundamentals.attributes._
import com.rkss.rpg.helpers.dice._
import com.rkss.rpg.coc.helpers.generators._

object AttributeFactory {
  def createLuck(value: Int): Luck = {
    Luck(value)
  }

  def createLuck(implicit
      sixSidedDice: SixSidedDice
  ): Luck = {
    val value = RngValuesGenerator.creationValue(3, 5, 0)

    createLuck(value)
  }
}
