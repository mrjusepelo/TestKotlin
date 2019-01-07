package co.devpenguin.testkotlin

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    var context: Context? = null
    var index: Int? = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        context = this
        setSupportActionBar(toolbar)
        var extras: Bundle? = intent.extras
        if (extras != null){
            index = extras.getInt("index")
            if (extras.get("name") != null) {
                var title: String? = extras.getString("name")
                supportActionBar?.title = ""
                supportActionBar?.setDisplayHomeAsUpEnabled(true)
                supportActionBar?.setHomeButtonEnabled(true)

                toolbar_title?.setText(title)

            }
        }

        initInputs()

    }


    fun initInputs(){

        wv_detail?.settings?.javaScriptEnabled = true

        wv_detail.loadUrl("file:///android_asset/html/detail.html");
        wv_detail.webViewClient = object : WebViewClient() {

            override fun onPageFinished(view: WebView?, url: String?) {
                if (view != null) {
                    view.loadUrl("javascript:loadDetails("+index+")")
                }

            }
        }
    }
}
