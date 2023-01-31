package com.dowpro.marketapp.ui.main.screens

import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dowpro.feature_sentiments.SentimentsActivity
import com.dowpro.library_design_system.composables.buttons.PrimaryRoundedButton
import com.dowpro.library_design_system.composables.cards.*
import com.dowpro.library_design_system.composables.scaffolds.MyStickyNoToolbarScaffold
import com.dowpro.library_design_system.composables.spaces.LargeSpacer
import com.dowpro.marketapp.R
import com.dowpro.marketapp.data.MockCreator

@Composable
fun FeatureScreen(paddingValues: PaddingValues = PaddingValues()) {
    MyStickyNoToolbarScaffold(
        content = {
            LazyColumn {
                item {
                    Column(
                        modifier = Modifier
                            .padding(paddingValues)
                            .fillMaxWidth()
                    ) {
                        ReadableImageCard(content = MockCreator.featureScreenMainContentBlock(), shape = RoundedCornerShape(bottomEnd = 16.dp, bottomStart = 16.dp, topStart = 0.dp, topEnd = 0.dp))
                        Row {
                            HalfScreenBox(modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 8.dp)) {
                                ReadableImageCard(content = MockCreator.featureScreenFirstContentBlock())
                            }
                            ReadableImageCard(content = MockCreator.featureScreenSecondContentBlock(), modifier = Modifier.padding(top = 16.dp, end = 16.dp, start = 8.dp))
                        }
                        SimpleTextCard(modifier = Modifier.padding(top = 16.dp), content = MockCreator.featureScreenSupportBlock())
                    }
                }
                items(MockCreator.featureScreenList()) { content ->
                    SimpleTextCard(content)
                }
                item {
                    LargeSpacer()
                }
            }
        },
        stickyContent = {
            val context = LocalContext.current
            PrimaryRoundedButton(stringResource(R.string.feature_primary_cta)) {
                context.startActivity(Intent(context, SentimentsActivity::class.java))
            }
        })
}

@Preview(showBackground = true)
@Composable
fun MoviesScreenPreview() {
    FeatureScreen()
}