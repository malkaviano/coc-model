package com.rkss.rpg.coc.foundations.specifications

import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.foundations.results._
import com.rkss.rpg.coc.concepts.characteristic._

final case class AidedSkillRollCheckSpec[
    A <: SkillRollNaming,
    B <: PhysicalCharacteristicName,
    C <: PhysicalCharacteristicName
](
    checkable: SkillRollCheckable[A],
    rolled: Seq[Int],
    expected: SkillRollChecked[A],
    markUsedWithSuccess: Boolean,
    opposing: Characteristic[B],
    helping: Seq[Characteristic[C]]
)
