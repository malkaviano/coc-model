package com.rkss.rpg.coc.foundations.actors

import com.rkss.rpg.coc.concepts.actor._
import com.rkss.rpg.coc.helpers.factories._
import com.rkss.rpg.coc.concepts.characteristic._
import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.helpers.dice._
import com.rkss.rpg.coc.behaviors.testing._

final class BeastActorSpec extends ActorBehavior {
  implicit val sixSidedDice = SixSidedDice(TestingProps.fakeRng(Seq(5)))
  implicit val fourSidedDice = FourSidedDice(TestingProps.fakeRng(Seq(3)))

  describe("Beast actor") {
    val strength = CharacteristicFactory.characteristic(Strength, 100)
    val constitution = CharacteristicFactory.characteristic(Constitution, 100)
    val size = CharacteristicFactory.characteristic(Size, 100)
    val dexterity = CharacteristicFactory.characteristic(Dexterity, 100)
    val power = CharacteristicFactory.characteristic(Power, 100)

    val defense = SkillFactory
      .dodgeSkill(dexterity, 0, 0)

    val attacks = Seq(
      SkillFactory
        .combatSkill(Brawl, 0, 0)
    )

    val skills: Map[SkillName, Skill[SkillName]] =
      Map(
        SpotHidden -> SkillFactory
          .basicSkill(SpotHidden, 0, 0)
      )

    val mov = 8

    val spec = ActorSpecification(
      BeastActorNature,
      Set(Strength, Constitution, Size, Dexterity, Power),
      Set(Appearance, Intelligence, Education),
      Set(SpotHidden),
      None,
      Some(5),
      Some(2),
      Some(20),
      None,
      None,
      mov,
      Seq(Brawl),
      Dodge
    )

    it should behave like actorBehaviors(
      BeastActor(
        strength,
        constitution,
        size,
        dexterity,
        power,
        defense,
        skills,
        attacks,
        mov
      ),
      spec
    )
  }
}
