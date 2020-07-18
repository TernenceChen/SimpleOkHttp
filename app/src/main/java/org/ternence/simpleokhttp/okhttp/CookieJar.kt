package org.ternence.simpleokhttp.okhttp

interface CookieJar {

    fun saveFromResponse(url: HttpUrl, cookies: List<Cookie>)

    fun loadForRequest(url: HttpUrl): List<Cookie>


    companion object {
        val NO_COOKIES: CookieJar = NoCookies()

        private class NoCookies : CookieJar {
            override fun saveFromResponse(url: HttpUrl, cookies: List<Cookie>) {
            }

            override fun loadForRequest(url: HttpUrl): List<Cookie> {
                return emptyList()
            }
        }
    }

}
