package com.rkss.rpg.coc.concepts.attributes

trait HitPoints
    extends DerivedAttribute[HitPointsAttribute.type]
    with AttributeWithCurrentValue
    with AttributeWithMaximumValue
