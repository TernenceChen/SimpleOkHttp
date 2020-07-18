package org.ternence.simpleokhttp.okhttp

import java.util.ArrayDeque
import java.util.concurrent.ExecutorService

class Dispatcher constructor() {

    @get:Synchronized var maxRequests = 64
    set(maxRequests) {
        require(maxRequests >= 1) {  "max < 1: $maxRequests" }
        synchronized(this) {
            field = maxRequests
        }
        //promote And Execute
    }

    @get:Synchronized var maxRequestsPerHost = 5
    set(maxRequestPerHost) {
        require(maxRequestsPerHost >= 1) {  "max < 1: $maxRequestsPerHost" }
        synchronized(this) {
            field = maxRequestsPerHost
        }
    }

    private var executorServiceOrNull: ExecutorService? = null

    private val readyAsyncCalls = ArrayDeque<AsyncCall>()

    private val runningAsyncCalls = ArrayDeque<AsyncCall>()

    private val runningSyncCalls = ArrayDeque<RealCall>()

    constructor(executorService: ExecutorService) : this() {
        this.executorServiceOrNull = executorService
    }

    @Synchronized internal fun executed(call: RealCall) {
        runningSyncCalls.add(call)
    }

    internal fun finished(call: RealCall) {

    }


}
