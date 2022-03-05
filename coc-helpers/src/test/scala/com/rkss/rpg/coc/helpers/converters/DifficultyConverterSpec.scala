package com.rkss.rpg.coc.helpers.converters

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.helpers.factories._
import com.rkss.rpg.coc.concepts.characteristic._
import com.rkss.rpg.coc.concepts.skill._

class DifficultyConverterSpec extends AnyFunSpec with Matchers {
  describe("Convert Skill value to difficulty") {

    it should behave like fromValue(1, RegularDifficulty)
    it should behave like fromValue(30, RegularDifficulty)
    it should behave like fromValue(49, RegularDifficulty)

    it should behave like fromValue(50, HardDifficulty)
    it should behave like fromValue(78, HardDifficulty)
    it should behave like fromValue(89, HardDifficulty)

    it should behave like fromValue(90, ExtremeDifficulty)
    it should behave like fromValue(99, ExtremeDifficulty)
    it should behave like fromValue(110, ExtremeDifficulty)
  }

  describe("Convert a list of skills to difficulty") {
    val strength = CharacteristicFactory.characteristic(Strength, 50)
    val computerUse = SkillFactory.basicSkill(ComputerUse, 0, 0)
    val charm = SkillFactory.basicSkill(Charm, 50, 40)

    it should behave like fromSkills(HardDifficulty, computerUse, strength)
    it should behave like fromSkills(ExtremeDifficulty, computerUse, charm)
    it should behave like fromSkills(RegularDifficulty, computerUse)
  }

  private def fromValue(
      value: Int,
      expected: SkillRollDifficultyLevel
  ): Unit = {
    describe(s"when value is $value") {
      it(s"returns $expected") {
        val result = DifficultyConverter.fromValue(value)

        result shouldBe expected
      }
    }
  }

  private def fromSkills(
    expected: SkillRollDifficultyLevel,
    skills: SkillRollCheckable[SkillRollNaming]*
  ): Unit = {
    describe(s"when skill list is ${skills.map(_.name.toString).mkString(",")}") {
      it(s"returns $expected") {
        val result = DifficultyConverter.fromSkills(skills:_*)

        result shouldBe expected
      }
    }
  }
}
