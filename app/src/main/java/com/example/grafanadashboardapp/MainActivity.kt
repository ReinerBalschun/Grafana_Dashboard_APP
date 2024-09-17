package com.example.grafanadashboardapp

import android.content.Intent
import android.os.Bundle
import android.webkit.JavascriptInterface
import android.webkit.WebView
import android.widget.Toast  

import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit  
    var webView: WebView  // Add semicolon here

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)  


        webView = findViewById(R.id.webView)
        webView.settings.javaScriptEnabled = true
        webView.addJavascriptInterface(JavaScriptInterface(),  
        "Android")
        webView.webViewClient = WebViewClient()
        webView.loadUrl("http://192.168.0.130:3000/public-dashboards/9c1f6f09da6a4769b18a75d681aa4b7d?orgId=1&refresh=auto")
    }

    inner class JavaScriptInterface {
        @JavascriptInterface
        fun showToast(message: String) {
            // Zeigt einen Toast mit der übergebenen Nachricht an
            Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
        }

        @JavascriptInterface
        fun openNewActivity() {
            // Startet eine neue Activity
            startActivity(Intent(this@MainActivity, OtherActivity::class.java))
        }
    }
}