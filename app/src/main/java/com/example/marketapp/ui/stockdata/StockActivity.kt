package com.example.marketapp.ui.stockdata

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.marketapp.data.Stock
import com.example.marketapp.ui.composables.*
import com.example.marketapp.ui.theme.MarketAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StockActivity : ComponentActivity() {

    private val viewModel: StockViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.mutableLiveData.observe(this@StockActivity, { uiState ->
            when (uiState) {
                is StockUiState.Loading -> showLoading(uiState.isLoading)
                is StockUiState.Success -> showContent(uiState.model)
                is StockUiState.Error -> showError(uiState.exception)
            }
        })
        intent.getStringExtra("TICKER")?.let { ticker ->
            viewModel.getStock(ticker)
        }
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
                MarketTopAppBar("Stock Details")
            }, content = {
                f.invoke()
            })
    }

    private fun showContent(model: Model) {
        setContent {
            MarketAppTheme {
                BuildToolbar {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(1F)) {
                        StockSurface(model.stock, model.companyOverview)
                        model.incomeStatement.annualReports?.let { annualReports ->
                            AnnualReportLazyColumn(annualReports) {

                            }
                        }
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
                            intent.getStringExtra("TICKER")?.let { ticker ->
                                viewModel.getStock(ticker)
                            }
                        }, {
                            finish()
                        }
                    )
                }
            }
        }
    }
}
