package com.dowpro.feature_stock_details.ui


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import com.dowpro.feature_stock_details.R
import com.dowpro.feature_stock_details.domain.DomainStockDetails
import com.dowpro.library_design_system.composables.dialogs.MarketAlertDialog
import com.dowpro.library_design_system.composables.loading.LoadingSurface
import com.dowpro.library_design_system.composables.scaffolds.TopAppBarScaffold
import com.dowpro.library_design_system.composables.spaces.PrimaryScrollingColumn
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StockDetailsActivity : ComponentActivity() {

    companion object {
        const val TICKER = "TICKER"
    }

    private val viewModel: StockDetailsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val state by viewModel.screenState.observeAsState(initial = StockUiState())
            TopAppBarScaffold(title = R.string.appbar_title_stock_details, true) {
                PrimaryScrollingColumn {
                    when (state.screenState) {
                        UiState.Loading -> LoadingSurface()
                        UiState.Success -> ShowContent(state.domainStockDetails)
                        UiState.Error -> ShowError(state.exception)
                    }
                }
            }
        }
        intent.getStringExtra(TICKER)?.let { ticker ->
            viewModel.getStock(ticker)
        }
    }

    // Since Compose 1.2.0 it is required to use padding parameter, passed into Scaffold content composable.
    // You should apply it to the top most container/view in content.
    // https://stackoverflow.com/questions/72084865/content-padding-parameter-it-is-not-used

    @Composable
    fun ShowContent(domainStockDetails: DomainStockDetails?) {
        domainStockDetails?.let {
            StockSurface(domainStockDetails.ticker, domainStockDetails.stock, domainStockDetails.companyOverview)
            domainStockDetails.incomeStatement?.annualReports?.let { annualReports ->
                AnnualReportLazyColumn(annualReports = annualReports) {

                }
            }
        }
    }

    @Composable
    fun ShowError(throwable: Throwable?) {
        MarketAlertDialog(
            throwable = throwable,
            retry = {
                intent.getStringExtra(TICKER)?.let { ticker ->
                    viewModel.getStock(ticker)
                }
            },
            dismiss = {
                finish()
            }
        )
    }
}
