package com.malk.coc.traits

abstract class Characteristic(val name: String, val value: Int) {
  def -(minus: Int): Characteristic

  def +(plus: Int): Characteristic
}
