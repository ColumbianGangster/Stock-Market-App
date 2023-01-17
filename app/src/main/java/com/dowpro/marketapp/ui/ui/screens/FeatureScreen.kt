package com.dowpro.marketapp.ui.ui.screens

import android.content.Intent
import android.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dowpro.feature_red.RedListActivity
import com.dowpro.feature_sentiments.SentimentsActivity
import com.dowpro.library_design_system.composables.buttons.PrimaryButton
import com.dowpro.library_design_system.composables.buttons.PrimaryRoundedButton
import com.dowpro.library_design_system.composables.cards.*
import com.dowpro.library_design_system.composables.scaffolds.MyStickyNoToolbarScaffold
import com.dowpro.library_design_system.composables.text.PrimaryText

@Composable
fun FeatureScreen(paddingValues: PaddingValues = PaddingValues()) {
    val mainContentBlock = ReadableImageCardContent(
        url = "https://cdn.mos.cms.futurecdn.net/YdFsXZgsagfMECEWk7qRTQ.jpg",
        contentDescription = "Stocks Image Header",
        body =   "Analyse the market")

    val secondContentBlock = ReadableImageCardContent(
        url = "https://imageio.forbes.com/specials-images/imageserve/62bcbde698c96e32f370f112/Digitally-enhanced-shot-of-a-graph-showing-the-ups-and-downs-shares-on-the-stock/0x0.jpg",
        contentDescription = "Animation",
        body =   "Economic Climate Report")

    val firstContentBlock = ReadableImageCardContent(
        url = "https://pixahive.com/wp-content/uploads/2020/10/Cryptocurrency-136688-pixahive.jpg",
        contentDescription = "Animation",
        body =   "Blockchain Technology")

    val contents = listOf(RedContent("Hello", "World"), RedContent("Hello", "World"), RedContent("Hello", "World"), RedContent("Hello", "World"), RedContent("Hello", "World"))

    MyStickyNoToolbarScaffold(
        content = {
            LazyColumn {
                item {
                    Column(
                        modifier = Modifier
                            .padding(paddingValues)
                            .fillMaxWidth()
                    ) {
                        ReadableImageCard(content = mainContentBlock, shape = RoundedCornerShape(bottomEnd = 16.dp, bottomStart = 16.dp, topStart = 0.dp, topEnd = 0.dp))
                        Row {
                            HalfScreenBox(modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 8.dp)) {
                                ReadableImageCard(content = firstContentBlock)
                            }
                            ReadableImageCard(content = secondContentBlock, modifier = Modifier.padding(top = 16.dp, end = 16.dp, start = 8.dp))
                        }
                        SimpleTextCard(modifier = Modifier.padding(top = 16.dp), content = RedContent(title = "Key Takeaways", body = "Blockchain is the core database technology behind bitcoin and cryptocurrencies. \n\n" +
                                "Blockchain is now a major industry that has birthed several billion-dollar companies.\n\n" +
                                "One of the most successful blockchain companies is Coinbase, an online cryptocurrency broker with annual revenues of \$3.3 billion in 2022."))
                    }
                }
                items(contents) { content ->
                    SimpleTextCard(content)
                }
                item {
                    Spacer(Modifier.size(90.dp))
                }
            }
        },
        stickyContent = {
            val context = LocalContext.current
            PrimaryRoundedButton("Make a move now") {
                context.startActivity(Intent(context, SentimentsActivity::class.java))
            }
        })
}

@Preview(showBackground = true)
@Composable
fun MoviesScreenPreview() {
    FeatureScreen()
}