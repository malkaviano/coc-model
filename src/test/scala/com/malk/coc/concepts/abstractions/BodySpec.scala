package com.malk.coc.concepts.abstractions

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
import com.malk.coc.concepts.characteristics.Strength
import com.malk.coc.concepts.characteristics.Size
import com.malk.coc.concepts.characteristics.Dexterity
import com.malk.coc.concepts.characteristics.Constitution

class BodySpec extends AnyFunSpec with Matchers {

  describe("External abstraction Body") {
    val str = Strength(50)
    val siz = Size(60)
    val dex = Dexterity(70)
    val con = Constitution(45)

    val body = Body(str, con, dex, siz)

    it(s"should have ${str}") {
      body.strength shouldBe str
    }

    it(s"should have ${dex}") {
      body.dexterity shouldBe dex
    }

    it(s"should have ${con}") {
      body.constitution shouldBe con
    }

    it(s"should have ${siz}") {
      body.size shouldBe siz
    }
  }
}
