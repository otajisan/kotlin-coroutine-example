package io.morningcode.examples

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/v1")
class APIController(
    private val coroutineExampleService: CoroutineExampleService
) {

    /**
     * Get async message1
     *
     * @return Greeting Message
     */
    @Operation(summary = "get async message example 1")
    @ApiResponse(responseCode = "200", description = "Success")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = ["/ex1"])
    fun getAsyncMessage1(): String = coroutineExampleService.getAsyncMessage1()

    /**
     * Get async message2
     *
     * @return Greeting Message
     */
    @Operation(summary = "get async message example 2")
    @ApiResponse(responseCode = "200", description = "Success")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = ["/ex2"])
    fun getAsyncMessage2(): String = coroutineExampleService.getAsyncMessage2()

    /**
     * Get async message3
     *
     * @return Greeting Message
     */
    @Operation(summary = "get async message example 3")
    @ApiResponse(responseCode = "200", description = "Success")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = ["/ex3"])
    fun getAsyncMessage3(): String = coroutineExampleService.getAsyncMessage3()

    /**
     * Get async message4
     *
     * @return Greeting Message
     */
    @Operation(summary = "get async message example 4")
    @ApiResponse(responseCode = "200", description = "Success")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = ["/ex4"])
    fun getAsyncMessage4(): String = coroutineExampleService.getAsyncMessage4()

    /**
     * Get async message5
     *
     * @return Greeting Message
     */
    @Operation(summary = "get async message example 5")
    @ApiResponse(responseCode = "200", description = "Success")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = ["/ex5"])
    fun getAsyncMessage5(): String = coroutineExampleService.getAsyncMessage5()

    /**
     * Get async message6
     *
     * @return Greeting Message
     */
    @Operation(summary = "get async message example 6")
    @ApiResponse(responseCode = "200", description = "Success")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = ["/ex6"])
    fun getAsyncMessage6(): String = coroutineExampleService.getAsyncMessage6()

    /**
     * Ping
     *
     * @return Response message "pong"
     */
    @Operation(summary = "ping")
    @ApiResponse(responseCode = "200", description = "Success")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = ["/ping"])
    fun ping(): String = "pong"
}