package com.malk.coc.traits

import com.malk.coc.traits.Characteristic

sealed trait CanPushSkill {
  def canPush: Boolean
}

sealed trait BaseValueSkill {
  def base: Int
}

abstract class Skill(spent: Int) extends BaseValueSkill with CanPushSkill {
  def name: String
  def value: Int = base + spent
}

abstract class CharacteristicSkill[A <: Characteristic](spent: Int) extends Skill(spent)

abstract class GenericSkill(spent: Int) extends Skill(spent)

// Skill tags (optional)
trait ModernEraSkill

trait UncommonSkill

// Behavior specializations (optional)
trait WithoutBaseValueSkill extends BaseValueSkill {
  override val base: Int = 0
}

trait PushableSkill extends CanPushSkill {
  override val canPush: Boolean = true
}

trait NotPushableSkill extends CanPushSkill {
  override val canPush: Boolean = false
}
