package com.rkss.rpg.coc.concepts

sealed trait Identification

case object CharacteristicStrength extends Identification
case object SkillFirstAid extends Identification
case object SkillCreditRating extends Identification
case object SkillAccounting extends Identification
