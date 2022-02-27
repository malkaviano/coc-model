package com.rkss.rpg.coc.foundations.actions

import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.GivenWhenThen
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.coc.helpers.factories._
import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.concepts.characteristic._
import com.rkss.rpg.coc.foundations.results._
import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.concepts.results._

final class OpposedSkillRollCheckFeature
    extends AnyFeatureSpec
    with GivenWhenThen
    with Matchers
    with OpposedSkillRollCheckScenario {

  info("I want to execute an action against another player")
  info("Or I want to execute a combat action")
  info("The defender decides to resist")
  info("The keeper decides the bonus and penalty dice for the attacker")
  info("The keeper decides the bonus and penalty dice for the defender")
  info("The attacker makes a skill roll to check the level of success")
  info("The defender makes a skill roll to check the level of success")
  info(
    "The level of success is compared and a decision is taken"
  )
  info("The side that succeeded marks ticks the skill used")

  Seq(
    OpposedSkillRollCheckSpecification(
      SkillFactory.combatSkill(Chainsaw, 10, 5),
      SkillFactory.dodgeSkill(
        CharacteristicFactory.characteristic(Dexterity, 50),
        0,
        0
      ),
      Seq(10, 15),
      Seq(20),
      OpposedSkillRollChecked(
        SkillRollChecked(
          true,
          SkillRolled(
            Chainsaw,
            25,
            RegularDifficulty,
            BonusDice(1),
            PenaltyDice(0),
            SkillRollHardSuccess,
            SkillRollDiceResult(10, Seq(15))
          )
        ),
        SkillRollChecked(
          false,
          SkillRolled(
            Dodge,
            25,
            RegularDifficulty,
            BonusDice(0),
            PenaltyDice(0),
            SkillRollRegularSuccess,
            SkillRollDiceResult(20)
          )
        )
      ),
      false,
      false
    ),
    OpposedSkillRollCheckSpecification(
      SkillFactory.combatSkill(Sword, 10, 5),
      SkillFactory.dodgeSkill(
        CharacteristicFactory.characteristic(Dexterity, 50),
        0,
        0
      ),
      Seq(30, 20),
      Seq(20),
      OpposedSkillRollChecked(
        SkillRollChecked(
          false,
          SkillRolled(
            Sword,
            35,
            RegularDifficulty,
            BonusDice(0),
            PenaltyDice(1),
            SkillRollRegularSuccess,
            SkillRollDiceResult(30, Seq(20))
          )
        ),
        SkillRollChecked(
          true,
          SkillRolled(
            Dodge,
            25,
            RegularDifficulty,
            BonusDice(0),
            PenaltyDice(0),
            SkillRollRegularSuccess,
            SkillRollDiceResult(20)
          )
        )
      ),
      false,
      true
    ),
    OpposedSkillRollCheckSpecification(
      SkillFactory.combatSkill(Brawl, 10, 5),
      SkillFactory.dodgeSkill(
        CharacteristicFactory.characteristic(Dexterity, 50),
        0,
        0
      ),
      Seq(30, 98),
      Seq(70),
      OpposedSkillRollChecked(
        SkillRollChecked(
          false,
          SkillRolled(
            Brawl,
            40,
            RegularDifficulty,
            BonusDice(0),
            PenaltyDice(1),
            SkillRollFumble,
            SkillRollDiceResult(98, Seq(30))
          )
        ),
        SkillRollChecked(
          false,
          SkillRolled(
            Dodge,
            25,
            RegularDifficulty,
            BonusDice(0),
            PenaltyDice(0),
            SkillRollFailure,
            SkillRollDiceResult(70)
          )
        )
      ),
      false,
      false
    ),
    OpposedSkillRollCheckSpecification(
      SkillFactory.combatSkill(Sword, 10, 5),
      SkillFactory.combatSkill(Brawl, 10, 5),
      Seq(15),
      Seq(20),
      OpposedSkillRollChecked(
        SkillRollChecked(
          true,
          SkillRolled(
            Sword,
            35,
            RegularDifficulty,
            BonusDice(0),
            PenaltyDice(0),
            SkillRollHardSuccess,
            SkillRollDiceResult(15)
          )
        ),
        SkillRollChecked(
          false,
          SkillRolled(
            Brawl,
            40,
            RegularDifficulty,
            BonusDice(0),
            PenaltyDice(0),
            SkillRollHardSuccess,
            SkillRollDiceResult(20)
          )
        )
      ),
      true,
      false
    ),
    OpposedSkillRollCheckSpecification(
      SkillFactory.basicSkill(Charm, 10, 5),
      SkillFactory.languageOtherSkill(SpanishLanguage, 14, 10),
      Seq(20),
      Seq(20),
      OpposedSkillRollChecked(
        SkillRollChecked(
          true,
          SkillRolled(
            Charm,
            30,
            RegularDifficulty,
            BonusDice(0),
            PenaltyDice(0),
            SkillRollRegularSuccess,
            SkillRollDiceResult(20)
          )
        ),
        SkillRollChecked(
          false,
          SkillRolled(
            SpanishLanguage,
            25,
            RegularDifficulty,
            BonusDice(0),
            PenaltyDice(0),
            SkillRollRegularSuccess,
            SkillRollDiceResult(20)
          )
        )
      ),
      true,
      false
    ),
    OpposedSkillRollCheckSpecification(
      SkillFactory.languageOtherSkill(EnglishLanguage, 14, 10),
      SkillFactory.languageOtherSkill(EnglishLanguage, 14, 10),
      /*
        Cheating to not change the spec.
        First seq is being used to represent the first rolls
        TIE -> Both succeed, same skill values -> recursion
        second seq is being used to represent the second rolls.
       */
      Seq(20, 15),
      Seq(25, 45),
      OpposedSkillRollChecked(
        SkillRollChecked(
          true,
          SkillRolled(
            EnglishLanguage,
            25,
            RegularDifficulty,
            BonusDice(0),
            PenaltyDice(0),
            SkillRollRegularSuccess,
            SkillRollDiceResult(25)
          )
        ),
        SkillRollChecked(
          false,
          SkillRolled(
            EnglishLanguage,
            25,
            RegularDifficulty,
            BonusDice(0),
            PenaltyDice(0),
            SkillRollFailure,
            SkillRollDiceResult(45)
          )
        )
      ),
      true,
      false
    )
  ).foreach(spec => ScenariosFor(makingAnOpposedSkillRollCheck(spec)))
}
