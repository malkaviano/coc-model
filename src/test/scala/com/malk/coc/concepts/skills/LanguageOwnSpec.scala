package com.malk.coc.concepts.skills

import org.scalatest.funspec.AnyFunSpec

import com.malk.coc.concepts.characteristics.Education

class LanguageOwnSpec extends AnyFunSpec with BehavesLikeSkill {
  describe("The Language Own skill") {
    val edu = Education(67)

    val skill = LanguageOwn(edu)()

    behavesLikeSkill(skill, "Language Own", 67, true, 11)
  }
}