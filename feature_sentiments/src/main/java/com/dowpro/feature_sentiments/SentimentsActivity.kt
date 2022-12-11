package com.dowpro.feature_sentiments

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import com.dowpro.library_design_system.composables.dialogs.MarketAlertDialog
import com.dowpro.library_design_system.composables.loading.LoadingSurface
import com.dowpro.library_design_system.composables.other.MarketTopAppBar
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
                BuildToolbar {
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
                MarketTopAppBar(stringResource(R.string.appbar_title_stock_sentiments), false)
            }, content = {
                f.invoke()
            })
    }

    private fun showSentiments(sentiments: List<Sentiment>) {
        setContent {
            MarketAppTheme {
                BuildToolbar {
                    SentimentLazyColumn(sentiments) { sentiment ->
//                        val intent = Intent(this, StockDetailsActivity::class.java).apply {
//                            putExtra(StockDetailsActivity.TICKER, sentiment.ticker)
//                        }
//                        startActivity(intent)
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


