package com.rkss.rpg.coc.helpers.factories

import com.rkss.rpg.coc.fundamentals.attributes._
import com.rkss.rpg.helpers.dice._
import com.rkss.rpg.coc.helpers.generators._
import com.rkss.rpg.coc.concepts.characteristic._
import com.rkss.rpg.coc.fundamentals.skills._
import com.rkss.rpg.coc.concepts.sanity._

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

  def createSanity(power: Characteristic[Power.type], mythos: CthulhuMythosSkill): Sanity = {
    InvestigatorSanity(power, mythos)
  }
}
