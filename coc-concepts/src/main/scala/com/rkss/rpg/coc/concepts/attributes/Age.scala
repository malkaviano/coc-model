package com.rkss.rpg.coc.concepts.attributes

trait Age
    extends DerivedAttribute[AgeAttribute.type]
    with AttributeWithCurrentValue
    with AttributeWithMaximumValue