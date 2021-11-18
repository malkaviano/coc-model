package com.malk.coc.helpers

import scala.util.Random

import com.malk.coc.traits.Occupation
import com.malk.coc.concepts.occupations.TribeMemberTemplate

object InvestigatorOccupations {
  private val occupations: Map[String, Occupation] = Map(
    TribeMemberTemplate.name -> new TribeMemberTemplate
  )

  def occupationNames: Set[String] = {
    occupations.keySet
  }

  def randomOccupationName: String = {
    Random.shuffle(occupations.keysIterator.toList).head
  }

  def occupation(key: String): Option[Occupation] = {
    occupations.get(key)
  }

  object implicits {
    implicit def randomOccupation: Occupation = {
      occupation(randomOccupationName).get
    }
  }
}
