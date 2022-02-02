package com.rkss.rpg.coc.fundamentals.skills

import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.fundamentals.characteristics.Characteristic
import com.rkss.rpg.coc.concepts.characteristic.Dexterity
import com.rkss.rpg.coc.concepts.characteristic.Education

object SkillFactory {
  val basicSkills: Map[SimpleSkillName, SkillInfo] = Map(
    Accounting -> SkillInfo(5),
    AnimalHandling -> SkillInfo(5, Seq(UncommonSkill)),
    Anthropology -> SkillInfo(1),
    Appraise -> SkillInfo(5),
    Archaeology -> SkillInfo(1),
    Artillery -> SkillInfo(1, Seq(UncommonSkill)),
    Charm -> SkillInfo(15),
    Climb -> SkillInfo(20),
    ComputerUse -> SkillInfo(5, Seq(ModernSkill)),
    Demolitions -> SkillInfo(1, Seq(UncommonSkill)),
    Disguise -> SkillInfo(5),
    Diving -> SkillInfo(1, Seq(UncommonSkill)),
    DriveAuto -> SkillInfo(20),
    ElectricalRepair -> SkillInfo(10),
    Electronics -> SkillInfo(1, Seq(ModernSkill)),
    FastTalk -> SkillInfo(5),
    FirstAid -> SkillInfo(30),
    History -> SkillInfo(5),
    Hypnosis -> SkillInfo(1, Seq(UncommonSkill)),
    Intimidate -> SkillInfo(15),
    Jump -> SkillInfo(20),
    Law -> SkillInfo(5),
    LibraryUse -> SkillInfo(20),
    Listen -> SkillInfo(20),
    Locksmith -> SkillInfo(1),
    MechanicalRepair -> SkillInfo(10),
    Medicine -> SkillInfo(1),
    NaturalWorld -> SkillInfo(10),
    Navigate -> SkillInfo(10),
    Occult -> SkillInfo(5),
    OperateHeavyMachinery -> SkillInfo(1),
    Persuade -> SkillInfo(10),
    Psychoanalysis -> SkillInfo(1),
    Psychology -> SkillInfo(10),
    ReadLips -> SkillInfo(1, Seq(UncommonSkill)),
    Ride -> SkillInfo(5),
    SleightOfHand -> SkillInfo(10),
    SpotHidden -> SkillInfo(25),
    Stealth -> SkillInfo(20),
    Swim -> SkillInfo(20),
    Track -> SkillInfo(10),
    // Art and Craft
    Acting -> SkillInfo(5),
    FineArt -> SkillInfo(5),
    Forgery -> SkillInfo(5),
    Photography -> SkillInfo(5),
    // Lore
    DreamLore -> SkillInfo(1, Seq(UncommonSkill)),
    NecronomiconLore -> SkillInfo(1, Seq(UncommonSkill)),
    UFOLore -> SkillInfo(1, Seq(UncommonSkill)),
    VampireLore -> SkillInfo(1, Seq(UncommonSkill)),
    WerewolfLore -> SkillInfo(1, Seq(UncommonSkill)),
    YaddithianLore -> SkillInfo(1, Seq(UncommonSkill)),
    // Science
    Astronomy -> SkillInfo(1),
    Biology -> SkillInfo(1),
    Botany -> SkillInfo(1),
    Chemistry -> SkillInfo(1),
    Cryptography -> SkillInfo(1),
    Engineering -> SkillInfo(1),
    Forensics -> SkillInfo(1),
    Geology -> SkillInfo(1),
    Mathematics -> SkillInfo(1),
    Meteorology -> SkillInfo(1),
    Pharmacy -> SkillInfo(1),
    Physics -> SkillInfo(1),
    Zoology -> SkillInfo(1),
    // Survival
    Arctic -> SkillInfo(10),
    Desert -> SkillInfo(10),
    Sea -> SkillInfo(10)
  )

  val combatSkills: Map[CombatSkillName, SkillInfo] = Map(
    Throw -> SkillInfo(20),
    Axe -> SkillInfo(15),
    Brawl -> SkillInfo(25),
    Chainsaw -> SkillInfo(10),
    Flail -> SkillInfo(10),
    Garrote -> SkillInfo(15),
    Spear -> SkillInfo(20),
    Sword -> SkillInfo(20),
    Whip -> SkillInfo(5),
    Bow -> SkillInfo(15),
    Handgun -> SkillInfo(20),
    HeavyWeapons -> SkillInfo(10),
    Flamethrower -> SkillInfo(10),
    MachineGun -> SkillInfo(10),
    RifleAndShotgun -> SkillInfo(25),
    SubmachineGun -> SkillInfo(15)
  )

  def basicSkill[A <: SimpleSkillName](
      name: A,
      occupationPoints: Int,
      personalPoints: Int
  ): BasicSkill[A] = {
    val SkillInfo(baseValue, tags) = basicSkills(name)

    BasicSkill(name, baseValue, occupationPoints, personalPoints, tags)
  }

  def combatSkill[A <: CombatSkillName](
      name: A,
      occupationPoints: Int,
      personalPoints: Int
  ): CombatSkill[A] = {
    val SkillInfo(baseValue, tags) = combatSkills(name)

    CombatSkill(name, baseValue, occupationPoints, personalPoints, tags)
  }

  def dodgeSkill(
      dexterity: Characteristic[Dexterity.type],
      occupationPoints: Int,
      personalPoints: Int
  ): CombatSkill[Dodge.type] = {
    CombatSkill(Dodge, dexterity.value() / 2, occupationPoints, personalPoints)
  }

  def languageSkill[A <: LanguageSkillName](
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

  def languageSkill[A <: LanguageSkillName](
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
}
