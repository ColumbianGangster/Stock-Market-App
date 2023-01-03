package com.dowpro.marketapp.deeplink


import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.dowpro.feature_crypto.PokemonsActivity
import com.dowpro.feature_sentiments.SentimentsActivity
import com.dowpro.feature_stock_details.ui.StockDetailsActivity

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
            url.contains("/stock-details") -> navigateToStockDetails()
            url.contains("/pokemons") -> navigateToPokemons()
            url.contains("/red") -> navigateToRed()
            url.contains("/blue") -> navigateToBlue()
            else -> navigateToSplash()
        }
    }

    private fun navigateToRed() {
        val intent = Intent(this, PokemonsActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToBlue() {
        val intent = Intent(this, PokemonsActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToPokemons() {
        val intent = Intent(this, PokemonsActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToSplash() {
//        val intent = Intent(this, SplashActivity::class.java)
//        startActivity(intent)
    }

    private fun navigateToStockDetails() {
        val intent = Intent(this, StockDetailsActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToSentiments() {
        val intent = Intent(this, SentimentsActivity::class.java)
        startActivity(intent)
    }
}