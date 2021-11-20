package com.malk.coc.traits

import com.malk.coc.traits.Characteristic

sealed trait CanPushSkill {
  def canPush: Boolean
}

sealed trait BaseValueSkill {
  def base: Int
}

abstract class Skill extends BaseValueSkill with CanPushSkill {
  private var spent: Int = 0

  def name: String

  def value: Int = base + spent

  def spend(points: Int): Unit = {
    spent += points
  }

  override def toString(): String = {
    s"${name} with base: ${base} and value: ${value}"
  }

  override def hashCode(): Int = {
    name.hashCode * 42
  }

  override def equals(x: Any): Boolean = {
    if (x.isInstanceOf[Skill]) {
      val skill = x.asInstanceOf[Skill]

      this.name == skill.name
    } else {
      false
    }
  }
}

abstract class CharacteristicSkill[A <: Characteristic] extends Skill

abstract class GenericSkill extends Skill

// Skill tags (optional)
trait ModernEraSkill

trait UncommonSkill

trait InterpersonalSkill

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
