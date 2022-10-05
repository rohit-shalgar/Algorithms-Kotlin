package arrays

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
}