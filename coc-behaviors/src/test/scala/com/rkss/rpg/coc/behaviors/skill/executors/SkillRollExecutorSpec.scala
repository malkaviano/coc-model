package com.rkss.rpg.coc.behaviors.skill

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.helpers.dice.HundredSidedDice
import com.rkss.rpg.coc.behaviors.testing._
import com.rkss.rpg.coc.behaviors.testing.fakes._
import com.rkss.rpg.coc.concepts._
import com.rkss.rpg.coc.concepts.characteristic._
import com.rkss.rpg.coc.behaviors.skill.executors._

final class SkillRollExecutorSpec
    extends AnyFunSpec
    with Matchers {
  describe("Resolving a skill roll") {
    val someCharacteristic = FakeGenericCharacteristic(Education, 50)

    it should behave like resolveSkillRoll(
      someCharacteristic,
      Seq(48),
      SkillRolled(
        Education,
        someCharacteristic.value(),
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
        Education,
        someCharacteristic.value(),
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
        Education,
        someCharacteristic.value(),
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
        Education,
        someCharacteristic.value(),
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
        Education,
        someCharacteristic.value(),
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
        Education,
        someCharacteristic.value(),
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
        Education,
        someCharacteristic.value(HardDifficulty),
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
        Education,
        someCharacteristic.value(HardDifficulty),
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
        Education,
        someCharacteristic.value(ExtremeDifficulty),
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
        Education,
        someCharacteristic.value(),
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
        Education,
        someCharacteristic.value(HardDifficulty),
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
        Education,
        someCharacteristic.value(),
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
        Education,
        someCharacteristic.value(),
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

  private def resolveSkillRoll[A <: NameTag](
      rollable: EntityWithDifficultyValue with EntityWithNameTag[A],
      diceResults: Seq[Int],
      expected: SkillRolled[A],
      difficulty: SkillRollDifficultyLevel= RegularDifficulty,
      bonusDice: BonusDice = BonusDice(0),
      penaltyDice: PenaltyDice = PenaltyDice(0)
  ): Unit = {
    val rollStreak = diceResults.mkString(", ")

    implicit val mockedDice = HundredSidedDice(
      TestingProps.fakeRng(diceResults.toSeq)
    )

    val skillRollResolver =
      SkillRollExecutor.instance

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
