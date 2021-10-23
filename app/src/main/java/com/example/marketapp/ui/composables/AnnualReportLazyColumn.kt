package com.example.marketapp.ui.composables

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
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
        LazyColumn(modifier = Modifier.fillMaxSize(1F)) {
            items(annualReports) { annualReport ->
                AnnualReportRow(annualReport, clickListener)
            }
        }
    }
}

// Credit: https://stackoverflow.com/questions/41859525/how-to-go-about-formatting-1200-to-1-2k-in-android-studio
fun String.getFormatedNumber(): String = if (startsWith("-")) {
    "-" + drop(1).getFormattedInner()
} else {
    getFormattedInner()
}

fun String.getFormattedInner(): String {
    if (this.toDouble() < 1000) return "" + this
    val exp = (ln(this.toDouble()) / ln(1000.0)).toInt()
    return String.format("%.1f %c", this.toDouble() / 1000.0.pow(exp.toDouble()), "kMBT"[exp - 1])
}

@Composable
fun AnnualReportRow(annualReport: AnnualReport, clickListener: (AnnualReport) -> Unit) {
    // https://developer.android.com/reference/kotlin/androidx/compose/material/icons/Icons
    Row {
        var isExpanded by remember { mutableStateOf(false) }
        val surfaceColor: Color by animateColorAsState(
            if (isExpanded) MaterialTheme.colors.primary else MaterialTheme.colors.surface,
        )
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
                        text = "Net income: ${annualReport.netIncome.getFormatedNumber()} ${annualReport.reportedCurrency}",
                        modifier = Modifier.padding(all = 4.dp),
                        style = MaterialTheme.typography.body2,
                        color = if (annualReport.netIncome.toDouble() < 0) Color.Red else Color.Black
                    )

                    Text(
                        text = "Gross profit: ${annualReport.grossProfit.getFormatedNumber()} ${annualReport.reportedCurrency}",
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