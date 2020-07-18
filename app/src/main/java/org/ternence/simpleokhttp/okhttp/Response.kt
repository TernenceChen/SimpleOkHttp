package org.ternence.simpleokhttp.okhttp

class Response internal constructor(
    val request: Request,
    val body: ResponseBody?
){

    fun newBuilder(): Builder = Builder(this)

    open class Builder {
        internal var request: Request? = null
        internal var body: ResponseBody? = null

        constructor() {

        }

        internal constructor(response: Response) {
            this.request = response.request
            this.body = response.body
        }

        fun request(request: Request) = apply {
            this.request = request
        }

        open fun body(body: ResponseBody?) = apply {
            this.body = body
        }
    }

}
