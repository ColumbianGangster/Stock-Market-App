package com.dowpro.marketapp.data

import com.dowpro.library_design_system.composables.cards.ReadableImageCardContent
import com.dowpro.library_design_system.composables.cards.RedContent

class MockCreator {
    companion object {
        fun featureScreenMainContentBlock(): ReadableImageCardContent = ReadableImageCardContent(
            url = "https://cdn.mos.cms.futurecdn.net/YdFsXZgsagfMECEWk7qRTQ.jpg",
            contentDescription = "Stocks Image Header",
            body = "Analyse the market"
        )

        fun featureScreenFirstContentBlock(): ReadableImageCardContent = ReadableImageCardContent(
            url = "https://imageio.forbes.com/specials-images/imageserve/62bcbde698c96e32f370f112/Digitally-enhanced-shot-of-a-graph-showing-the-ups-and-downs-shares-on-the-stock/0x0.jpg",
            contentDescription = "Animation",
            body = "Economic Climate Report"
        )

        fun featureScreenSecondContentBlock(): ReadableImageCardContent = ReadableImageCardContent(
            url = "https://pixahive.com/wp-content/uploads/2020/10/Cryptocurrency-136688-pixahive.jpg",
            contentDescription = "Animation",
            body = "Blockchain Technology"
        )

        fun featureScreenSupportBlock(): RedContent =
            RedContent(title = "Key Takeaways", body = "Blockchain is the core database technology behind bitcoin and cryptocurrencies. \n\n" +
                    "Blockchain is now a major industry that has birthed several billion-dollar companies.\n\n" +
                    "One of the most successful blockchain companies is Coinbase, an online cryptocurrency broker with annual revenues of \$3.3 billion in 2022.")

        fun featureScreenList(): List<RedContent> = listOf(
            RedContent("Hello", "World"),
            RedContent("Hello", "World"),
            RedContent("Hello", "World"),
            RedContent("Hello", "World"),
            RedContent("Hello", "World")
        )
    }
}