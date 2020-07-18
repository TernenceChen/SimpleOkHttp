package org.ternence.simpleokhttp.okhttp

import java.util.ArrayList

class Headers private constructor(
    private val namesAndValues: Array<String>
){

    class Builder() {

        internal val namesAndValues: MutableList<String> = ArrayList(20)


        fun build(): Headers = Headers(namesAndValues.toTypedArray())

    }

}
