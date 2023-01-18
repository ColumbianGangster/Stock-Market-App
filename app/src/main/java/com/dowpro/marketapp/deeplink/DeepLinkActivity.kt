package com.dowpro.marketapp.deeplink


import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.dowpro.feature_sentiments.SentimentsActivity

// TODO: Implement this fully
class DeepLinkActivity: ComponentActivity() {

    var url: String = ""

    companion object {
        fun start(context: Context, url: String, extras: Bundle? = null) {
            val intent = Intent(context, DeepLinkActivity::class.java)
            intent.data = Uri.parse(url)
            extras?.let { intent.putExtras(it) }
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setIntent(intent)
        setUrlToOpen()
        handleDeeplinkUrl()
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        setIntent(intent)
        setUrlToOpen()
        handleDeeplinkUrl()
    }

    private fun setUrlToOpen() {
        url = intent.data.toString()
    }

    private fun handleDeeplinkUrl() {
        when {
            url.contains("/sentiments") -> navigateToSentiments()
            else -> navigateToSplash()
        }
    }

    private fun navigateToSplash() {

    }

    private fun navigateToSentiments() {
        val intent = Intent(this, SentimentsActivity::class.java)
        startActivity(intent)
    }
}