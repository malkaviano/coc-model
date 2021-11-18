package com.malk.coc.concepts.occupations

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class OccupationSkillPointsSpec extends AnyFunSpec with Matchers {

  describe("OccupationSkillPoints behavior") {
    val osp = OccupationSkillPoints(220)

    describe(s"${osp}") {
      describe("spend return") {
        describe("when spend 200 points") {
          val expected = 200

          val result = osp spend 200

          it(s"should be ${expected}") {
            result shouldBe expected
          }
        }

        describe("when spend another 50 points") {
          val expected = 20

          val result = osp spend 50

          it(s"should be ${expected}") {
            result shouldBe expected
          }
        }

        describe("when spend another 10 points") {
          val expected = 0

          val result = osp spend 10

          it(s"should be ${expected}") {
            result shouldBe expected
          }
        }
      }
    }
  }
}
