package com.rkss.rpg.coc.foundations.actors

import com.rkss.rpg.coc.concepts.actor._
import com.rkss.rpg.coc.concepts.characteristic._
import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.concepts.attributes.sanity._
import com.rkss.rpg.coc.concepts.attributes._
import com.rkss.rpg.coc.concepts.skill.roll._

final case class ActorSpecification(
    val nature: ActorNature,
    val definedCharacteristics: Set[CharacteristicName],
    val undefinedCharacteristics: Set[CharacteristicName],
    val skills: Set[SkillName],
    val sanity: Option[Sanity],
    val damageBonus: Option[Int],
    val build: Option[Int],
    val hitPoints: Option[Int],
    val magicPoints: Option[Int],
    val sanityLoss: Option[Either[
      AttributeValueLoss[SanityAttribute.type],
      AttributeValueLoss[SanityAttribute.type]
    ]],
    val movementRate: Int,
    val attacks: Seq[SkillRollNaming],
    val defense: SkillRollNaming
)
