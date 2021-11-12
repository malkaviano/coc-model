package com.malk.coc.traits

trait Characteristic {
  def name: String

  def value: Int

  def -(minus: Int): Characteristic = {
    this + -minus
  }

  def +(plus: Int): Characteristic
}
