package de.claudioaltamura.kotlin.trie.example

open class TrieSimple<Value> : Trie<Value> {

    override val root = Trie.Node<Value>()

    override fun insert(key: String, value: Value) {
        var currentNode = root
        for (char in key) {
            if (currentNode.children[char] == null) {
                currentNode.children[char] = Trie.Node()
            }
            currentNode = currentNode.children[char]!!
        }
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

    override fun delete(key: String) {
        delete(key, 0, root)
    }

    private fun delete(key: String, index: Int, node: Trie.Node<Value>): Trie.Node<Value>? {
        if (index == key.length) {
            node.value = null
            if (node.children.isEmpty()) return null
            return node
        }

        val child = node.children[key[index]] ?: return null
        val deleteChild = delete(key, index + 1, child) == null
        if (deleteChild) {
            node.children.remove(key[index])
            if (node.children.isEmpty() && node.value == null) return null
        }

        return node
    }

}