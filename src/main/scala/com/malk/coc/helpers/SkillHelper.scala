package com.malk.coc.helpers

import scala.util.Random

import com.malk.coc.concepts.skills._
import com.malk.coc.concepts.occupations.InvestigatorSkillPoints
import com.malk.coc.concepts.characteristics._
import com.malk.coc.traits._

object SkillHelper {
  val allSkills: Set[Skill] = Set(
    Accounting(0),
    Acting(0),
    AnimalHandling(0),
    Anthropology(0),
    Appraise(0),
    Archaeology(0),
    Arctic(0),
    Artillery(0),
    Astronomy(0),
    Axe(0),
    Biology(0),
    Botany(0),
    Bow(0),
    Brawl(0),
    Chainsaw(0),
    Charm(0),
    Chemistry(0),
    Climb(0),
    ComputerUse(0),
    CreditRating(0),
    Cryptography(0),
    CthulhuMythos(0),
    Demolitions(0),
    Desert(0),
    Disguise(0),
    Diving(0),
    Dodge(Dexterity(0))(0),
    DriveAuto(0),
    ElectricalRepair(0),
    Electronics(0),
    Engineering(0),
    FastTalk(0),
    FineArt(0),
    FirstAid(0),
    Flail(0),
    Flamethrower(0),
    Forensics(0),
    Forgery(0),
    Garrote(0),
    Geology(0),
    Handgun(0),
    HeavyWeapons(0),
    History(0),
    Hypnosis(0),
    Intimidate(0),
    Jump(0),
    LanguageOwn(Education(0))(0),
    Law(0),
    LibraryUse(0),
    Listen(0),
    Locksmith(0),
    MachineGun(0),
    Mathematics(0),
    MechanicalRepair(0),
    Medicine(0),
    Meteorology(0),
    NaturalWorld(0),
    Navigate(0),
    Occult(0),
    OperateHeavyMachinery(0),
    Persuade(0),
    Pharmacy(0),
    Photography(0),
    Physics(0),
    Psychoanalysis(0),
    Psychology(0),
    ReadLips(0),
    Ride(0),
    RifleAndShotgun(0),
    Sea(0),
    SleightOfHand(0),
    Spear(0),
    SpotHidden(0),
    Stealth(0),
    SubmachineGun(0),
    Swim(0),
    Sword(0),
    Throw(0),
    Track(0),
    Whip(0),
    WildernessTerrain(0),
    Zoology(0)
  )

  val fightingSkills: Set[Skill] = {
    allSkills.filter(_.isInstanceOf[Fighting])
  }

  val firearmsSkills: Set[Skill] = {
    allSkills.filter(_.isInstanceOf[Firearm])
  }

  val uncommonSkills: Set[Skill] = {
    allSkills.filter(_.isInstanceOf[UncommonSkill]).toSet
  }

  val modernSkills: Set[Skill] = {
    allSkills.filter(_.isInstanceOf[ModernEraSkill]).toSet
  }

  val specializationsSkills: Set[Skill] = {
    allSkills
      .filter(_.isInstanceOf[GenericSkill])
      .toSet -- firearmsSkills -- fightingSkills
  }

  val commonSkills: Set[Skill] = {
    allSkills -- uncommonSkills -- modernSkills - CthulhuMythos(
      0
    )
  }

  val interpersonalSkills: Set[Skill] = {
    allSkills.filter(_.isInstanceOf[InterpersonalSkill]).toSet
  }

  val survivalSkills: Set[Skill] = {
    allSkills.filter(_.isInstanceOf[Survival]).toSet
  }

  val pilotSkills: Set[Skill] = {
    allSkills.filter(_.isInstanceOf[Pilot]).toSet
  }

  val loreSkills: Set[Skill] = {
    allSkills.filter(_.isInstanceOf[Lore]).toSet
  }

  val languageOtherSkills: Set[Skill] = {
    allSkills.filter(_.isInstanceOf[LanguageOther]).toSet
  }

  val scienceSkills: Set[Skill] = {
    allSkills.filter(_.isInstanceOf[Science]).toSet
  }

  val artAndCraftSkills: Set[Skill] = {
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
    val points = rollRange(
      (0, maximumCreditRating.value - startingCreditRating.value)
    )

    val spent = occupationSkillPoints.spend(points)

    startingCreditRating.copy(startingCreditRating.value + spent)
  }
}
