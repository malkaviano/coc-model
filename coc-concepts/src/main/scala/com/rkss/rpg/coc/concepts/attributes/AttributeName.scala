package com.rkss.rpg.coc.concepts.attributes

import com.rkss.rpg.coc.concepts.commons.Naming

sealed trait AttributeName extends Naming

case object SanityAttribute extends AttributeName
case object HitPointsAttribute extends AttributeName
case object MagicPointsAttribute extends AttributeName
case object AgeAttribute extends AttributeName