package io.morningcode.examples

import kotlinx.coroutines.*
import org.springframework.boot.logging.DeferredLogFactory
import org.springframework.stereotype.Service

@Service
class CoroutineExampleService(
    private val randomWaitRepository: RandomWaitRepository
) {
    /**
     * Get async message1
     *
     * @return Greeting Message
     */
    fun getAsyncMessage1(): String {
        val buffer = StringBuffer()
        runBlocking {
            launch {
                delay(1000L)
                buffer.append("World")
            }
            buffer.append("Hello")
        }

        return buffer.toString()
    }

    /**
     * Get async message2
     *
     * @return Greeting Message
     */
    fun getAsyncMessage2(): String {
        val buffer = StringBuffer()
        runBlocking {
            val message = async { getWorld() }
            buffer.append("Hello ${message.await()}")
        }

        return buffer.toString()
    }

    suspend fun getWorld(): String {
        delay(1000L)
        return "World"
    }

    /**
     * Get async message3
     *
     * @return Greeting Message
     */
    fun getAsyncMessage3(): String {
        val buffer = StringBuffer()

        for (i in 1..10) {
            val rand = (10..500).random()
            runBlocking {
                val message = async {
                    delay(rand.toLong())
                    "World $i"
                }

                buffer.append("Hello ${message.await()}\n")
            }
        }

        return buffer.toString()
    }

    /**
     * Get async message4
     *
     * @return Greeting Message
     */
    fun getAsyncMessage4(): String {
        val buffer = StringBuffer()
        runBlocking {
            launch { buffer.append(getAsyncWorld()) }

            buffer.append("Hello")
        }

        return buffer.toString()
    }

    suspend fun getAsyncWorld(): String = withContext(Dispatchers.IO) {
        delay(1000L)
        return@withContext "World"
    }

    /**
     * Get async message5
     *
     * @return Greeting Message
     */
    fun getAsyncMessage5(): String {
        val buffer = StringBuffer()

        for (i in 1..10) {
            val rand = (10..500).random()
            println("start: $i")
            runBlocking {
                launch {
                    coroutineScope {
                        val message = async {
                            delay(rand.toLong())
                            println("end: $i")
                            "World $i"
                        }

                        buffer.append("Hello ${message.await()}\n")
                    }
                }
            }
        }

        return buffer.toString()
    }

    /**
     * Get async message6
     *
     * @return Greeting Message
     */
    fun getAsyncMessage6(): String {
        val deferredList = mutableListOf<Deferred<String>>()

        val messageList = runBlocking<List<String>> {
            for (i in 1..10) {
                println("start fetch: $i")
                deferredList.add(async { randomWaitRepository.waitAndGetMessage(i) })
                println("queued: $i")
            }
            deferredList.awaitAll()
        }

        return messageList.joinToString("\n")
    }
}