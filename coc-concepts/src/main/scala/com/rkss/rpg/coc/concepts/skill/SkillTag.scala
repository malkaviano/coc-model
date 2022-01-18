package com.rkss.rpg.coc.concepts.skill

sealed trait SkillTag

case object UncommonSkill extends SkillTag
case object ModernSkill extends SkillTag
case object FightingSkill extends SkillTag
case object FirearmSkill extends SkillTag