package com.rkss.rpg.coc.foundations.skills

import com.rkss.rpg.coc.concepts.skill._

object SkillFactory {
  val basicSkills: Map[SimpleSkillName, Int] = Map(
    Accounting -> 5,
    AnimalHandling -> 5,
    Anthropology -> 1,
    Appraise -> 5,
    Archaeology -> 1,
    Artillery -> 1,
    Charm -> 15,
    Climb -> 20,
    ComputerUse -> 5,
    Demolitions -> 1,
    Disguise -> 5,
    Diving -> 1,
    DriveAuto -> 20,
    ElectricalRepair -> 10,
    Electronics -> 1,
    FastTalk -> 5,
    FirstAid -> 30,
    History -> 5,
    Hypnosis -> 1,
    Intimidate -> 15,
    Jump -> 20,
    Law -> 5,
    LibraryUse -> 20,
    Listen -> 20,
    Locksmith -> 1,
    MechanicalRepair -> 10,
    Medicine -> 1,
    NaturalWorld -> 10,
    Navigate -> 10,
    Occult -> 5,
    OperateHeavyMachinery -> 1,
    Persuade -> 10,
    Psychoanalysis -> 1,
    Psychology -> 10,
    ReadLips -> 1,
    Ride -> 5,
    SleightOfHand -> 10,
    SpotHidden -> 25,
    Stealth -> 20,
    Swim -> 20,
    Track -> 10,
    // Art and Craft
    Acting -> 5,
    FineArt -> 5,
    Forgery -> 5,
    Photography -> 5,
    // Lore
    DreamLore -> 1,
    NecronomiconLore -> 1,
    UFOLore -> 1,
    VampireLore -> 1,
    WerewolfLore -> 1,
    YaddithianLore -> 1,
    // Science
    Astronomy -> 1,
    Biology -> 1,
    Botany -> 1,
    Chemistry -> 1,
    Cryptography -> 1,
    Engineering -> 1,
    Forensics -> 1,
    Geology -> 1,
    Mathematics -> 1,
    Meteorology -> 1,
    Pharmacy -> 1,
    Physics -> 1,
    Zoology -> 1,
    // Survival
    Arctic -> 10,
    Desert -> 10,
    Sea -> 10
  )

  val combatSkills: Map[CombatSkillName, Int] = Map(
    Throw -> 20,
    Axe -> 15,
    Brawl -> 25,
    Chainsaw -> 10,
    Flail -> 10,
    Garrote -> 15,
    Spear -> 20,
    Sword -> 20,
    Whip -> 5,
    Bow -> 15,
    Handgun -> 20,
    HeavyWeapons -> 10,
    Flamethrower -> 10,
    MachineGun -> 10,
    RifleAndShotgun -> 25,
    SubmachineGun -> 15
  )

  def basicSkill[A <: SimpleSkillName](
      name: A,
      occupationPoints: Int,
      personalPoints: Int
  ): BasicSkill = {
    val baseValue = basicSkills(name)

    new BasicSkill(name, baseValue, occupationPoints, personalPoints)
  }

  def combatSkill[A <: CombatSkillName](
      name: A,
      occupationPoints: Int,
      personalPoints: Int
  ): CombatSkill = {
    val baseValue = combatSkills(name)

    new CombatSkill(name, baseValue, occupationPoints, personalPoints)
  }
}
