package com.rkss.rpg.coc.helpers.converters

import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.concepts.characteristic._

object SkillConversion {
  object implicits {
    implicit def skillToSkillRollCheckable[A <: SkillName](
        skill: Skill[A]
    ): SkillRollCheckable[SkillRollNaming] = {
      skill.asInstanceOf[SkillRollCheckable[SkillRollNaming]]
    }

    implicit def characteristicToSkillRollCheckable[A <: CharacteristicName](
        characteristic: Characteristic[A]
    ): SkillRollCheckable[SkillRollNaming] = {
      characteristic.asInstanceOf[SkillRollCheckable[SkillRollNaming]]
    }
  }
}
