package com.dowpro.feature_red

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dowpro.library_design_system.composables.cards.HalfScreenBox
import com.dowpro.library_design_system.composables.cards.ReadableImageCard
import com.dowpro.library_design_system.composables.scaffolds.TopAppBarScaffold
import com.dowpro.library_design_system.theme.AppMaterialTheme

class RedReadableImageCardActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppMaterialTheme {
                TopAppBarScaffold(R.string.red_title, true) {
                    Column (modifier = Modifier.fillMaxWidth()) {
                        ReadableImageCard(content = MockCreator.readableImageCardContent(), shape = RoundedCornerShape(bottomEnd = 16.dp, bottomStart = 16.dp, topStart = 0.dp, topEnd = 0.dp))
                        Row {
                            HalfScreenBox(modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 8.dp)) {
                                ReadableImageCard(content = MockCreator.readableImageCardContent())
                            }
                            ReadableImageCard(content = MockCreator.readableImageCardOtherContent(), modifier = Modifier.padding(top = 16.dp, end = 16.dp, start = 8.dp))
                        }
                        ReadableImageCard(content = MockCreator.readableImageCardUnreadableContent(), shape = RoundedCornerShape(16.dp), readable = false)
                    }
                }
            }
        }
    }
}
