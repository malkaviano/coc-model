package com.malk.coc.concepts.occupations

final case class InvestigatorSkillPoints(private var total: Int) {
  def remaining: Int = total

  def spend(points: Int): Int = {
    val spent = points match {
      case x if x <= total => x
      case _ => total
    }

    total -= spent

    spent
  }
}