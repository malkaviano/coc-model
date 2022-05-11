package com.rkss.rpg.coc.foundations.actions

import com.rkss.rpg.coc.foundations.results.OpposedSkillRollChecked
import com.rkss.rpg.coc.concepts.roll._

final case class OpposedSkillRollCheckSpecification[
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
