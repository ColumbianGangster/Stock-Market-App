package com.dowpro.library_core_testing

import com.dowpro.library_core_utils.DispatcherProvider
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.rules.TestWatcher
import org.junit.runner.Description

// Used to replace runBlockingTest
@ExperimentalCoroutinesApi
class CoroutineTestRule(val testDispatcher: TestDispatcher = UnconfinedTestDispatcher()): TestWatcher() {

    val testDispatcherProvider = object : DispatcherProvider {
        override val default: CoroutineDispatcher
            get() = testDispatcher

        override val io: CoroutineDispatcher
            get() = testDispatcher

        override val main: CoroutineDispatcher
            get() = testDispatcher

        override val unconfined: CoroutineDispatcher
            get() = testDispatcher
    }

    override fun starting(description: Description) {
        super.starting(description)
        Dispatchers.setMain(testDispatcher)
    }

    override fun finished(description: Description) {
        super.finished(description)
        Dispatchers.resetMain()
    }
}
