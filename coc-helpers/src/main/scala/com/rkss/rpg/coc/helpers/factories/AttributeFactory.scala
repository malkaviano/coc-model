package com.rkss.rpg.coc.helpers.factories

import com.rkss.rpg.coc.fundamentals.attributes._
import com.rkss.rpg.helpers.dice._
import com.rkss.rpg.coc.helpers.generators._
import com.rkss.rpg.coc.concepts.characteristic._
import com.rkss.rpg.coc.concepts.attributes.sanity._
import com.rkss.rpg.coc.concepts.attributes.luck._
import com.rkss.rpg.coc.concepts.skill._

object AttributeFactory {
  def createLuck(value: Int): Luck = {
    InvestigatorLuck(value)
  }

  def createLuck(implicit
      sixSidedDice: SixSidedDice
  ): Luck = {
    val value = RngValuesGenerator.creationValue(3, 5, 0)

    createLuck(value)
  }

  def createSanity(power: Characteristic[Power.type], mythos: Skill[CthulhuMythos.type]): Sanity = {
    InvestigatorSanity(power, mythos)
  }
}
