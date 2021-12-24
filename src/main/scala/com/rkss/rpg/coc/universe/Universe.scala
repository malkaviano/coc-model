import com.rkss.rpg.coc.foundations.characteristics._
import com.rkss.rpg.coc.rules.SkillRoll
import com.rkss.rpg.coc.rules.PushedSkillRoll

object Universe extends App {
  println("Sample usage of concepts / rules")

  val strength = Strength(40)

  import com.rkss.rpg.helpers.dice.Bag._

  val skillRoll = SkillRoll(strength)

  println(s"Making a $skillRoll")

  println(s"Result is ${skillRoll.result}")

  val pushedRoll = PushedSkillRoll(skillRoll)

  println(s"Pushing the skill roll resulted in ${pushedRoll.result}")
}
