package de.claudioaltamura.kotlin.trie.example

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach

import org.junit.jupiter.api.Test


class TrieTest() {

    private val trie = TrieSimple<List<String>>()

    private val dictionary = mapOf(
        "t" to listOf("to", "te")
    )

    @BeforeEach
    fun init() {
        dictionary.forEach { (key, value) ->
            trie.insert(key, value)
        }
    }

    @Test
    fun search() {
        assertEquals(listOf("to", "te"), trie.search("t"))
    }

    @Test
    fun delete() {
        trie.delete("t")
        assertNull(trie.search("to"))
    }

}