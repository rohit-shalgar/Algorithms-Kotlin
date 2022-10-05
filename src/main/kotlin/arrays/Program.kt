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
}