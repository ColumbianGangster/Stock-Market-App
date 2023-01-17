package com.dowpro.feature_sentiments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.dowpro.library_design_system.composables.dialogs.MarketAlertDialog
import com.dowpro.library_design_system.composables.loading.LoadingSurface
import com.dowpro.library_design_system.composables.scaffolds.MyScaffold
import com.dowpro.library_design_system.theme.MarketAppTheme
import com.dowpro.library_network.Sentiment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SentimentsActivity : ComponentActivity() {

    private val viewModel: SentimentsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MarketAppTheme {
                MyScaffold(title = R.string.appbar_title_stock_sentiments) {

                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.mutableLiveData.observe(this@SentimentsActivity) { uiState ->
            when (uiState) {
                is SentimentsState.Loading -> showLoading(uiState.isLoading)
                is SentimentsState.Success -> showSentiments(uiState.sentiments)
                is SentimentsState.Error -> showError(uiState.exception)
            }
        }
        viewModel.getSentiments()
    }

    private fun showLoading(loading: Boolean) {
        if (loading) {
            setContent {
                MarketAppTheme {
                    MyScaffold(title = R.string.appbar_title_stock_sentiments) {
                        LoadingSurface()
                    }
                }
            }
        }
    }

    private fun showSentiments(sentiments: List<Sentiment>) {
        setContent {
            MarketAppTheme {
                MyScaffold(title = R.string.appbar_title_stock_sentiments) {
                    SentimentLazyColumn(sentiments) { sentiment ->
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/finance/quote/${sentiment.ticker}"))
                        startActivity(intent)
                    }
                }
            }
        }
    }

    private fun showError(throwable: Throwable) {
        setContent {
            MarketAppTheme {
                MyScaffold(title = R.string.appbar_title_stock_sentiments) {
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


