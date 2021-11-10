package com.malk.coc.traits

import com.malk.coc.concepts.characteristics.Age
import com.malk.coc.concepts.characteristics.Education

trait AgingEffectOnEducation {
  def modifiedEducation(age: Age, edu: Education): Education
}
