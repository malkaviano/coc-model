package com.malk.coc.helpers

import scala.util.Random

import com.malk.coc.concepts.skills._
import com.malk.coc.concepts.skills.languages.own._
import com.malk.coc.concepts.occupations.InvestigatorSkillPoints
import com.malk.coc.concepts.characteristics._
import com.malk.coc.traits._
import com.malk.coc.concepts.skills.languages.other.LanguageOther
import com.malk.coc.concepts.skills.languages.other.ArabicLanguageOther

object SkillHelper {
  def allSkills: Set[Skill] = Set(
    Accounting(),
    Acting(),
    AnimalHandling(),
    Anthropology(),
    Appraise(),
    Archaeology(),
    Arctic(),
    Artillery(),
    Astronomy(),
    Axe(),
    Biology(),
    Botany(),
    Bow(),
    Brawl(),
    Chainsaw(),
    Charm(),
    Chemistry(),
    Climb(),
    ComputerUse(),
    CreditRating(),
    Cryptography(),
    CthulhuMythos(),
    Demolitions(),
    Desert(),
    Disguise(),
    Diving(),
    Dodge(Dexterity(0))(),
    DriveAuto(),
    ElectricalRepair(),
    Electronics(),
    Engineering(),
    FastTalk(),
    FineArt(),
    FirstAid(),
    Flail(),
    Flamethrower(),
    Forensics(),
    Forgery(),
    Garrote(),
    Geology(),
    Handgun(),
    HeavyWeapons(),
    History(),
    Hypnosis(),
    Intimidate(),
    Jump(),
    LanguageOwn(Education(0))(),
    Law(),
    LibraryUse(),
    Listen(),
    Locksmith(),
    MachineGun(),
    Mathematics(),
    MechanicalRepair(),
    Medicine(),
    Meteorology(),
    NaturalWorld(),
    Navigate(),
    Occult(),
    OperateHeavyMachinery(),
    Persuade(),
    Pharmacy(),
    Photography(),
    Physics(),
    Psychoanalysis(),
    Psychology(),
    ReadLips(),
    Ride(),
    RifleAndShotgun(),
    Sea(),
    SleightOfHand(),
    Spear(),
    SpotHidden(),
    Stealth(),
    SubmachineGun(),
    Swim(),
    Sword(),
    Throw(),
    Track(),
    Whip(),
    WildernessTerrain(),
    Zoology(),
    ArabicLanguageOther()
  )

  def fightingSkills: Set[Skill] = {
    allSkills.filter(_.isInstanceOf[Fighting])
  }

  def firearmsSkills: Set[Skill] = {
    allSkills.filter(_.isInstanceOf[Firearm])
  }

  def uncommonSkills: Set[Skill] = {
    allSkills.filter(_.isInstanceOf[UncommonSkill]).toSet
  }

  def modernSkills: Set[Skill] = {
    allSkills.filter(_.isInstanceOf[ModernEraSkill]).toSet
  }

  def characteristicSkills: Set[Skill] = {
    allSkills.filter(_.isInstanceOf[CharacteristicSkill[_]]).toSet
  }

  def filteredSkills(exclude: Set[Skill]): Set[Skill] = {
    allSkills -- exclude
  }

  def interpersonalSkills: Set[Skill] = {
    allSkills.filter(_.isInstanceOf[InterpersonalSkill]).toSet
  }

  def survivalSkills: Set[Skill] = {
    allSkills.filter(_.isInstanceOf[Survival]).toSet
  }

  def pilotSkills: Set[Skill] = {
    allSkills.filter(_.isInstanceOf[Pilot]).toSet
  }

  def loreSkills: Set[Skill] = {
    allSkills.filter(_.isInstanceOf[Lore]).toSet
  }

  def languageOtherSkills: Set[Skill] = {
    allSkills.filter(_.isInstanceOf[LanguageOther]).toSet
  }

  def scienceSkills: Set[Skill] = {
    allSkills.filter(_.isInstanceOf[Science]).toSet
  }

  def artAndCraftSkills: Set[Skill] = {
    allSkills.filter(_.isInstanceOf[ArtAndCraft]).toSet
  }

  def chooseSkills(optionalSkill: Set[(Int, Set[Skill])]): Set[Skill] = {
    optionalSkill.flatMap(t => {
      Random.shuffle(t._2.toSeq).take(t._1)
    })
  }

  def spendPointsOnCreditRating(
      startingCreditRating: CreditRating,
      maximumCreditRating: CreditRating,
      occupationSkillPoints: InvestigatorSkillPoints
  )(implicit rollRange: ((Int, Int)) => Int): CreditRating = {
    if(maximumCreditRating.value - startingCreditRating.value > 0) {
      val points = rollRange(
        (0, maximumCreditRating.value - startingCreditRating.value)
      )

      val spent = occupationSkillPoints.spend(points)

      startingCreditRating.spend(spent)
    }

    startingCreditRating
  }
}
