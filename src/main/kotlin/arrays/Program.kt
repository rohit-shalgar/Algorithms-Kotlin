package arrays

import kotlin.math.abs

class Program {

    fun threeNumberSum(array: MutableList<Int>, targetSum: Int): List<List<Int>> {
        val combinations = ArrayList<List<Int>>();
        array.sort()
        for (i in 0..array.size - 2) {
            var rightIdx = i + 1
            var leftIdx = array.size - 1
            val currentSum = array[i] + array[rightIdx] + array[leftIdx]
            if (currentSum > targetSum) leftIdx -= 1
            else if (currentSum < targetSum) rightIdx += 1
            else combinations.add(listOf<Int>(array[i], array[rightIdx], array[leftIdx]))

        }
        return combinations
    }

    fun smallestDifference(arrayOne: MutableList<Int>, arrayTwo: MutableList<Int>): List<Int> {
        // Write your code here.
        arrayOne.sort()
        arrayTwo.sort()
        var currentLowestDiff = Int.MAX_VALUE
        val tempValues = intArrayOf(0, 0)
        var arrayOneIdx = 0
        var arrayTwoIdx = 0
        while (arrayOneIdx < arrayOne.size && arrayTwoIdx < arrayTwo.size) {
            val eleOne = arrayOne[arrayOneIdx]
            val eleTwo = arrayTwo[arrayTwoIdx]
            val diff = abs(eleOne - eleTwo)
            if (diff == 0) return listOf(eleOne, eleTwo)
            else if (diff < currentLowestDiff) {
                currentLowestDiff = diff
                tempValues[0] = eleOne
                tempValues[1] = eleTwo

            }
            if (eleOne < eleTwo) arrayOneIdx++
            else arrayTwoIdx++
        }
        return tempValues.toList()
    }

    fun moveElementToEnd(array: MutableList<Int>, toMove: Int): List<Int> {
        var start = 0
        var end = array.size - 1
        while (start < end) {
            while (start < end && array[end] == toMove) end--
            if (array[start] == toMove) swap(start, end, array)
            start++
        }
        return array
    }

    private fun swap(start: Int, end: Int, array: MutableList<Int>) {
        val temp = array[start]
        array[start] = array[end]
        array[end] = temp
    }

    fun spiralTraverse(array: List<List<Int>>): List<Int> {
        val traversed = ArrayList<Int>()
        for (column in 0 until array[0].size) {
            traversed.add(array[0][column])
        }
        for (row in 1 until array.size) {
            traversed.add(array[row][array[row].size - 1])
        }
        for (column in array[0].size - 2..0) {
            traversed.add(array[array.size - 1][column])
        }
        for (row in array.size - 2..1) {
            traversed.add(array[row][0])
        }
        return traversed
    }

}