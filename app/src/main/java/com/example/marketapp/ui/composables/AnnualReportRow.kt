package com.example.marketapp.ui.composables


import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.marketapp.data.AnnualReport

@Composable
fun AnnualReportRow(annualReport: AnnualReport, clickListener: (AnnualReport) -> Unit) {
    // https://developer.android.com/reference/kotlin/androidx/compose/material/icons/Icons
    Row {
        var isExpanded by remember { mutableStateOf(false) }
        Surface(
            shape = MaterialTheme.shapes.medium,
            elevation = 1.dp,
            modifier = Modifier
                .animateContentSize()
                .padding(1.dp)
                .fillMaxWidth()
        ) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    isExpanded = !isExpanded
                    clickListener.invoke(annualReport)
                }) {
                Column {
                    Text(
                        text = "Net income: ${annualReport.formattedNetIncome} ${annualReport.reportedCurrency}",
                        modifier = Modifier.padding(all = 4.dp),
                        style = MaterialTheme.typography.body2,
                        color = if (annualReport.netIncome.toDouble() < 0) Color.Red else Color.Black
                    )

                    Text(
                        text = "Gross profit: ${annualReport.formattedGrossProfit} ${annualReport.reportedCurrency}",
                        modifier = Modifier.padding(all = 4.dp),
                        style = MaterialTheme.typography.body2,
                        color = if (annualReport.grossProfit.toDouble() < 0) Color.Red else Color.Black
                    )
                }
                Text(
                    textAlign = TextAlign.End,
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = annualReport.fiscalDateEnding
                )
            }
        }
    }
}