package com.example.marketapp.ui.composables

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.marketapp.data.AnnualReport
import kotlin.math.ln
import kotlin.math.pow

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
            text = "Horizontal Financial Statement Analysis",
            color = MaterialTheme.colors.secondaryVariant,
            style = MaterialTheme.typography.subtitle2
        )
        Text(
            text = "Detect growth trends across different time periods",
        )
        Spacer(modifier = Modifier.height(4.dp))
        LazyColumn {
            items(annualReports) { annualReport ->
                AnnualReportRow(annualReport, clickListener)
            }
        }
    }
}
