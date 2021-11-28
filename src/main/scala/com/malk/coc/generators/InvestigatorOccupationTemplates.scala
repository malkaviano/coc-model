package com.malk.coc.generators

import scala.util.Random

import com.malk.coc.traits.OccupationTemplate
import com.malk.coc.concepts.occupations._
import com.malk.coc.concepts.characteristics.Education
import com.malk.coc.concepts.characteristics.Appearance
import com.malk.coc.concepts.abstractions.Body
import com.malk.coc.concepts.abstractions.Brain
import com.malk.coc.concepts.skills.languages.Language

object InvestigatorOccupationTemplates {
  private val occupationTemplates: Map[
    String,
    (Body, Brain, Education, Appearance, Language) => OccupationTemplate
  ] = Map(
    TribeMemberOccupationTemplate.name -> (
      (
        body: Body, brain: Brain, edu: Education, app: Appearance,
        language: Language
      ) => TribeMemberOccupationTemplate(body, brain, edu, app, language)
    )
  )

  def occupationTemplateNames: Set[String] = {
    occupationTemplates.keySet
  }

  def randomOccupationTemplateName: String = {
    Random.shuffle(occupationTemplates.keysIterator.toSeq).head
  }

  def occupationTemplate(key: String)(implicit
      body: Body,
      brain: Brain,
      edu: Education,
      app: Appearance,
      language: Language
  ): Option[OccupationTemplate] = {
    occupationTemplates.get(key) match {
      case Some(value) => Some(value(body, brain, edu, app, language))
      case None        => None
    }
  }

  object implicits {
    implicit def randomOccupationTemplate(implicit
        body: Body,
        brain: Brain,
        edu: Education,
        app: Appearance,
        language: Language
    ): OccupationTemplate = {
      occupationTemplate(randomOccupationTemplateName)(
        body,
        brain,
        edu,
        app,
        language
      ).get
    }
  }
}
