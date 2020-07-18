/*****************************************************************
 * * Copyright (C), 2020-2029, OnePlus Technology (Shenzhen) Co., Ltd
 * * VENDOR_EDIT
 * * File: - HttpClient
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

import androidx.constraintlayout.solver.Cache
import java.util.*

class HttpClient internal constructor(
    builder: Builder
){

    val dispatcher: Dispatcher = builder.dispatcher

    val interceptors: List<Interceptor> = Collections.unmodifiableList(builder.interceptors)

    val networkInterceptors: List<Interceptor> = Collections.unmodifiableList(builder.networkInterceptors)

    val cookieJar: CookieJar = builder.cookieJar

    val cache: Cache? = builder.cache

    class Builder constructor() {
        internal var dispatcher: Dispatcher = Dispatcher()
        internal val interceptors: MutableList<Interceptor> = mutableListOf()
        internal val networkInterceptors: MutableList<Interceptor> = mutableListOf()
        internal val cookieJar: CookieJar = CookieJar.NO_COOKIES
        internal var cache: Cache? = null



        fun build(): HttpClient = HttpClient(this)
    }

    fun newCall(request: Request): Call = RealCall(this, request, false)

}