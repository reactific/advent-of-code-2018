package com.reactific.aoc2018

import scala.io.Source

object Day02 {

  def main(args: Array[String]): Unit = {

    // Read data from resource file
    val input = Source.fromResource("Day02.txt").getLines().filterNot(_.isEmpty).toVector

    case class Tally(twos: Int, threes: Int) {
      def printHash(): Unit = println(twos * threes)
    }

    input.foldLeft(Tally(0,0)) {
      case (tally: Tally, string: String) =>
        val groups = string.groupBy(identity)
        val duplicates = if (groups.exists { case (_: Char, s: String) => s.length == 2}) 1 else 0
        val triplicates =  if (groups.exists { case (_: Char, s: String) => s.length == 3}) 1 else 0
        Tally(tally.twos + duplicates, tally.threes + triplicates)
    }.printHash()

  }
}