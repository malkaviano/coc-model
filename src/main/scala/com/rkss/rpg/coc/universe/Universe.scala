import com.rkss.rpg.coc.foundations.characteristics._
import com.rkss.rpg.coc.rules._
import com.rkss.rpg.coc.concepts.skill.roll.RegularDifficulty
import com.rkss.rpg.coc.concepts.skill.roll.BonusDice
import com.rkss.rpg.coc.concepts.skill.roll.PenaltyDice

object Universe extends App {
  import com.rkss.rpg.helpers.dice.Bag._

  println("Sample usage of concepts / rules")

  val strength = Strength(40)

  val strengthSkillRollResult =
    strength.roll(RegularDifficulty, BonusDice(0), PenaltyDice(0))

  println(strengthSkillRollResult)

  val pushedRoll = PushedSkillRoll(strengthSkillRollResult)

  println(s"Pushing the skill roll resulted in ${pushedRoll.result}")
}
