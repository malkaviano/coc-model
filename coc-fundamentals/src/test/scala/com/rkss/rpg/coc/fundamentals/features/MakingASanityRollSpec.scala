package com.rkss.rpg.coc.fundamentals.features

import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.GivenWhenThen
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.coc.fundamentals.scenarios._
import com.rkss.rpg.coc.concepts.sanity._
import com.rkss.rpg.coc.fundamentals.attributes._
import com.rkss.rpg.coc.fundamentals.specs._

final class MakingASanityRollSpec
    extends AnyFeatureSpec
    with GivenWhenThen
    with Matchers
    with SanityRollScenario {

  info("As a player I need to make a sanity roll")
  info("So I can check if my investigator is gonna lose it!!!")

  Seq(
    SanityRollSpec(
      InvestigatorSanity(50),
      10,
      SuccessResult,
    ),
    SanityRollSpec(
      InvestigatorSanity(55),
      100,
      Fumble,
    )
  ).foreach(spec => ScenariosFor(makingASanityRoll(spec)))
}