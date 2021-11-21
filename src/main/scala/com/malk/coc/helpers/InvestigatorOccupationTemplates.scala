package com.malk.coc.helpers

import scala.util.Random

import com.malk.coc.traits.OccupationTemplate
import com.malk.coc.concepts.occupations._

object InvestigatorOccupationTemplates {
  private val occupationTemplates: Map[String, OccupationTemplate] = Map(
    TribeMemberOccupationTemplate.name -> new TribeMemberOccupationTemplate,
    SoldierOccupationTemplate.name -> new SoldierOccupationTemplate,
    ZealotOccupationTemplate.name -> new ZealotOccupationTemplate
  )

  def occupationTemplateNames: Set[String] = {
    occupationTemplates.keySet
  }

  def randomOccupationTemplateName: String = {
    Random.shuffle(occupationTemplates.keysIterator.toSeq).head
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
