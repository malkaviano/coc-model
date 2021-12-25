package com.rkss.rpg.coc.rules

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.helpers.dice.HundredSidedDice
import com.rkss.rpg.coc.props._
import com.rkss.rpg.coc.props.fakes._

class SkillRollResolverSpec
    extends AnyFunSpec
    with Matchers
    with BehaveLikeASkillRollResolver {
  describe("Resolving the skill roll") {
    val someCharacteristic = FakeCharacteristic(50, 25, 10)

    it should behave like resolveSkillRoll(
      someCharacteristic,
      Seq(48),
      SkillRolled(
        someCharacteristic,
        RegularDifficulty,
        BonusDice(0),
        PenaltyDice(0),
        RegularSuccess,
        FakeDiceResult(48)
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
        FakeDiceResult(60)
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
        FakeDiceResult(100)
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
        FakeDiceResult(20)
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
        FakeDiceResult(6)
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
        FakeDiceResult(1)
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
        FakeDiceResult(20)
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
        FakeDiceResult(6)
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
        FakeDiceResult(6)
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
        FakeDiceResult(97)
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
        FakeDiceResult(97)
      ),
      HardDifficulty
    )

    it should behave like resolveSkillRoll(
      someCharacteristic,
      Seq(48, 20, 80),
      SkillRolled(
        someCharacteristic,
        RegularDifficulty,
        BonusDice(2),
        PenaltyDice(1),
        HardSuccess,
        FakeDiceResult(20)
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
        FakeDiceResult(100)
      ),
      RegularDifficulty,
      BonusDice(0),
      PenaltyDice(1)
    )
  }
}

trait BehaveLikeASkillRollResolver { self: AnyFunSpec with Matchers =>
  def resolveSkillRoll(
      rollable: SkillRollable,
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
