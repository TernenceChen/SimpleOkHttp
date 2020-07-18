package org.ternence.simpleokhttp.okhttp

interface Interceptor {


    interface Chain {
        fun proceed(request: Request): Response
    }

}
