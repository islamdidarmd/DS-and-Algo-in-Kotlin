package ds

fun main() {
    val bst = BST()
    bst.insert(data = 10)
    bst.insert(data = 5)
    bst.insert(data = 12)
    bst.insert(data = 6)
    bst.insert(data = 4)

    println("-----------In order------------")
    bst.traverseInOrder()
    println("\n-----------Pre order------------")
    bst.traversePreOrder()
    println("\n-----------Post order------------")
    bst.traversePostOrder()
}

class BST {
    inner class Node(val data: Int) {
        var left: Node? = null
        var right: Node? = null
    }

    var root: Node? = null

    fun insert(data: Int) {
        insert(parent = root, data = data)
    }

    private fun insert(parent: Node?, data: Int): Node {
        if (parent == null) {
            val node = Node(data = data)
            if (root == null) {
                root = node
            }
            return node
        }
        if (data < parent.data) {
            parent.left = insert(parent = parent.left, data = data)
        } else if (data > parent.data) {
            parent.right = insert(parent = parent.right, data = data)
        } else {
            throw IllegalArgumentException()
        }

        return parent
    }

    fun traversePreOrder() {
        traversePreOrder(root)
    }

    fun traverseInOrder() {
        traverseInOrder(root)
    }

    fun traversePostOrder() {
        traversePostOrder(root)
    }

    private fun traversePreOrder(root: Node?) {
        if (root == null) return
        print("${root.data} ")
        traversePreOrder(root.left)
        traversePreOrder(root.right)
    }

    private fun traverseInOrder(root: Node?) {
        if (root == null) return
        traverseInOrder(root.left)
        print("${root.data} ")
        traverseInOrder(root.right)
    }

    private fun traversePostOrder(root: Node?) {
        if (root == null) return
        traversePostOrder(root.left)
        traversePostOrder(root.right)
        print("${root.data} ")
    }

    fun isIdentical(bst: BST): Boolean {
        return isIdentical(bst1 = root, bst2 = bst.root)
    }

    private fun isIdentical(bst1: Node?, bst2: Node?): Boolean {
        if (bst1 == null && bst2 == null) {
            return true
        } else if (bst1 == null || bst2 == null) {
            return false
        } else if (bst1.data == bst2.data) {
            return isIdentical(bst1 = bst1.left, bst2 = bst2.left) && isIdentical(bst1 = bst1.right, bst2 = bst2.right)
        }

        return false
    }

    fun isHeightBalanced(): Boolean {
        if (root == null) return false
        val leftHeight = getHeightOfNode(root!!.left)
        val rightHeight = getHeightOfNode(root!!.right)
        return leftHeight - rightHeight <= 1
    }

    private fun getHeightOfNode(node: Node?): Int {
        if (node == null) return 0
        val leftHeight = getHeightOfNode(node = node.left)
        val rightHeight = getHeightOfNode(node = node.right)
        return maxOf(leftHeight, rightHeight) + 1
    }
}