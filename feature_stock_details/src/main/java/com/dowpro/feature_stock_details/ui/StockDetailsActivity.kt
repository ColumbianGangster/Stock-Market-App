package com.dowpro.feature_stock_details.ui


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.res.stringResource
import com.dowpro.feature_stock_details.R
import com.dowpro.feature_stock_details.domain.DomainStockDetails
import com.dowpro.library_design_system.composables.dialogs.MarketAlertDialog
import com.dowpro.library_design_system.composables.loading.LoadingSurface
import com.dowpro.library_design_system.composables.other.MarketTopAppBar
import com.dowpro.library_design_system.composables.spaces.PrimaryScrollingColumn
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StockDetailsActivity : ComponentActivity() {

    companion object {
        const val TICKER = "TICKER"
    }

    private val viewModel: StockViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val state by viewModel.screenState.observeAsState(initial = StockUiState())
            MarketScaffold {
                PrimaryScrollingColumn {
                    when (state.screenState) {
                        UiState.LOADING -> ShowLoading()
                        UiState.SUCCESS -> ShowContent(state.domainStockDetails!!) // TODO: resolve problem
                        UiState.ERROR -> ShowError(state.exception!!)
                    }
                }
            }
        }
        intent.getStringExtra(TICKER)?.let { ticker ->
            viewModel.getStock(ticker)
        }
    }

    @Composable
    fun ShowLoading() {
        LoadingSurface()
    }

    // Since Compose 1.2.0 it is required to use padding parameter, passed into Scaffold content composable.
    // You should apply it to the top most container/view in content.
    // https://stackoverflow.com/questions/72084865/content-padding-parameter-it-is-not-used
    @Composable
    fun MarketScaffold(f: @Composable (PaddingValues) -> Unit) {
        Scaffold(
            topBar = {
                MarketTopAppBar(stringResource(R.string.appbar_title_stock_details), true) {
                    finish()
                }
            }, content = {
                f.invoke(it)
            })
    }

    @Composable
    fun ShowContent(domainStockDetails: DomainStockDetails) {
        StockSurface(domainStockDetails.ticker, domainStockDetails.stock, domainStockDetails.companyOverview)
        domainStockDetails.incomeStatement?.annualReports?.let { annualReports ->
            AnnualReportLazyColumn(annualReports = annualReports) {

            }
        }
    }

    @Composable
    fun ShowError(throwable: Throwable) {
        MarketAlertDialog(throwable,
            {
                intent.getStringExtra(TICKER)?.let { ticker ->
                    viewModel.getStock(ticker)
                }
            }, {
                finish()
            }
        )
    }
}
