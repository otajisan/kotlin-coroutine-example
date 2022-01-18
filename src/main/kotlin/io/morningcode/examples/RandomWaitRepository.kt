package io.morningcode.examples

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import org.springframework.stereotype.Repository

@Repository
class RandomWaitRepository(
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    suspend fun waitAndGetMessage(i: Int): String = withContext(ioDispatcher) {
        println("waitAndGetMessage: $i")
        val rand = (1000..2000).random().toLong()
        delay(rand)

        return@withContext "Hello World $i"
    }
}