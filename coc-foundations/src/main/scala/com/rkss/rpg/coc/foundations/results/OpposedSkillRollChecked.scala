package com.rkss.rpg.coc.foundations.results

import com.rkss.rpg.coc.concepts.skill._

final case class OpposedSkillRollChecked[A <: SkillName, B <: SkillName](
    attacker: SkillRollChecked[A],
    defender: SkillRollChecked[B]
)
