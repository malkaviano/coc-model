import com.rkss.rpg.coc.foundations.characteristics._
import com.rkss.rpg.coc.concepts.skill.roll._

object Universe extends App {
  import com.rkss.rpg.helpers.dice.Bag._

  println("Sample usage of foundations")

  val strength = Strength(40)

  val strengthSkillRollResult =
    strength.roll(RegularDifficulty, BonusDice(0), PenaltyDice(0))

  println(strengthSkillRollResult)

  val pushedRoll = strength.pushRoll()

  println(s"Pushing the skill roll resulted in ${pushedRoll}")
}
