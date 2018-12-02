package com.reactific.aoc2018

import scala.io.Source

import scala.collection.mutable


 object Day01 {

  def main(args: Array[String]): Unit = {

    // Read data from resource file
    val input = Source.fromResource("Day01.txt").getLines().filterNot(_.isEmpty).toVector

    // Do the computations for part A answer: sum the number on each line of the file
    val a_result = input
      .foldLeft(0) {
        case (acc: Int, num: String) =>
          acc + num.toInt
      }

    // Print the answer for part A
    println("Part A: " + a_result)


    // Set up a Stream to repeat the input endlessly
    val repeated_input: Stream[String] = {
      def loop(index: Int): Stream[String] = {
        if (index < input.length) {
          input(index) #:: loop(index + 1)
        } else {
          input(0) #:: loop(1)
        }
      }
      loop(0)
    }

    // Declare a Set for tracking all the frequencies that have occurred
    val frequencies: mutable.TreeSet[Int] = mutable.TreeSet[Int]()

    // Violate immutability for simplicity
    var acc: Int = 0

    // Take values from the repeated input until the accumulated frequency
    // has occurred in the frequencies Set
    val b_result = repeated_input.takeWhile { s: String =>
      acc += s.toInt
      if (frequencies.contains(acc)) {
        println(s"PartB: $acc")
        false
      } else {
        frequencies += acc
        true
      }
    }.toVector

    // Print the result
    println(s"Repeats its frequency after: \n $b_result")
  }
}