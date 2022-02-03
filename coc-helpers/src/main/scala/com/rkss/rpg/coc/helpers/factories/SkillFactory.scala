package com.rkss.rpg.coc.helpers.factories

import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.concepts.characteristic._
import com.rkss.rpg.coc.fundamentals.skills._
import com.rkss.rpg.coc.helpers.wrappers._

object SkillFactory {
  def basicSkill[A <: SimpleSkillName](
      name: A,
      occupationPoints: Int,
      personalPoints: Int
  ): BasicSkill[A] = {
    val SkillInfo(baseValue, tags) = SkillInfo.basicSkills(name)

    BasicSkill(name, baseValue, occupationPoints, personalPoints, tags)
  }

  def combatSkill[A <: CombatSkillName](
      name: A,
      occupationPoints: Int,
      personalPoints: Int
  ): CombatSkill[A] = {
    val SkillInfo(baseValue, tags) = SkillInfo.combatSkills(name)

    CombatSkill(name, baseValue, occupationPoints, personalPoints, tags)
  }

  def dodgeSkill(
      dexterity: Characteristic[Dexterity.type],
      occupationPoints: Int,
      personalPoints: Int
  ): CombatSkill[Dodge.type] = {
    CombatSkill(Dodge, dexterity.value() / 2, occupationPoints, personalPoints)
  }

  def languageOtherSkill[A <: LanguageSkillName](
      language: A,
      occupationPoints: Int,
      personalPoints: Int
  ): BasicSkill[A] = {
    BasicSkill(
      language,
      1,
      occupationPoints,
      personalPoints,
      Seq(LanguageOther)
    )
  }

  def languageOwnSkill[A <: LanguageSkillName](
      education: Characteristic[Education.type],
      language: A,
      occupationPoints: Int,
      personalPoints: Int
  ): BasicSkill[A] = {
    BasicSkill(
      language,
      education.value(),
      occupationPoints,
      personalPoints,
      Seq(LanguageOwn)
    )
  }

  def cthulhuMythosSkill: CthulhuMythosSkill = {
    CthulhuMythosSkill()
  }
}
