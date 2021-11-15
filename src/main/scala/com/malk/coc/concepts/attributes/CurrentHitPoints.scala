package com.malk.coc.concepts.attributes

import com.malk.coc.traits.Attribute

final case class CurrentHitPoints(override val value: Int) extends Attribute("Current Hit Points", value) {
}
