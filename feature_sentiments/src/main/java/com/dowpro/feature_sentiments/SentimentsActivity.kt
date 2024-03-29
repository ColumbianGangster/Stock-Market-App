package com.dowpro.feature_sentiments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import com.dowpro.library_design_system.composables.dialogs.MarketAlertDialog
import com.dowpro.library_design_system.composables.loading.LoadingSurface
import com.dowpro.library_design_system.composables.scaffolds.TopAppBarScaffold
import com.dowpro.library_design_system.theme.AppMaterialTheme
import com.dowpro.library_network.Sentiment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SentimentsActivity : ComponentActivity() {

    private val viewModel: SentimentsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setup {  }
    }

    override fun onStart() {
        super.onStart()
        viewModel.sentiments.observe(this@SentimentsActivity) { uiState ->
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
            setup {
                setContent {
                    AppMaterialTheme {
                        TopAppBarScaffold(title = R.string.appbar_title_stock_sentiments) {
                            LoadingSurface()
                        }
                    }
                }
            }
        }
    }

    private fun showSentiments(sentiments: List<Sentiment>) {
        setup {
            SentimentLazyColumn(sentiments) { sentiment ->
                // TODO: Use URL builder which is more safe, and migrate logic to mapper.
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/finance/quote/${sentiment.ticker}"))
                startActivity(intent)
            }
        }
    }

    private fun showError(throwable: Throwable) {
        setup {
            MarketAlertDialog(
                throwable = throwable,
                retry = {
                    viewModel.getSentiments()
                },
                dismiss = {
                    finish()
                }
            )
        }
    }

    private fun setup(f: @Composable () -> Unit) {
        setContent {
            AppMaterialTheme {
                TopAppBarScaffold(title = R.string.appbar_title_stock_sentiments) {
                    f()
                }
            }
        }
    }
}
