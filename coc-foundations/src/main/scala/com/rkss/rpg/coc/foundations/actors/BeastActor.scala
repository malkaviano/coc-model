package com.rkss.rpg.coc.foundations.actors

import com.rkss.rpg.coc.concepts.characteristic._
import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.concepts.actor._
import com.rkss.rpg.coc.concepts.attributes.sanity._
import com.rkss.rpg.coc.concepts.attributes._
import com.rkss.rpg.coc.fundamentals.attributes._
import com.rkss.rpg.helpers.dice._

import com.rkss.rpg.coc.concepts.skill.roll.{
  SkillRollCheckable,
  SkillRollNaming
}

final case class BeastActor(
    private val strength: Characteristic[Strength.type],
    private val constitution: Characteristic[Constitution.type],
    private val size: Characteristic[Size.type],
    private val dexterity: Characteristic[Dexterity.type],
    private val power: Characteristic[Power.type],
    private val dodge: BasicSkill[Dodge.type],
    private val beastSkills: Map[SkillName, Skill[SkillName]],
    override val attacks: Seq[SkillRollCheckable[SkillRollNaming]],
    override val movementRate: Int
)(implicit val fourSidedDice: FourSidedDice, val sixSidedDice: SixSidedDice)
    extends Actor {

  override def skills[A <: SkillName](name: A): Option[Skill[SkillName]] = {
    beastSkills.get(name)
  }

  override val defense: SkillRollCheckable[SkillRollNaming] = dodge

  override val nature: ActorNature = BeastActorNature

  override val sanity: Option[Sanity] = None

  override val magicPoints: Option[MagicPoints] = None

  override val sanityLoss: Option[Either[AttributeValueLoss[
    SanityAttribute.type
  ], AttributeValueLoss[SanityAttribute.type]]] = None

  override def characteristic[A <: CharacteristicName](
      name: A
  ): Option[Characteristic[A]] = {
    name match {
      case Strength     => Some(strength)
      case Dexterity    => Some(dexterity)
      case Size         => Some(size)
      case Constitution => Some(constitution)
      case Power        => Some(power)
      case _            => None
    }
  }

  override def damageBonus: Option[DamageBonus] = {
    Some(DamageBonusImpl(strength, size))
  }

  override def build: Option[Build] = {
    Some(BuildImpl(strength, size))
  }

  override def hitPoints: Option[HitPoints] = {
    val size =
      characteristic(Size).get

    val constitution =
      characteristic(Constitution).get

    Some(HitPointsImpl(size, constitution))
  }

}
