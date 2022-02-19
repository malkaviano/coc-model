package com.rkss.rpg.coc.foundations.specifications

import com.rkss.rpg.coc.foundations.results._
import com.rkss.rpg.coc.concepts.characteristic._

final case class AidedSkillRollCheckSpec[
    A <: PhysicalCharacteristicName,
    B <: PhysicalCharacteristicName
](
    checkable: Characteristic[A],
    rolled: Seq[Int],
    expected: SkillRollChecked[A],
    markUsedWithSuccess: Boolean,
    opposing: Characteristic[B],
    helping: Seq[Characteristic[A]]
)
