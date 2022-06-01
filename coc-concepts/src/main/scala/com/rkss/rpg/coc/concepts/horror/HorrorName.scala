package com.rkss.rpg.coc.concepts.horror

import com.rkss.rpg.helpers._

sealed trait HorrorName extends GlobalNameTag

case object MummyMonster extends HorrorName
case object SkeletonMonster extends HorrorName
case object ZombieMonster extends HorrorName
