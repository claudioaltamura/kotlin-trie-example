package de.claudioaltamura.kotlin.trie.example

interface Trie<Value> {

    val root: Node<Value>

    data class Node<Value>(
        var parent: Node<Value>? = null,    // only used for the non-recursive delete operation
        val children: MutableMap<Char, Node<Value>> = mutableMapOf(),
        var value: Value? = null,
    )

    fun insert(key: String, value: Value)

    fun search(key: String): Value?

    fun delete(key: String)
}