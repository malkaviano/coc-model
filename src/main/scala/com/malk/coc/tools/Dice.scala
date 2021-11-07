package com.malk.coc.tools

object Dice {
  import scala.util.Random

  def roll10 = rollBetween(1, 11)

  private def rollBetween(min: Int, max: Int) = Random.between(min, max)
}