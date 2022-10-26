package BST

import kotlin.math.abs

open class BST(value: Int) {
    var value = value
    val left: BST? = null
    val right: BST? = null
}

fun findClosestValueInBst(tree: BST, target: Int): Int {
    return findClosestValueInBstHelper(tree, target, tree.value)
}

private fun findClosestValueInBstHelper(tree: BST, target: Int, value: Int): Int {
    var newClosest = value
    if (abs(tree.value - target) < abs(target - newClosest)) {
        newClosest = tree.value
    }
    if (tree.value < target && tree.right != null) {
        findClosestValueInBstHelper(tree.right, target, tree.right.value)
    } else if (tree.value > target && tree.left != null) {
        findClosestValueInBstHelper(tree.left, target, tree.left.value)
    } else return tree.value
    return newClosest
}
