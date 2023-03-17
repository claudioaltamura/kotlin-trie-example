package de.claudioaltamura.kotlin.trie.example

open class TrieSimple<Value> : Trie<Value> {

    override val root = Trie.Node<Value>()

    override fun insert(key: String, value: Value) {
        var currentNode = root
        for (char in key) {
            println("char: $char")
            if (currentNode.children[char] == null) {
                currentNode.children[char] = Trie.Node()
            }
            currentNode = currentNode.children[char]!!
        }
        println("currentNode: $currentNode")
        currentNode.value = value
    }

    override fun search(key: String): Value? {
        var currentNode = root
        for (char in key) {
            if (currentNode.children[char] == null) {
                return null
            }
            currentNode = currentNode.children[char]!!
        }
        return currentNode.value
    }

}