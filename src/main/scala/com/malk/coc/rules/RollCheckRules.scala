package com.malk.coc.rules

import com.malk.coc.traits.Characteristic
import com.malk.coc.concepts.dices.HundredSidedDice

object RollCheckRules {
  def characteristicCheck(
      characteristic: Characteristic,
      difficulty: RollDifficulty = Regular
  )(implicit hundredSidedDice: HundredSidedDice): RollResult = {
    val adjustedValue = needed(characteristic.value, difficulty)

    // Throw exception, impossible
    if (adjustedValue == 0) throw new RuntimeException("Impossible to succeed")

    hundredSidedDice.roll match {
      case 100                                          => Fumble
      case 1                                            => CriticalSuccess
      case rolled if rolled <= (adjustedValue / 5)      => ExtremeSuccess
      case rolled if rolled <= (adjustedValue / 2)      => HardSuccess
      case rolled if rolled <= adjustedValue            => Success
      case rolled if rolled >= 96 && adjustedValue < 50 => Fumble
      case _                                            => Failure
    }
  }

  private def needed(value: Int, difficulty: RollDifficulty) =
    difficulty match {
      case Regular => value
      case Hard    => value / 2
      case Extreme => value / 5
    }

  sealed trait RollDifficulty
  case object Regular extends RollDifficulty
  case object Hard extends RollDifficulty
  case object Extreme extends RollDifficulty

  sealed trait RollResult
  case object Fumble extends RollResult
  case object Failure extends RollResult
  case object Success extends RollResult
  case object HardSuccess extends RollResult
  case object ExtremeSuccess extends RollResult
  case object CriticalSuccess extends RollResult
}
