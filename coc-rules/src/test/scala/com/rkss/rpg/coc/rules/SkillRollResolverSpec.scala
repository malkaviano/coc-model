package com.rkss.rpg.coc.rules

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.helpers.dice.HundredSidedDice
import com.rkss.rpg.coc.rules.testing._
import com.rkss.rpg.coc.rules.testing.fakes._
import com.rkss.rpg.coc.concepts.EntityWithDifficultyValue

final class SkillRollResolverSpec
    extends AnyFunSpec
    with Matchers {
  describe("Resolving a skill roll") {
    val someCharacteristic = FakeCharacteristic(50)

    it should behave like resolveSkillRoll(
      someCharacteristic,
      Seq(48),
      SkillRolled(
        someCharacteristic,
        RegularDifficulty,
        BonusDice(0),
        PenaltyDice(0),
        RegularSuccess,
        SkillRollDiceResult(48)
      )
    )

    it should behave like resolveSkillRoll(
      someCharacteristic,
      Seq(60),
      SkillRolled(
        someCharacteristic,
        RegularDifficulty,
        BonusDice(0),
        PenaltyDice(0),
        Failure,
        SkillRollDiceResult(60)
      )
    )

    it should behave like resolveSkillRoll(
      someCharacteristic,
      Seq(100),
      SkillRolled(
        someCharacteristic,
        RegularDifficulty,
        BonusDice(0),
        PenaltyDice(0),
        Fumble,
        SkillRollDiceResult(100)
      )
    )

    it should behave like resolveSkillRoll(
      someCharacteristic,
      Seq(20),
      SkillRolled(
        someCharacteristic,
        RegularDifficulty,
        BonusDice(0),
        PenaltyDice(0),
        HardSuccess,
        SkillRollDiceResult(20)
      )
    )

    it should behave like resolveSkillRoll(
      someCharacteristic,
      Seq(6),
      SkillRolled(
        someCharacteristic,
        RegularDifficulty,
        BonusDice(0),
        PenaltyDice(0),
        ExtremeSuccess,
        SkillRollDiceResult(6)
      )
    )

    it should behave like resolveSkillRoll(
      someCharacteristic,
      Seq(1),
      SkillRolled(
        someCharacteristic,
        RegularDifficulty,
        BonusDice(0),
        PenaltyDice(0),
        CriticalSuccess,
        SkillRollDiceResult(1)
      )
    )

    it should behave like resolveSkillRoll(
      someCharacteristic,
      Seq(20),
      SkillRolled(
        someCharacteristic,
        HardDifficulty,
        BonusDice(0),
        PenaltyDice(0),
        RegularSuccess,
        SkillRollDiceResult(20)
      ),
      HardDifficulty
    )

    it should behave like resolveSkillRoll(
      someCharacteristic,
      Seq(6),
      SkillRolled(
        someCharacteristic,
        HardDifficulty,
        BonusDice(0),
        PenaltyDice(0),
        HardSuccess,
        SkillRollDiceResult(6)
      ),
      HardDifficulty
    )

    it should behave like resolveSkillRoll(
      someCharacteristic,
      Seq(6),
      SkillRolled(
        someCharacteristic,
        ExtremeDifficulty,
        BonusDice(0),
        PenaltyDice(0),
        RegularSuccess,
        SkillRollDiceResult(6)
      ),
      ExtremeDifficulty
    )

    it should behave like resolveSkillRoll(
      someCharacteristic,
      Seq(97),
      SkillRolled(
        someCharacteristic,
        RegularDifficulty,
        BonusDice(0),
        PenaltyDice(0),
        Failure,
        SkillRollDiceResult(97)
      ),
      RegularDifficulty
    )

    it should behave like resolveSkillRoll(
      someCharacteristic,
      Seq(97),
      SkillRolled(
        someCharacteristic,
        HardDifficulty,
        BonusDice(0),
        PenaltyDice(0),
        Fumble,
        SkillRollDiceResult(97)
      ),
      HardDifficulty
    )

    it should behave like resolveSkillRoll(
      someCharacteristic,
      Seq(48, 20),
      SkillRolled(
        someCharacteristic,
        RegularDifficulty,
        BonusDice(2),
        PenaltyDice(1),
        HardSuccess,
        SkillRollDiceResult(20, Seq(48))
      ),
      RegularDifficulty,
      BonusDice(2),
      PenaltyDice(1)
    )

    it should behave like resolveSkillRoll(
      someCharacteristic,
      Seq(48, 100),
      SkillRolled(
        someCharacteristic,
        RegularDifficulty,
        BonusDice(0),
        PenaltyDice(1),
        Fumble,
        SkillRollDiceResult(100, Seq(48))
      ),
      RegularDifficulty,
      BonusDice(0),
      PenaltyDice(1)
    )
  }

  private def resolveSkillRoll(
      rollable: EntityWithDifficultyValue,
      diceResults: Seq[Int],
      expected: SkillRolled,
      difficulty: SkillRollDifficultyLevel= RegularDifficulty,
      bonusDice: BonusDice = BonusDice(0),
      penaltyDice: PenaltyDice = PenaltyDice(0)
  ): Unit = {
    val rollStreak = diceResults.mkString(", ")

    implicit val mockedDice = HundredSidedDice(
      TestingProps.fakeRng(diceResults.toSeq)
    )

    val skillRollResolver =
      SkillRollResolver.instance

    describe(s"when difficulty is $difficulty") {
      describe(
        s"when tested skill / characteristic has regular value ${rollable.value(difficulty)}"
      ) {
        describe(s"when rolling $rollStreak") {
          it(s"should return ${expected}") {
            skillRollResolver.roll(
              rollable,
              difficulty,
              bonusDice,
              penaltyDice
            ) shouldBe expected
          }
        }
      }
    }
  }
}
