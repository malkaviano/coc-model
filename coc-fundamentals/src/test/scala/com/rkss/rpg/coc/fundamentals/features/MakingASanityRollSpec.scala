package com.rkss.rpg.coc.fundamentals.features

import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.GivenWhenThen
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.coc.fundamentals.scenarios._
import com.rkss.rpg.coc.concepts.results._
import com.rkss.rpg.coc.fundamentals.attributes._
import com.rkss.rpg.coc.fundamentals.specs._
import com.rkss.rpg.coc.fundamentals.characteristics._
import com.rkss.rpg.coc.concepts.characteristic._
import com.rkss.rpg.coc.fundamentals.skills._

final class MakingASanityRollSpec
    extends AnyFeatureSpec
    with GivenWhenThen
    with Matchers
    with SanityRollScenario {

  info("As a player I need to make a sanity roll")
  info("So I can check if my investigator is gonna lose it!!!")

  Seq(
    SanityRollSpec(
      Sanity(Characteristic(Power, 50), CthulhuMythosSkillImpl()),
      10,
      SanityRollSuccessResult
    ),
    SanityRollSpec(
      Sanity(Characteristic(Power, 55), CthulhuMythosSkillImpl()),
      100,
      SanityRollFumble
    )
  ).foreach(spec => ScenariosFor(makingASanityRoll(spec)))
}
