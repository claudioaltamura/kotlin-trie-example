package de.claudioaltamura.kotlin.trie.example

import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test


class TrieTest() {

    private val trie = TrieSimple<List<String>>()

    private val dictionary = mapOf(
        "A" to listOf("AA", "AB"),
        "B" to listOf("BB", "BC"),
        "C" to listOf("CC", "CD")
    )

    init {
        dictionary.forEach { (key, value) ->
            trie.insert(key, value)
        }
    }

    @Test
    fun search() {
        assertEquals(listOf("AA", "AB"), trie.search("A"))
    }

}