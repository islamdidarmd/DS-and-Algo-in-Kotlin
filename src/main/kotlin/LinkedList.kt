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

    fun printAll() {
        var current = head
        while (current != null) {
            print("${current.data} ")
            current = current.next
        }
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
}