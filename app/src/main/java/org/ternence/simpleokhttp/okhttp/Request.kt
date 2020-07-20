package org.ternence.simpleokhttp.okhttp

class Request internal constructor(
    val url: HttpUrl,
    val method: String,
    val headers: Headers,
    val body: RequestBody?
){

    class Builder{

        internal var url: HttpUrl? = null
        internal var method: String
        internal var headers: Headers.Builder
        internal var body: RequestBody? = null

        constructor() {
            this.method = "GET"
            this.headers = Headers.Builder()
        }

        open fun url(url: HttpUrl): Builder = apply {
            this.url = url
        }

        fun url(url: String): Builder {
            val finalUrl: String = when {
                url.startsWith("ws:", ignoreCase = true) -> {
                    "http:${url.substring(3)}"
                }
                url.startsWith("wss:", ignoreCase = true) -> {
                    "https:${url.substring(4)}"
                }
                else -> url
            }

//            return url(finalUrl.toHttpUrl())
            return this
        }

        fun build(): Request {
            return Request(
                checkNotNull(url) { "url == null"},
                method,
                headers.build(),
                body
            )
        }

    }

}