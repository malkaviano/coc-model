package com.malk.coc.concepts.attributes

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.malk.coc.concepts.characteristics.{Strength, Size}
import com.malk.coc.concepts.abstractions.Body
import com.malk.coc.concepts.characteristics.Constitution
import com.malk.coc.concepts.characteristics.Dexterity

trait BuildBehaviors extends Matchers { this: AnyFunSpec =>
  def calculateBuild(body: Body, expected: Int): Unit = {
    it(s"should return value ${expected}") {
      Build(body).value shouldBe expected
    }
  }
}

class BuildSpec extends AnyFunSpec with Matchers with BuildBehaviors {
  describe("The Build") {
    val con = Constitution(50)
    val dex = Dexterity(70)
    val body = Body(Strength(40), con, dex , Size(60))
    val bd = Build(body)

    it("should have name Build") {
      bd.name shouldBe "Build"
    }

    it should behave like calculateBuild(Body(Strength(40), con, dex, Size(60)), 0)
    it should behave like calculateBuild(Body(Strength(40), con, dex, Size(40)), -1)
    it should behave like calculateBuild(Body(Strength(30), con, dex, Size(30)), -2)
    it should behave like calculateBuild(Body(Strength(55), con, dex, Size(70)), 1)
    it should behave like calculateBuild(Body(Strength(80), con, dex, Size(90)), 2)
    it should behave like calculateBuild(Body(Strength(150), con, dex, Size(120)), 3)
    it should behave like calculateBuild(Body(Strength(150), con, dex, Size(170)), 4)
    it should behave like calculateBuild(Body(Strength(200), con, dex, Size(200)), 5)
    it should behave like calculateBuild(Body(Strength(250), con, dex, Size(250)), 6)
    it should behave like calculateBuild(Body(Strength(300), con, dex, Size(250)), 7)
    it should behave like calculateBuild(Body(Strength(301), con, dex, Size(304)), 8)
  }
}