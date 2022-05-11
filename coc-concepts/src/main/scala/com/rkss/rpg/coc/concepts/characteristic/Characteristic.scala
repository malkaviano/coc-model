package com.rkss.rpg.coc.concepts.characteristic

import com.rkss.rpg.coc.concepts.roll._

trait Characteristic[+A <: CharacteristicName] extends SkillRollCheckable[A]
