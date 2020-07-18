/*****************************************************************
 * * Copyright (C), 2020-2029, OnePlus Technology (Shenzhen) Co., Ltd
 * * VENDOR_EDIT
 * * File: - Request
 * * Description:
 * * Version: 1.0
 * * Date : 20年7月18日
 * * Author: ternence.chen@oneplus.com
 * *
 * * ---------------------- Revision History:----------------------
 * * <author> <date> <version> <desc>
 * * ternence.chen 20年7月18日 1.0 create
 ******************************************************************/
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