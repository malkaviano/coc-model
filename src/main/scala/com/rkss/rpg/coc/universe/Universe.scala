import com.rkss.rpg.coc.foundations.characteristics._
import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.foundations.skills._

object Universe extends App {
  import com.rkss.rpg.helpers.dice.Bag._

  println("Sample usage of foundations")

  val strength = Strength(40)

  val strengthSkillRollResult =
    strength.roll(RegularDifficulty, BonusDice(0), PenaltyDice(0))

  println(s"Strength roll: $strengthSkillRollResult")

  val pushedRoll = strength.pushRoll()

  println(s"Pushing the strength result: ${pushedRoll}")

  val firstAid = FirstAid.create

  val firstAidRollResult =
    firstAid.roll(RegularDifficulty, BonusDice(0), PenaltyDice(0))

  println(s"First Aid roll: $firstAidRollResult")

  val pushedFirstAidRoll = firstAid.pushRoll()

  println(s"Pushing the First Aid result: ${pushedFirstAidRoll}")
}
