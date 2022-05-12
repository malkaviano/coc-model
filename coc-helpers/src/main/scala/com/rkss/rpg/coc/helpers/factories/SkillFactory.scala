package com.rkss.rpg.coc.helpers.factories

import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.concepts.characteristic._
import com.rkss.rpg.coc.fundamentals.skills._
import com.rkss.rpg.coc.helpers.wrappers._
import com.rkss.rpg.coc.fundamentals.characteristics.Characteristic

object SkillFactory {
  def basicSkill[A <: SimpleSkillName](
      name: A,
      occupationPoints: Int,
      personalPoints: Int
  ): BasicSkill[A] = {
    val SkillInfo(baseValue, tags) = SkillInfo.basicSkills(name)

    SkillImpl(name, baseValue, occupationPoints, personalPoints, tags)
  }

  def combatSkill[A <: AttackSkillName](
      name: A,
      occupationPoints: Int,
      personalPoints: Int
  ): BasicSkill[A] = {
    val SkillInfo(baseValue, tags) = SkillInfo.combatSkills(name)

    SkillImpl(name, baseValue, occupationPoints, personalPoints, tags)
  }

  def dodgeSkill(
      dexterity: Characteristic[Dexterity.type],
      occupationPoints: Int,
      personalPoints: Int
  ): BasicSkill[Dodge.type] = {
    SkillImpl(Dodge, dexterity.value() / 2, occupationPoints, personalPoints)
  }

  def languageOtherSkill[A <: LanguageSkillName](
      language: A,
      occupationPoints: Int,
      personalPoints: Int
  ): BasicSkill[A] = {
    SkillImpl(
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
    SkillImpl(
      language,
      education.value(),
      occupationPoints,
      personalPoints,
      Seq(LanguageOwn)
    )
  }

  def cthulhuMythosSkill: SystemSkill[CthulhuMythos.type] = {
    CthulhuMythosSkillImpl()
  }

  def creditRatingSkill(
      baseValue: Int,
      occupationPoints: Int,
      personalPoints: Int
  ): SystemSkill[CreditRating.type] = {
    CreditRatingSkillImpl(baseValue, occupationPoints, personalPoints)
  }
}
