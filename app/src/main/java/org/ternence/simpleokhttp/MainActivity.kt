package org.ternence.simpleokhttp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import org.ternence.simpleokhttp.okhttp.HttpClient
import org.ternence.simpleokhttp.okhttp.Request
import org.ternence.simpleokhttp.okhttp.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun showWeb(view: View) {
        val httpClient: HttpClient = HttpClient.Builder().build()

        val request: Request = Request.Builder().url("https://www.baidu.com").build()

        val response: Response = httpClient.newCall(request).execute()

        val result: String = response.newBuilder().body(null).toString()
        
    }
}