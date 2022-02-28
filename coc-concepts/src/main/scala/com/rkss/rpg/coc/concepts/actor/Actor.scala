package com.rkss.rpg.coc.concepts.actor

import com.rkss.rpg.coc.concepts.characteristic._
import com.rkss.rpg.coc.concepts.attributes._
import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.concepts.attributes.sanity._
import com.rkss.rpg.coc.concepts.skill.roll._

trait Actor {
  def nature: ActorNature

  def defense: SkillRollCheckable[SkillRollNaming]

  def attacks: Seq[SkillRollCheckable[SkillRollNaming]]

  def characteristic[A <: CharacteristicName](
      name: A
  ): Option[Characteristic[A]]

  def skills[A <: SkillName](name: A): Option[Skill[SkillName]]

  def sanity: Option[Sanity]
  def damageBonus: Option[DamageBonus]
  def build: Option[Build]
  def hitPoints: Option[HitPoints]
  def magicPoints: Option[MagicPoints]

  def sanityLoss: Option[Either[
    AttributeValueLoss[SanityAttribute.type],
    AttributeValueLoss[SanityAttribute.type]
  ]]

  def movementRate: Int

  // TODO: Armor
  // TODO: Spells
}
