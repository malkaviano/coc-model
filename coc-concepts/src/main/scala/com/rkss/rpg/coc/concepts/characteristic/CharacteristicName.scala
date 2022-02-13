package com.rkss.rpg.coc.concepts.characteristic

import com.rkss.rpg.coc.concepts.skill.roll._

sealed trait CharacteristicName extends SkillRollNaming

sealed trait ImprovableCharacteristicName extends CharacteristicName

case object Strength extends CharacteristicName
case object Dexterity extends CharacteristicName
case object Constitution extends CharacteristicName
case object Size extends CharacteristicName
case object Appearance extends CharacteristicName
case object Education extends CharacteristicName
case object Intelligence extends CharacteristicName
case object Power extends ImprovableCharacteristicName
