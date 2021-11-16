package com.malk.coc.rules

import com.malk.coc.traits.Characteristic
import com.malk.coc.concepts.dices.HundredSidedDice

object RollCheckRules {
  def characteristicCheck(
      characteristic: Characteristic,
      difficulty: RollDifficulty = RegularDifficulty
  )(implicit hundredSidedDice: HundredSidedDice): RollResult = {
    val adjustedValue = needed(characteristic.value, difficulty)

    // Throw exception, impossible
    if (adjustedValue == 0) throw new RuntimeException("Impossible to succeed")

    hundredSidedDice.roll match {
      case 100                                          => FumbleResult
      case 1                                            => CriticalSuccessResult
      case rolled if rolled <= (adjustedValue / 5)      => ExtremeSuccessResult
      case rolled if rolled <= (adjustedValue / 2)      => HardSuccessResult
      case rolled if rolled <= adjustedValue            => SuccessResult
      case rolled if rolled >= 96 && adjustedValue < 50 => FumbleResult
      case _                                            => FailureResult
    }
  }

  private def needed(value: Int, difficulty: RollDifficulty) =
    difficulty match {
      case RegularDifficulty => value
      case HardDifficulty    => value / 2
      case ExtremeDifficulty => value / 5
    }

  sealed trait RollDifficulty
  case object RegularDifficulty extends RollDifficulty
  case object HardDifficulty extends RollDifficulty
  case object ExtremeDifficulty extends RollDifficulty

  sealed trait RollResult
  case object FumbleResult extends RollResult
  case object FailureResult extends RollResult
  case object SuccessResult extends RollResult
  case object HardSuccessResult extends RollResult
  case object ExtremeSuccessResult extends RollResult
  case object CriticalSuccessResult extends RollResult

  object RollResult {
    object implicits {
      implicit def resultToBoolean(result: RollResult): Boolean = result match {
        case FailureResult => false
        case FumbleResult => false
        case _ => true
      }
    }
  }
}
