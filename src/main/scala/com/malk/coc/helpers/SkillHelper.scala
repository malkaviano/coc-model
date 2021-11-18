package com.malk.coc.helpers

import scala.util.Random

import com.malk.coc.concepts.skills._
import com.malk.coc.traits.Skill
import com.malk.coc.concepts.occupations.OccupationSkillPoints

object SkillHelper {
  val fighting: Set[Skill] = Set(
    Axe(0),
    Brawl(0),
    Chainsaw(0),
    Flail(0),
    Garrote(0),
    Spear(0),
    Sword(0),
    Whip(0)
  )

  val firearms: Set[Skill] = Set(
    Bow(0),
    Handgun(0),
    HeavyWeapons(0),
    Flamethrower(0),
    MachineGun(0),
    RifleAndShotgun(0),
    SubmachineGun(0)
  )

  def chooseSkills(optionalSkill: Set[(Int, Set[Skill])]): Set[Skill] = {
    optionalSkill.flatMap(t => {
      Random.shuffle(t._2.toSeq).take(t._1)
    })
  }

  def spendPointsOnCreditRating(
      startingCreditRating: CreditRating,
      maximumCreditRating: CreditRating,
      occupationSkillPoints: OccupationSkillPoints
  )(implicit rollRange: ((Int, Int)) => Int): CreditRating = {
    val points = rollRange((0 , maximumCreditRating.value - startingCreditRating.value))

    val spent = occupationSkillPoints.spend(points)

    startingCreditRating.copy(startingCreditRating.value + spent)
  }
}
