package com.malk.coc.helpers

trait WithValueMathHelper[A] {
  def -(minus: Int): A

  def +(plus: Int): A
}
