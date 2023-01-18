package com.dowpro.feature_stock_details.ui

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.dowpro.feature_stock_details.R
import com.dowpro.library_design_system.composables.spaces.VerySmallSpacer
import com.dowpro.library_network.CompanyOverview
import com.dowpro.library_network.Stock

@Composable
@Deprecated(message = "Migrate to the design library module")
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
            VerySmallSpacer()

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
                        text = stringResource(R.string.stock_name, stock?.name?: ""),
                        modifier = Modifier.padding(all = 4.dp),
                        style = MaterialTheme.typography.body2
                    )

                    Text(
                        text = stringResource(R.string.stock_price, stock?.price?: 0.0, stock?.currency?: ""),
                        modifier = Modifier.padding(all = 4.dp),
                        style = MaterialTheme.typography.body2
                    )

                    Text(
                        text = stringResource(R.string.stock_day_change, stock?.day_change?: 0),
                        modifier = Modifier.padding(all = 4.dp),
                        style = MaterialTheme.typography.body2
                    )

                    if (companyOverview?.Description != null ||
                        companyOverview?.Country != null ||
                        companyOverview?.Sector != null ||
                        companyOverview?.Industry != null) {

                        OutlinedButton(modifier = Modifier.fillMaxWidth().padding(all = 4.dp), onClick = { visible = !visible }) {
                            Text(text = stringResource(R.string.stock_company_overview_cta))
                        }
                    }

                    // Credit: https://developer.android.com/jetpack/compose/animation#animatedvisibility
                    AnimatedVisibility(
                        visible = visible,
                        enter = fadeIn(
                            initialAlpha = 0.4f
                        ),
                        exit = fadeOut(
                            animationSpec = tween(durationMillis = 250)
                        )
                    ) {
                        Column {
                            Text(
                                text = stringResource(R.string.company_overview_description, companyOverview?.Description?: ""),
                                modifier = Modifier.padding(all = 4.dp),
                                style = MaterialTheme.typography.body2
                            )
                            Text(
                                text = stringResource(R.string.company_overview_country, companyOverview?.Country?: ""),
                                modifier = Modifier.padding(all = 4.dp),
                                style = MaterialTheme.typography.body2
                            )
                            Text(
                                text = stringResource(R.string.company_overview_sector, companyOverview?.Sector?: ""),
                                modifier = Modifier.padding(all = 4.dp),
                                style = MaterialTheme.typography.body2
                            )
                            Text(
                                text = stringResource(R.string.company_overview_industry, companyOverview?.Industry?: ""),
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