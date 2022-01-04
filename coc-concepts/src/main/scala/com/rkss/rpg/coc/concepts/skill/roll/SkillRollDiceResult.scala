package com.rkss.rpg.coc.concepts.skill.roll

import com.rkss.rpg.helpers.traits.DiceResult

final case class SkillRollDiceResult(
    override val value: Int,
    val discarded: Seq[Int] = Seq.empty[Int]
) extends DiceResult