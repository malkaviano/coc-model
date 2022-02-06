package com.rkss.rpg.coc.concepts.skill

import com.rkss.rpg.coc.concepts.commons._

sealed trait SkillName extends Naming

case object CreditRating extends SkillName
case object CthulhuMythos extends SkillName

sealed trait ImprovableSkillName extends SkillName

sealed trait SimpleSkillName extends ImprovableSkillName

case object Accounting extends SimpleSkillName
case object AnimalHandling extends SimpleSkillName
case object Anthropology extends SimpleSkillName
case object Appraise extends SimpleSkillName
case object Archaeology extends SimpleSkillName
case object Artillery extends SimpleSkillName
case object Charm extends SimpleSkillName
case object Climb extends SimpleSkillName
case object ComputerUse extends SimpleSkillName
case object Demolitions extends SimpleSkillName
case object Disguise extends SimpleSkillName
case object Diving extends SimpleSkillName
case object DriveAuto extends SimpleSkillName
case object ElectricalRepair extends SimpleSkillName
case object Electronics extends SimpleSkillName
case object FastTalk extends SimpleSkillName
case object FirstAid extends SimpleSkillName
case object History extends SimpleSkillName
case object Hypnosis extends SimpleSkillName
case object Intimidate extends SimpleSkillName
case object Jump extends SimpleSkillName
case object Law extends SimpleSkillName
case object LibraryUse extends SimpleSkillName
case object Listen extends SimpleSkillName
case object Locksmith extends SimpleSkillName
case object MechanicalRepair extends SimpleSkillName
case object Medicine extends SimpleSkillName
case object NaturalWorld extends SimpleSkillName
case object Navigate extends SimpleSkillName
case object Occult extends SimpleSkillName
case object OperateHeavyMachinery extends SimpleSkillName
case object Persuade extends SimpleSkillName
case object Psychoanalysis extends SimpleSkillName
case object Psychology extends SimpleSkillName
case object ReadLips extends SimpleSkillName
case object Ride extends SimpleSkillName
case object SleightOfHand extends SimpleSkillName
case object SpotHidden extends SimpleSkillName
case object Stealth extends SimpleSkillName
case object Swim extends SimpleSkillName
case object Track extends SimpleSkillName

sealed trait ArtAndCraft extends SimpleSkillName

case object Acting extends ArtAndCraft
case object FineArt extends ArtAndCraft
case object Forgery extends ArtAndCraft
case object Photography extends ArtAndCraft

sealed trait Lore extends SimpleSkillName

case object DreamLore extends Lore
case object NecronomiconLore extends Lore
case object UFOLore extends Lore
case object VampireLore extends Lore
case object WerewolfLore extends Lore
case object YaddithianLore extends Lore

sealed trait Science extends SimpleSkillName

case object Astronomy extends Science
case object Biology extends Science
case object Botany extends Science
case object Chemistry extends Science
case object Cryptography extends Science
case object Engineering extends Science
case object Forensics extends Science
case object Geology extends Science
case object Mathematics extends Science
case object Meteorology extends Science
case object Pharmacy extends Science
case object Physics extends Science
case object Zoology extends Science

sealed trait Survival extends SimpleSkillName

case object Arctic extends Survival
case object Desert extends Survival
case object Sea extends Survival

sealed trait CombatSkillName extends ImprovableSkillName

sealed trait AttackSkillName extends CombatSkillName

case object Throw extends AttackSkillName

sealed trait Fighting extends AttackSkillName

case object Axe extends Fighting
case object Brawl extends Fighting
case object Chainsaw extends Fighting
case object Flail extends Fighting
case object Garrote extends Fighting
case object Spear extends Fighting
case object Sword extends Fighting
case object Whip extends Fighting

sealed trait Firearms extends AttackSkillName

case object Bow extends Firearms
case object Handgun extends Firearms
case object HeavyWeapons extends Firearms
case object Flamethrower extends Firearms
case object MachineGun extends Firearms
case object RifleAndShotgun extends Firearms
case object SubmachineGun extends Firearms

sealed trait DefenseSkillName extends CombatSkillName

case object Dodge extends DefenseSkillName

sealed trait LanguageSkillName extends ImprovableSkillName

case object ArabicLanguage extends LanguageSkillName
case object ChineseLanguage extends LanguageSkillName
case object EnglishLanguage extends LanguageSkillName
case object FrenchLanguage extends LanguageSkillName
case object GermanLanguage extends LanguageSkillName
case object ItalianLanguage extends LanguageSkillName
case object JapaneseLanguage extends LanguageSkillName
case object LatinLanguage extends LanguageSkillName
case object PortugueseLanguage extends LanguageSkillName
case object RussianLanguage extends LanguageSkillName
case object SpanishLanguage extends LanguageSkillName