package org.ternence.simpleokhttp.okhttp

class HttpUrl {


    class Builder {
        internal var scheme: String? = null
        internal var encodedUsername = ""
        internal var encodedPassword = ""
        internal var host: String? = null
        internal var port = -1
        internal val encodedPathSegments = mutableListOf<String>()
        internal var encodedQueryNamesAndValues: MutableList<String?>? = null
        internal var encodedFragment: String? = null
    }

}
