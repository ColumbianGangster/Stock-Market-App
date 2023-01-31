package com.dowpro.feature_red.data

import com.dowpro.feature_red.R
import com.dowpro.library_design_system.composables.cards.AsyncImageCardContent
import com.dowpro.library_design_system.composables.cards.ReadableImageCardContent
import com.dowpro.library_design_system.composables.cards.RedContent

class MockCreator {
    companion object {
        fun asyncImageCardContentList() = listOf(
            AsyncImageCardContent(
                url = "https://developer.android.com/static/images/jetpack/compose/graphics-sourceimagesmall.jpg",
                contentDescription = R.string.content_description_help,
                title = "Title",
                body = "There are many variations of passages of Lorem Ipsum available, ",
                online = true,
            ),
            AsyncImageCardContent(
                url = "https://developer.android.com/static/images/jetpack/compose/graphics-sourceimageland.jpg",
                contentDescription = R.string.content_description_help,
                title = "Title",
                body = "but the majority have suffered alteration in some form, by injected humour, or randomised words ",
                online = false,
            ),
            AsyncImageCardContent(
                url = "https://developer.android.com/static/images/jetpack/compose/graphics-sourceimagesmall.jpg",
                contentDescription = R.string.content_description_help,
                title = "Title",
                body = "which don't look even slightly believable.",
                online = false,
            ),
            AsyncImageCardContent(
                url = "https://developer.android.com/static/images/jetpack/compose/graphics-sourceimageland.jpg",
                contentDescription = R.string.content_description_help,
                title = "Title",
                body = "If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text.",
                online = false,
            ),
            AsyncImageCardContent(
                url = "https://developer.android.com/static/images/jetpack/compose/graphics-sourceimageland.jpg",
                contentDescription = R.string.content_description_help,
                title = "Title",
                body = "If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text.",
                online = true,
            ),
            AsyncImageCardContent(
                url = "https://developer.android.com/static/images/jetpack/compose/graphics-sourceimageland.jpg",
                contentDescription = R.string.content_description_help,
                title = "Title",
                body = "If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text.",
                online = false,
            ),
            AsyncImageCardContent(
                url = "https://developer.android.com/static/images/jetpack/compose/graphics-sourceimageland.jpg",
                contentDescription = R.string.content_description_help,
                title = "Title",
                body = "If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text.",
                online = true,
            ),
            AsyncImageCardContent(
                url = "https://developer.android.com/static/images/jetpack/compose/graphics-sourceimageland.jpg",
                contentDescription = R.string.content_description_help,
                title = "Title",
                body = "If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text.",
                online = false,
            ),
            AsyncImageCardContent(
                url = "https://developer.android.com/static/images/jetpack/compose/graphics-sourceimageland.jpg",
                contentDescription = R.string.content_description_help,
                title = "Title",
                body = "If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text.",
                online = true,
            ),
            AsyncImageCardContent(
                url = "https://developer.android.com/static/images/jetpack/compose/graphics-sourceimageland.jpg",
                contentDescription = R.string.content_description_help,
                title = "Title",
                body = "If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text.",
                online = false,
            ),
            AsyncImageCardContent(
                url = "https://developer.android.com/static/images/jetpack/compose/graphics-sourceimageland.jpg",
                contentDescription = R.string.content_description_help,
                title = "Title",
                body = "If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text.",
                online = false,
            ),
        )

        fun lazyColumnScreenContents(): List<RedContent> = listOf(
            RedContent("Diversification", "Diversification is a risk management strategy that mixes a wide variety of investments within a portfolio. A diversified portfolio contains a mix of distinct asset types and investment vehicles in an attempt at limiting exposure to any single asset or risk."),
            RedContent("Bond", "A bond is a fixed-income instrument that represents a loan made by an investor to a borrower (typically corporate or governmental)."),
            RedContent("Blockchain", "A blockchain is a distributed database or ledger that is shared among the nodes of a computer network."),
            RedContent("Exchange-Traded Fund (ETF)", "An exchange-traded fund (ETF) is a type of pooled investment security that operates much like a mutual fund. Typically, ETFs will track a particular index, sector, commodity, or other assets, but unlike mutual funds, ETFs can be purchased or sold on a stock exchange the same way that a regular stock can."),
            RedContent("Dividend Yield", "The dividend yield, expressed as a percentage, is a financial ratio (dividend/price) that shows how much a company pays out in dividends each year relative to its stock price."),
            RedContent("Financial Statement", "Financial statements are written records that convey the business activities and the financial performance of a company."),
            RedContent("Opportunity Cost", "Opportunity costs represent the potential benefits that an individual, investor, or business misses out on when choosing one alternative over another."),
        )

        fun readableImageCardContent(): ReadableImageCardContent = ReadableImageCardContent(
            url = "https://images.pexels.com/photos/104827/cat-pet-animal-domestic-104827.jpeg",
            contentDescription = "Animation",
            body =   "This text should be visible on all images")

        fun readableImageCardOtherContent(): ReadableImageCardContent = ReadableImageCardContent(
            url = "https://i.kym-cdn.com/photos/images/newsfeed/000/959/452/436.jpg",
            contentDescription = "Animation",
            body =   "This text should be visible on all images")

        fun readableImageCardUnreadableContent(): ReadableImageCardContent = ReadableImageCardContent(
            url = "https://images.pexels.com/photos/104827/cat-pet-animal-domestic-104827.jpeg",
            contentDescription = "Animation",
            body =   "Can you read this? If you can then you have the eyes of an eagle.")

        fun stickyButtonListContent(): List<RedContent> = listOf(
            RedContent("Diversification", "Diversification is a risk management strategy that mixes a wide variety of investments within a portfolio. A diversified portfolio contains a mix of distinct asset types and investment vehicles in an attempt at limiting exposure to any single asset or risk."),
            RedContent("Bond", "A bond is a fixed-income instrument that represents a loan made by an investor to a borrower (typically corporate or governmental)."),
            RedContent("Blockchain", "A blockchain is a distributed database or ledger that is shared among the nodes of a computer network."),
            RedContent("Exchange-Traded Fund (ETF)", "An exchange-traded fund (ETF) is a type of pooled investment security that operates much like a mutual fund. Typically, ETFs will track a particular index, sector, commodity, or other assets, but unlike mutual funds, ETFs can be purchased or sold on a stock exchange the same way that a regular stock can."),
            RedContent("Dividend Yield", "The dividend yield, expressed as a percentage, is a financial ratio (dividend/price) that shows how much a company pays out in dividends each year relative to its stock price."),
            RedContent("Financial Statement", "Financial statements are written records that convey the business activities and the financial performance of a company."),
            RedContent("Opportunity Cost", "Opportunity costs represent the potential benefits that an individual, investor, or business misses out on when choosing one alternative over another."),
            RedContent("Diversification", "Diversification is a risk management strategy that mixes a wide variety of investments within a portfolio. A diversified portfolio contains a mix of distinct asset types and investment vehicles in an attempt at limiting exposure to any single asset or risk."),
            RedContent("Bond", "A bond is a fixed-income instrument that represents a loan made by an investor to a borrower (typically corporate or governmental)."),
            RedContent("Blockchain", "A blockchain is a distributed database or ledger that is shared among the nodes of a computer network."),
            RedContent("Exchange-Traded Fund (ETF)", "An exchange-traded fund (ETF) is a type of pooled investment security that operates much like a mutual fund. Typically, ETFs will track a particular index, sector, commodity, or other assets, but unlike mutual funds, ETFs can be purchased or sold on a stock exchange the same way that a regular stock can."),
            RedContent("Dividend Yield", "The dividend yield, expressed as a percentage, is a financial ratio (dividend/price) that shows how much a company pays out in dividends each year relative to its stock price."),
            RedContent("Financial Statement", "Financial statements are written records that convey the business activities and the financial performance of a company."),
            RedContent("Opportunity Cost", "Opportunity costs represent the potential benefits that an individual, investor, or business misses out on when choosing one alternative over another."),
            RedContent("Diversification", "Diversification is a risk management strategy that mixes a wide variety of investments within a portfolio. A diversified portfolio contains a mix of distinct asset types and investment vehicles in an attempt at limiting exposure to any single asset or risk."),
            RedContent("Bond", "A bond is a fixed-income instrument that represents a loan made by an investor to a borrower (typically corporate or governmental)."),
            RedContent("Blockchain", "A blockchain is a distributed database or ledger that is shared among the nodes of a computer network."),
            RedContent("Exchange-Traded Fund (ETF)", "An exchange-traded fund (ETF) is a type of pooled investment security that operates much like a mutual fund. Typically, ETFs will track a particular index, sector, commodity, or other assets, but unlike mutual funds, ETFs can be purchased or sold on a stock exchange the same way that a regular stock can."),
            RedContent("Dividend Yield", "The dividend yield, expressed as a percentage, is a financial ratio (dividend/price) that shows how much a company pays out in dividends each year relative to its stock price."),
            RedContent("Financial Statement", "Financial statements are written records that convey the business activities and the financial performance of a company."),
            RedContent("Opportunity Cost", "Opportunity costs represent the potential benefits that an individual, investor, or business misses out on when choosing one alternative over another."),
            RedContent("Diversification", "Diversification is a risk management strategy that mixes a wide variety of investments within a portfolio. A diversified portfolio contains a mix of distinct asset types and investment vehicles in an attempt at limiting exposure to any single asset or risk."),
            RedContent("Bond", "A bond is a fixed-income instrument that represents a loan made by an investor to a borrower (typically corporate or governmental)."),
            RedContent("Blockchain", "A blockchain is a distributed database or ledger that is shared among the nodes of a computer network."),
            RedContent("Exchange-Traded Fund (ETF)", "An exchange-traded fund (ETF) is a type of pooled investment security that operates much like a mutual fund. Typically, ETFs will track a particular index, sector, commodity, or other assets, but unlike mutual funds, ETFs can be purchased or sold on a stock exchange the same way that a regular stock can."),
            RedContent("Dividend Yield", "The dividend yield, expressed as a percentage, is a financial ratio (dividend/price) that shows how much a company pays out in dividends each year relative to its stock price."),
            RedContent("Financial Statement", "Financial statements are written records that convey the business activities and the financial performance of a company."),
            RedContent("Opportunity Cost", "Opportunity costs represent the potential benefits that an individual, investor, or business misses out on when choosing one alternative over another."),
        )
    }
}