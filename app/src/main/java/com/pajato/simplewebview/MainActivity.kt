package com.pajato.simplewebview

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_main.*
import android.view.inputmethod.InputMethodManager

/**
 * A simple Activity to get the hang of using WebView.
 *
 * @author Bryan Scott
 * */
class MainActivity : AppCompatActivity() {
    override fun onBackPressed() {
        if (this.mainWebView.canGoBack()) {
            this.mainWebView.goBack()
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        this.mainWebView.settings.javaScriptEnabled = true
        this.mainWebView.webViewClient = PajatoWebViewClient()

    }

    fun updateWebView(v: View) {
        var s: String = this.uriText.text.toString()
        if (!s.startsWith("http")) {
            s = "http://" + s
        }
        this.mainWebView.loadUrl(s)
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(this.uriText.windowToken, 0)
    }
}
