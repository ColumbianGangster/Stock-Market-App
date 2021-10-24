package com.example.marketapp.ui.composables

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.marketapp.data.CompanyOverview
import com.example.marketapp.data.Stock

@OptIn(ExperimentalAnimationApi::class) // for AnimatedVisibility
@Composable
fun StockSurface(ticker: String, stock: Stock?, companyOverview: CompanyOverview?) {
    Surface(modifier = Modifier
        .padding(all = 8.dp)
        .fillMaxWidth()) {
        Column {
            Text(
                text = ticker,
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
                var visible by remember { mutableStateOf(false) }
                Column {
                    Text(
                        text = "Name: ${stock?.name}",
                        modifier = Modifier.padding(all = 4.dp),
                        style = MaterialTheme.typography.body2
                    )

                    Text(
                        text = "Price: ${stock?.price.toString() + " " + stock?.currency}",
                        modifier = Modifier.padding(all = 4.dp),
                        style = MaterialTheme.typography.body2
                    )

                    Text(
                        text = "Day Change: ${stock?.day_change}%",
                        modifier = Modifier.padding(all = 4.dp),
                        style = MaterialTheme.typography.body2
                    )

                    if (companyOverview?.Description != null ||
                        companyOverview?.Country != null ||
                        companyOverview?.Sector != null ||
                        companyOverview?.Industry != null) {

                        OutlinedButton(modifier = Modifier.fillMaxWidth().padding(all = 4.dp), onClick = { visible = !visible }) {
                            Text(text = "View Company Overview")
                        }
                    }

                    // Credit: https://developer.android.com/jetpack/compose/animation#animatedvisibility
                    AnimatedVisibility(
                        visible = visible,
                        enter = fadeIn(
                            // Overwrites the initial value of alpha to 0.4f for fade in, 0 by default
                            initialAlpha = 0.4f
                        ),
                        exit = fadeOut(
                            // Overwrites the default animation with tween
                            animationSpec = tween(durationMillis = 250)
                        )
                    ) {
                        Column {
                            Text(
                                text = "Description: ${companyOverview?.Description}",
                                modifier = Modifier.padding(all = 4.dp),
                                style = MaterialTheme.typography.body2
                            )
                            Text(
                                text = "Country: ${companyOverview?.Country}",
                                modifier = Modifier.padding(all = 4.dp),
                                style = MaterialTheme.typography.body2
                            )
                            Text(
                                text = "Sector: ${companyOverview?.Sector}",
                                modifier = Modifier.padding(all = 4.dp),
                                style = MaterialTheme.typography.body2
                            )
                            Text(
                                text = "Industry: ${companyOverview?.Industry}",
                                modifier = Modifier.padding(all = 4.dp),
                                style = MaterialTheme.typography.body2
                            )
                        }
                    }
                }
            }
        }
    }
}