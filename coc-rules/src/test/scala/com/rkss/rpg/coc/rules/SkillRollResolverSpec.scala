package com.rkss.rpg.coc.rules

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.rkss.testing.props.TestingProps

import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.helpers.dice.HundredSidedDice
import com.rkss.rpg.coc.foundations.characteristics.Strength

class SkillRollResolverSpec extends AnyFunSpec with Matchers with BehaveLikeASkillRollResolver {
  describe("Resolving the skill roll") {
    val strength = Strength(50)

    it should behave like resolveSkillRoll(
      strength,
      Seq(48),
      RegularSuccess,
      RegularDifficulty
    )

    it should behave like resolveSkillRoll(
      strength,
      Seq(60),
      Failure,
      RegularDifficulty
    )

    it should behave like resolveSkillRoll(
      strength,
      Seq(100),
      Fumble,
      RegularDifficulty
    )

    it should behave like resolveSkillRoll(
      strength,
      Seq(20),
      HardSuccess,
      RegularDifficulty
    )

    it should behave like resolveSkillRoll(
      strength,
      Seq(6),
      ExtremeSuccess,
      RegularDifficulty
    )

    it should behave like resolveSkillRoll(
      strength,
      Seq(1),
      CriticalSuccess,
      RegularDifficulty
    )

    it should behave like resolveSkillRoll(
      strength,
      Seq(20),
      RegularSuccess,
      HardDifficulty
    )

    it should behave like resolveSkillRoll(
      strength,
      Seq(6),
      HardSuccess,
      HardDifficulty
    )

    it should behave like resolveSkillRoll(
      strength,
      Seq(6),
      RegularSuccess,
      ExtremeDifficulty
    )

    it should behave like resolveSkillRoll(
      strength,
      Seq(97),
      Failure,
      RegularDifficulty
    )

    it should behave like resolveSkillRoll(
      strength,
      Seq(97),
      Fumble,
      HardDifficulty
    )

    it should behave like resolveSkillRoll(
      strength,
      Seq(48, 20, 80),
      HardSuccess,
      RegularDifficulty,
      BonusDice(2),
      PenaltyDice(1)
    )

    it should behave like resolveSkillRoll(
      strength,
      Seq(48, 100),
      Fumble,
      RegularDifficulty,
      BonusDice(0),
      PenaltyDice(1)
    )
  }
}

trait BehaveLikeASkillRollResolver { this: AnyFunSpec with Matchers =>
  def resolveSkillRoll(
      rollable: SkillRollable,
      diceResults: Seq[Int],
      result: SkillRollResult,
      difficulty: SkillRollDifficultyLevel,
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
          it(s"should return $result") {
            skillRollResolver.roll(
              rollable,
              difficulty,
              bonusDice,
              penaltyDice
            ) shouldBe result
          }
        }
      }
    }
  }
}
