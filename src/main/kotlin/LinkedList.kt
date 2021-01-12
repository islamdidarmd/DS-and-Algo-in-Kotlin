/*
LinkedList implementation in kotlin
 */

class Node<T>(
    val data: T,
    var next: Node<T>?
)

class LinkedList<T> {
    var head: Node<T>? = null

    fun add(data: T) {
        val node = Node(data, null)
        if (head == null) head = node
        else {
            var current = head
            while (current!!.next != null) {
                current = current.next
            }
            current.next = node
        }
    }

    fun delete(data: T) {
        var current = head
        if (current == null) {
            println("List is empty")
            return
        }

        if (head!!.data == data) {
            head = head?.next
            return
        }

        while (current != null) {
            if (current.next?.data == data) {
                val tail = current.next!!.next
                current.next = tail
                break
            }
            current = current.next
        }
    }

    fun reverse() {
        if (head == null) {
            println("List is empty")
            return
        }
        var prev: Node<T>? = null
        var curr: Node<T>? = head

        while (curr != null) {
            val next = curr.next
            curr.next = prev

            prev = curr
            curr = next
        }
        head = prev
    }

    fun printAll() {
        var current = head
        while (current != null) {
            print("${current.data} ")
            current = current.next
        }
    }

    fun printAllReversed(node: Node<T>? = head) {
        if (node == null) return
        printAllReversed(node.next)
        print("${node.data} ")
    }
}

fun main() {
    val list = LinkedList<Int>()

    list.add(1)
    list.add(2)
    list.add(3)
    list.add(4)
    list.add(5)

    list.printAll()

    print("\n----------\n")
    list.printAllReversed()

    print("\n----------\n")
    list.delete(1)
    list.printAll()

    print("\n----------\n")
    list.reverse()
    list.printAll()
}