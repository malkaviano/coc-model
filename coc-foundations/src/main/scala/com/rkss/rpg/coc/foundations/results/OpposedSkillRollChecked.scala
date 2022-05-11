package com.rkss.rpg.coc.foundations.results

import com.rkss.rpg.coc.concepts.roll._

final case class OpposedSkillRollChecked[
    A <: SkillRollNaming,
    B <: SkillRollNaming
](
    attacker: SkillRollChecked[A],
    defender: SkillRollChecked[B]
)
