package com.dowpro.feature_crypto.data

import com.dowpro.feature_crypto.PokemonsQuery
import com.dowpro.library_core_testing.CoroutineTestRule
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import io.mockk.mockk
import org.junit.Before
import org.junit.Rule
import org.junit.Test

// Needed for CoroutineTestRule and runTest
@OptIn(ExperimentalCoroutinesApi::class)
class PokemonRepositoryTest {

    private lateinit var SUT : PokemonRepositoryImpl

    @get:Rule
    var coroutineTestRule = CoroutineTestRule()

    @Before
    fun setup() {
        SUT = PokemonRepositoryImpl(mockk())
    }

    @Test
    fun `test get pokemon successfully`() = runTest(coroutineTestRule.testDispatcher) {
        val result = SUT.getPokemons()
        assertEquals(emptyList<PokemonsQuery.Pokemon>(), result)
    }

    @Test
    fun `test get pokemon unsuccessfully`() = runTest(coroutineTestRule.testDispatcher) {

    }
}