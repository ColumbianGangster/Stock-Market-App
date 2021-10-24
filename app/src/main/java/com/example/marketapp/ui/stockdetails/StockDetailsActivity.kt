package com.example.marketapp.ui.stockdetails

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.marketapp.domain.DomainStockDetails
import com.example.marketapp.ui.composables.*
import com.example.marketapp.ui.theme.MarketAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StockDetailsActivity : ComponentActivity() {

    private val viewModel: StockViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.mutableLiveData.observe(this@StockDetailsActivity, { uiState ->
            when (uiState) {
                is StockUiState.Loading -> showLoading(uiState.isLoading)
                is StockUiState.Success -> showContent(uiState.domainStockDetails)
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

    private fun showContent(domainStockDetails: DomainStockDetails) {
        setContent {
            MarketAppTheme {
                BuildToolbar {
                    Column(
                        modifier = Modifier.fillMaxWidth(1F)) {
                        StockSurface(domainStockDetails.ticker, domainStockDetails.stock, domainStockDetails.companyOverview)
                        domainStockDetails.incomeStatement?.annualReports?.let { annualReports ->
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
