package com.lombardo.app.problems

class BinarySearch {
  def getIndexOf(list: Array[Int], targetItem: Int): Int = {
    val lowIndex = 0
    val highIndex = list.size - 1
    doGetIndex(list, targetItem, lowIndex, highIndex)
  }

  def contains(list: Array[Int], target: Int): Boolean = {
    if (getIndexOf(list, target) == -1) false else true
  }

  private def doGetIndex(list: Array[Int], targetItem: Int, lowIndex: Int, highIndex: Int): Int = {
    val middleIndex = (lowIndex + highIndex) / 2
    val guess = list(middleIndex)
    if (guess == targetItem) middleIndex
    else if (lowIndex > highIndex) -1
    else if (guess > targetItem) doGetIndex(list, targetItem, lowIndex, middleIndex - 1)
    else doGetIndex(list, targetItem, middleIndex + 1, highIndex)
  }

  def indexOfMutable(list: Array[Int], targetItem: Int): Int = {
    var lowIndex = 0
    var highIndex = list.size - 1
    var solve = -1
    while (lowIndex <= highIndex) {
      val middleIndex = (lowIndex + highIndex) / 2
      val guess = list(middleIndex)
      if (guess == targetItem) solve = middleIndex
      if (guess > targetItem) highIndex = middleIndex - 1
      else lowIndex = middleIndex + 1
    }
    solve
  }
}
