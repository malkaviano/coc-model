package com.malk.coc.concepts.attributes

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.malk.coc.concepts.characteristics.{Strength, Size}

trait BuildBehaviors extends Matchers { this: AnyFunSpec =>
  def calculateBuild(str: Strength, siz: Size, expected: Int): Unit = {
    it(s"should return value ${expected}") {
      Build(str, siz).value shouldBe expected
    }
  }
}

class BuildSpec extends AnyFunSpec with Matchers with BuildBehaviors {
  describe("The Build") {
    val bd = Build(str = Strength(40), siz = Size(60))

    it("should have name Build") {
      bd.name shouldBe "Build"
    }

    it should behave like calculateBuild(Strength(40), Size(60), 0)
    it should behave like calculateBuild(Strength(40), Size(40), -1)
    it should behave like calculateBuild(Strength(30), Size(30), -2)
    it should behave like calculateBuild(Strength(55), Size(70), 1)
    it should behave like calculateBuild(Strength(80), Size(90), 2)
    it should behave like calculateBuild(Strength(150), Size(120), 3)
    it should behave like calculateBuild(Strength(150), Size(170), 4)
    it should behave like calculateBuild(Strength(200), Size(200), 5)
    it should behave like calculateBuild(Strength(250), Size(250), 6)
    it should behave like calculateBuild(Strength(300), Size(250), 7)
    it should behave like calculateBuild(Strength(301), Size(304), 8)
  }
}