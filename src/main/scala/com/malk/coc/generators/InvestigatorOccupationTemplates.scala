package com.malk.coc.generators

import scala.util.Random

import com.malk.coc.traits.OccupationTemplate
import com.malk.coc.concepts.occupations._

object InvestigatorOccupationTemplates {
  private val occupationTemplates: Map[
    String,
    () => OccupationTemplate
  ] = Map(
    TribeMemberOccupationTemplate.name -> (
      () => new TribeMemberOccupationTemplate
    )
  )

  def occupationTemplateNames: Set[String] = {
    occupationTemplates.keySet
  }

  def randomOccupationTemplateName: String = {
    Random.shuffle(occupationTemplates.keysIterator.toSeq).head
  }

  def occupationTemplate(key: String): Option[OccupationTemplate] = {
    occupationTemplates.get(key) match {
      case Some(value) => Some(value())
      case None        => None
    }
  }

  object implicits {
    implicit def randomOccupationTemplate: OccupationTemplate = {
      occupationTemplate(randomOccupationTemplateName).get
    }
  }
}
