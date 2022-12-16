package com.dowpro.library_core.data

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

interface DispatcherProvider {
    val default: CoroutineDispatcher get() = Dispatchers.Default
    val io: CoroutineDispatcher get() = Dispatchers.IO
    val main: CoroutineDispatcher get() = Dispatchers.Main
    val unconfined: CoroutineDispatcher get() = Dispatchers.Unconfined
}

class DefaultDispatchers : DispatcherProvider

abstract class Repository(dispatchers: DefaultDispatchers)

