package com.rkss.rpg.coc.concepts.attributes

import com.rkss.rpg.helpers.traits._

sealed trait AttributeName extends GlobalNameTag

case object SanityAttribute extends AttributeName
case object HitPointsAttribute extends AttributeName
case object MagicPointsAttribute extends AttributeName
case object AgeAttribute extends AttributeName
