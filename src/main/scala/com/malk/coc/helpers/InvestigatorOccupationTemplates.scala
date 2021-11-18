package com.malk.coc.helpers

import scala.util.Random

import com.malk.coc.traits.OccupationTemplate
import com.malk.coc.concepts.occupations.TribeMemberTemplate

object InvestigatorOccupationTemplates {
  private val occupationTemplates: Map[String, OccupationTemplate] = Map(
    TribeMemberTemplate.name -> new TribeMemberTemplate
  )

  def occupationTemplateNames: Set[String] = {
    occupationTemplates.keySet
  }

  def randomOccupationTemplateName: String = {
    Random.shuffle(occupationTemplates.keysIterator.toList).head
  }

  def occupation(key: String): Option[OccupationTemplate] = {
    occupationTemplates.get(key)
  }

  object implicits {
    implicit def randomOccupationTemplate: OccupationTemplate = {
      occupation(randomOccupationTemplateName).get
    }
  }
}
