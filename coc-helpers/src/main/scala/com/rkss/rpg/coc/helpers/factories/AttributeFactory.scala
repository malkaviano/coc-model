package com.rkss.rpg.coc.helpers.factories

import com.rkss.rpg.coc.fundamentals.attributes._
import com.rkss.rpg.helpers.dice._
import com.rkss.rpg.coc.helpers.generators._
import com.rkss.rpg.coc.concepts.characteristic._
import com.rkss.rpg.coc.concepts.attributes.sanity._
import com.rkss.rpg.coc.concepts.attributes.luck._
import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.concepts.attributes._

object AttributeFactory {
  def createLuck(value: Int): Luck = {
    LuckImpl(value)
  }

  def createLuck(implicit
      sixSidedDice: SixSidedDice
  ): Luck = {
    val value = RngValuesGenerator.creationValue(3, 5, 0)

    createLuck(value)
  }

  def createSanity(
      power: Characteristic[Power.type],
      mythos: Skill[CthulhuMythos.type]
  ): Sanity = {
    SanityImpl(power, mythos)
  }

  def createMagicPoints(power: Characteristic[Power.type]): MagicPoints = {
    MagicPointsImpl(power)
  }

  def createHitPoints(
      size: Characteristic[Size.type],
      constitution: Characteristic[Constitution.type]
  ): HitPoints = {
    HitPointsImpl(size, constitution)
  }

  def createAge(age: Int, maximumAge: Int = 100): Age = {
    HumanAge(age, maximumAge)
  }

  def createBuild(
      strength: Characteristic[Strength.type],
      size: Characteristic[Size.type]
  ): Build = {
    BuildImpl(strength, size)
  }

  def createDamageBonus(
      strength: Characteristic[Strength.type],
      size: Characteristic[Size.type]
  )(implicit
      fourSidedDice: FourSidedDice,
      sixSidedDice: SixSidedDice
  ): DamageBonus = {
    DamageBonusImpl(strength, size)
  }

  def createMovementRate(
      strength: Characteristic[Strength.type],
      dexterity: Characteristic[Dexterity.type],
      size: Characteristic[Size.type]
  ): MovementRate = {
    HumanMovementRate(strength, dexterity, size)
  }
}
