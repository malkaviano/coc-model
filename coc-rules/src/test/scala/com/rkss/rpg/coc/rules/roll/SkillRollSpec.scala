package com.rkss.rpg.coc.rules.roll

import org.scalatest.matchers.should.Matchers
import org.scalatest.funspec.AnyFunSpec
import org.scalamock.scalatest.MockFactory

import com.rkss.rpg.coc.concepts.characteristics._
import com.rkss.rpg.helpers.dice.HundredSidedDice
import com.rkss.rpg.helpers.traits._
import com.rkss.rpg.coc.concepts.roll._

class SkillRollSpec extends AnyFunSpec with Matchers with MockFactory {
  val rollable = FakePrimaryCharacteristic(50)

  describe("Making a skill roll") {
    behaveLikeMakingASkillRoll(rollable, 48, RegularSuccess, RegularDifficulty)
    behaveLikeMakingASkillRoll(rollable, 60, Failure, RegularDifficulty)
    behaveLikeMakingASkillRoll(rollable, 100, Fumble, RegularDifficulty)
    // behaveLikeMakingASkillRoll(rollable, 20, HardSuccess, RegularDifficulty)
    // behaveLikeMakingASkillRoll(rollable, 5, ExtremeSuccess, RegularDifficulty)
    behaveLikeMakingASkillRoll(rollable, 1, CriticalSuccess, RegularDifficulty)
  }

  private def behaveLikeMakingASkillRoll(
      rollable: Rollable,
      diceResult: Int,
      result: SkillRollResult,
      difficulty: SkillRollDifficultyLevel
  ): Unit = {
    val fakeRng: DiceRange => DiceResult = _ => FakeDiceResult(diceResult)

    val mockedDice = HundredSidedDice(fakeRng)

    val skillRoll = SkillRoll(rollable)(mockedDice)

    describe(s"when difficulty is $difficulty") {
      describe(
        s"when tested skill has regular value ${rollable.value(difficulty)}"
      ) {
        describe(s"when rolling a $diceResult") {
          it(s"should return $result") {
            skillRoll.result shouldBe result
          }
        }
      }
    }
  }
}

final case class FakeDiceResult(override val value: Int) extends DiceResult

final case class FakePrimaryCharacteristic(private val base: Int)
    extends PrimaryCharacteristic {

  override def value(difficulty: SkillRollDifficultyLevel): Int = {
    this.base
  }

}
