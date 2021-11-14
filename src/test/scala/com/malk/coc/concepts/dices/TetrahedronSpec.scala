package com.malk.coc.concepts.dices

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
import org.scalamock.scalatest.MockFactory

class TetrahedronSpec
    extends AnyFunSpec
    with Matchers
    with MockFactory
    with BehavesLikeDice {
  describe("Tetrahedron Dice roll") {
    val rollD4 = mockFunction[(Int, Int), Int]

    val dice = Tetrahedron(rollD4)

    val name = "D4"
    val range = Tetrahedron.range

    behavesLikeDice(dice, name, range, rollD4, 2)
  }
}
