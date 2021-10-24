package com.example.marketapp.ui.sentiments

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import com.example.marketapp.data.Sentiment
import com.example.marketapp.ui.composables.LoadingSurface
import com.example.marketapp.ui.composables.MarketAlertDialog
import com.example.marketapp.ui.composables.MarketTopAppBar
import com.example.marketapp.ui.composables.SentimentLazyColumn
import com.example.marketapp.ui.stockdetails.StockDetailsActivity
import com.example.marketapp.ui.theme.MarketAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SentimentsActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            setContent {
                MarketAppTheme {
                    BuildToolbar {

                    }
                }
            }
        }
        viewModel.mutableLiveData.observe(this@SentimentsActivity, { uiState ->
            when (uiState) {
                is MainUiState.Loading -> showLoading(uiState.isLoading)
                is MainUiState.Success -> showSentiments(uiState.sentiments)
                is MainUiState.Error -> showError(uiState.exception)
            }
        })
        viewModel.getSentiments()
    }

    private fun showLoading(loading: Boolean) {
        if (loading) {
            setContent {
                MarketAppTheme {
                    BuildToolbar {
                        LoadingSurface()
                    }
                }
            }
        }
    }

    @Composable
    private fun BuildToolbar(f: @Composable () -> Unit) {
        Scaffold(
            topBar = {
                MarketTopAppBar("Stock Sentiments")
            }, content = {
                f.invoke()
            })
    }

    private fun showSentiments(sentiments: List<Sentiment>) {
        setContent {
            MarketAppTheme {
                BuildToolbar {
                    SentimentLazyColumn(sentiments) { sentiment ->
                        val intent = Intent(this, StockDetailsActivity::class.java).apply {
                            putExtra("TICKER", sentiment.ticker)
                        }
                        startActivity(intent)
                    }
                }
            }
        }
    }

    private fun showError(throwable: Throwable) {
        setContent {
            MarketAppTheme {
                BuildToolbar {
                    MarketAlertDialog(throwable,
                        {
                            viewModel.getSentiments()
                        }, {
                            finish()
                        }
                    )
                }
            }
        }
    }
}


