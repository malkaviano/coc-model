package com.rkss.rpg.coc.foundations.actions

import com.rkss.rpg.coc.foundations.results.OpposedSkillRollChecked
import com.rkss.rpg.coc.concepts.skill.roll._

final case class OpposedSkillRollCheckSpec[
    A <: SkillRollNaming,
    B <: SkillRollNaming
](
    attacker: SkillRollCheckable[A],
    defender: SkillRollCheckable[B],
    attackerRolled: Seq[Int],
    defenderRolled: Seq[Int],
    expected: OpposedSkillRollChecked[A, B],
    attackerMarkUsedWithSuccess: Boolean,
    defenderMarkUsedWithSuccess: Boolean
)
