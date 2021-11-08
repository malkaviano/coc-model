package com.malk.coc.concepts.attributes

import com.malk.coc.concepts.characteristics.{Strength, Size}

case class Build(val str: Strength, val siz: Size) extends Attribute("Build") {
  override def value: Int = str.value + siz.value match {
    case x if x < 65 => -2
    case x if x < 85 => -1
    case x if x < 125 => 0
    case x if x < 165 => 1
    case x if x < 205 => 2
    case x if x < 285 => 3
    case x if x < 365 => 4
    case x if x < 445 => 5
    case x if x < 525 => 6
    case x =>
      val y = x - 524
      (y / 80.0).ceil.toInt + 6
  }
}