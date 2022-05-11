package com.rkss.rpg.coc.concepts.characteristic

import com.rkss.rpg.coc.concepts.roll._

sealed trait CharacteristicName extends SkillRollNaming

sealed trait ImprovableCharacteristicName extends CharacteristicName

sealed trait PhysicalCharacteristicName extends CharacteristicName

case object Strength extends PhysicalCharacteristicName
case object Dexterity extends PhysicalCharacteristicName
case object Size extends PhysicalCharacteristicName
case object Constitution extends CharacteristicName
case object Appearance extends CharacteristicName
case object Education extends CharacteristicName
case object Intelligence extends CharacteristicName
case object Power extends ImprovableCharacteristicName
