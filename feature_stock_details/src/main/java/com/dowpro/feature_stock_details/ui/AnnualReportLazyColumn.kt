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

@Composable
fun AnnualReportLazyColumn(
    annualReports: List<com.dowpro.library_network.AnnualReport>,
    clickListener: (com.dowpro.library_network.AnnualReport) -> Unit
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
        Spacer(modifier = Modifier.height(4.dp))
        LazyColumn {
            items(annualReports) { annualReport ->
                AnnualReportRow(annualReport, clickListener)
            }
        }
    }
}
