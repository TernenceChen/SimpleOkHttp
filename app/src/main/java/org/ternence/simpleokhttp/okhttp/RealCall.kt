package org.ternence.simpleokhttp.okhttp

class RealCall(
    val client: HttpClient,
    val request: Request,
    val forWebSocket: Boolean) : Call {

    override fun execute(): Response {
        synchronized(this) {

        }
        try {
            client.dispatcher.executed(this)
            return getResponseWithInterceptorChain()
        } finally {
            client.dispatcher.finished(this)
        }
    }

    internal fun getResponseWithInterceptorChain(): Response {
        val interceptors = mutableListOf<Interceptor>()
        interceptors += client.interceptors
        interceptors += RetryAndFollowUpInterceptor(client)
        interceptors += BridgeInterceptor(client.cookieJar)
        interceptors += CacheInterceptor(client.cache)
        interceptors += ConnectInterceptor
        if (!forWebSocket) {
            interceptors += client.networkInterceptors
        }
        interceptors += CallServerInterceptor(forWebSocket)

        val chain = RealInterceptorChain(

        )

        try {
            val response = chain.proceed(request)
            return response
        } catch (e: Exception) {

        } finally {
            // return empty
        }
    }


}