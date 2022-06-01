package com.rkss.rpg.coc.concepts.horror

import com.rkss.rpg.helpers.dice.Bag._

sealed trait SanityHorror {
  def name: HorrorName
  def success: Int
  def failure: Int
  def maximum: Int
}

case object MummyHorror extends SanityHorror {
  override val name = MummyMonster
  override val success = 1
  override def failure = eightSidedDice.roll.value
  override val maximum = 8
}

case object SkeletonHorror extends SanityHorror {
  override val name = SkeletonMonster
  override val success = 0
  override def failure = sixSidedDice.roll.value
  override val maximum = 6
}

case object ZombieHorror extends SanityHorror {
  override val name = ZombieMonster
  override val success = 0
  override def failure = eightSidedDice.roll.value
  override val maximum = 8
}
