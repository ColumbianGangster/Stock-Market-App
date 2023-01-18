package com.dowpro.feature_red

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.dowpro.library_design_system.composables.cards.RedContent
import com.dowpro.library_design_system.composables.cards.RedLazyColumnScreen
import com.dowpro.library_design_system.composables.scaffolds.TopAppBarScaffold
import com.dowpro.library_design_system.theme.AppMaterialTheme

class RedListActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppMaterialTheme {
                TopAppBarScaffold(R.string.red_title, true) {
                    RedLazyColumnScreen(contents = listOf(
                        RedContent("Diversification", "Diversification is a risk management strategy that mixes a wide variety of investments within a portfolio. A diversified portfolio contains a mix of distinct asset types and investment vehicles in an attempt at limiting exposure to any single asset or risk."),
                        RedContent("Bond", "A bond is a fixed-income instrument that represents a loan made by an investor to a borrower (typically corporate or governmental)."),
                        RedContent("Blockchain", "A blockchain is a distributed database or ledger that is shared among the nodes of a computer network."),
                        RedContent("Exchange-Traded Fund (ETF)", "An exchange-traded fund (ETF) is a type of pooled investment security that operates much like a mutual fund. Typically, ETFs will track a particular index, sector, commodity, or other assets, but unlike mutual funds, ETFs can be purchased or sold on a stock exchange the same way that a regular stock can."),
                        RedContent("Dividend Yield", "The dividend yield, expressed as a percentage, is a financial ratio (dividend/price) that shows how much a company pays out in dividends each year relative to its stock price."),
                        RedContent("Financial Statement", "Financial statements are written records that convey the business activities and the financial performance of a company."),
                        RedContent("Opportunity Cost", "Opportunity costs represent the potential benefits that an individual, investor, or business misses out on when choosing one alternative over another."),

                    ))
                }
            }
        }
    }
}