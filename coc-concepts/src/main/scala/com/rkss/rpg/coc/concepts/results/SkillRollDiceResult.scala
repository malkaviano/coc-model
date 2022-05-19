package com.rkss.rpg.coc.concepts.results

import com.rkss.rpg.helpers.dice._

final case class SkillRollDiceResult(
    override val value: Int,
    val discarded: Seq[Int] = Seq.empty[Int]
) extends DiceResult
