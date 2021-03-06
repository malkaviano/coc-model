package com.rkss.rpg.coc.concepts.skill

sealed trait SkillTag

case object UncommonSkill extends SkillTag
case object ModernSkill extends SkillTag

sealed trait LanguageTag extends SkillTag

case object LanguageOwn extends LanguageTag
case object LanguageOther extends LanguageTag