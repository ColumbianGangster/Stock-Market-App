package com.dowpro.feature_stock_details.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.dowpro.feature_stock_details.R
import com.dowpro.library_design_system.composables.spaces.VerySmallSpacer
import com.dowpro.library_network.AnnualReport

@Composable
fun AnnualReportLazyColumn(
    annualReports: List<AnnualReport>,
    clickListener: (AnnualReport) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(all = 8.dp)
    ) {
        Text(
            text = stringResource(R.string.annual_report_header),
            color = MaterialTheme.colors.secondaryVariant,
            style = MaterialTheme.typography.subtitle2
        )
        Text(
            text = stringResource(R.string.annual_report_subheader),
        )
        VerySmallSpacer()
        LazyColumn {
            items(annualReports) { annualReport ->
                AnnualReportRow(annualReport, clickListener)
            }
        }
    }
}
