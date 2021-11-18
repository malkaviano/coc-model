package com.malk.coc.helpers

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
import com.malk.coc.concepts.occupations.TribeMemberTemplate

class InvestigatorOccupationsSpec extends AnyFunSpec with Matchers {
  describe("Investigator Occupations Helper") {
    describe("getting all occupation names") {
      val expected = Set("TRIBE MEMBER")

      it("should return a list of occupation names") {
        InvestigatorOccupations.occupationNames shouldBe expected
      }
    }

    describe("getting a random occupation name") {
      val expected = "TRIBE MEMBER"

      it(s"should return ${expected}") {
        InvestigatorOccupations.randomOccupationName shouldBe expected
      }
    }

    describe("getting a occupation template") {
      describe(s"when name exists") {
        val key = TribeMemberTemplate.name
        it(s"should return template") {
          val result = InvestigatorOccupations.occupation(key)

          result shouldBe defined
        }
      }

      describe(s"when name does not exist") {
        val key = "DOES NOT EXIST"

        it(s"should return None") {
          val result = InvestigatorOccupations.occupation(key)

          result shouldBe None
        }
      }
    }

    describe("getting random occupation") {
      it("should return an occupation") {
        val result = InvestigatorOccupations.implicits.randomOccupation

        InvestigatorOccupations.occupationNames should contain (result.name)
      }
    }
  }
}
