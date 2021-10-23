package com.example.marketapp.ui.composables

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.marketapp.data.Stock

@Composable
fun StockSurface(stock: Stock) {
    Surface(modifier = Modifier
        .padding(all = 8.dp)
        .fillMaxWidth()) {
        Column {
            Text(
                text = stock.ticker,
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle2
            )
            Spacer(modifier = Modifier.height(4.dp))

            Surface(
                shape = MaterialTheme.shapes.medium,
                elevation = 1.dp,
                modifier = Modifier
                    .animateContentSize()
                    .padding(1.dp)
                    .fillMaxWidth()
            ) {
                Column {
                    Text(
                        text = "Name: ${stock.name}",
                        modifier = Modifier.padding(all = 4.dp),
                        style = MaterialTheme.typography.body2
                    )

                    Text(
                        text = "Price: ${stock.price.toString() + " " + stock.currency}",
                        modifier = Modifier.padding(all = 4.dp),
                        style = MaterialTheme.typography.body2
                    )

                    Text(
                        text = "Day Change: ${stock.day_change}",
                        modifier = Modifier.padding(all = 4.dp),
                        style = MaterialTheme.typography.body2
                    )

                    stock.`52_week_low`?.let {
                        Text(
                            text = "52 week low/high: ${stock.`52_week_low`} / ${stock.`52_week_high`}",
                            modifier = Modifier.padding(all = 4.dp),
                            style = MaterialTheme.typography.body2
                        )
                    }
                }
            }
        }
    }
}