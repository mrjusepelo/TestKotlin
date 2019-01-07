package co.devpenguin.testkotlin

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.JsResult
import android.webkit.WebChromeClient
import android.webkit.WebView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var context: Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context = this

        initInputs()

    }


    fun initInputs(){

        wv_main?.settings?.javaScriptEnabled = true

        wv_main.loadUrl("file:///android_asset/html/index.html");
        wv_main.webChromeClient = object : WebChromeClient() {
            override fun onJsAlert(view: WebView?, url: String?, message: String?, result: JsResult?): Boolean {
                if (result != null) {
                    result.cancel()
                }
                if (message != null) {
                    var list = message.split("|")

                    var name: String = list[0]
                    var description: String = list[1]
                    var index: Int = list[2].toInt()

                    val intent = Intent(context, DetailActivity::class.java)
                    intent.putExtra("name", name)
                    intent.putExtra("description", description)
                    intent.putExtra("index", index)
                    startActivity(intent)
                }


                //return super.onJsAlert(view, url, message, result)
                return true
            }
        }
    }
}
