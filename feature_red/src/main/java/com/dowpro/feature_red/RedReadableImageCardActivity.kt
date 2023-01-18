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
import com.dowpro.library_design_system.composables.cards.ReadableImageCardContent
import com.dowpro.library_design_system.composables.scaffolds.TopAppBarScaffold
import com.dowpro.library_design_system.theme.AppMaterialTheme

class RedReadableImageCardActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val content = ReadableImageCardContent(
            url = "https://images.pexels.com/photos/104827/cat-pet-animal-domestic-104827.jpeg",
            contentDescription = "Animation",
            body =   "This text should be visible on all images")

        val otherContent = ReadableImageCardContent(
            url = "https://i.kym-cdn.com/photos/images/newsfeed/000/959/452/436.jpg",
            contentDescription = "Animation",
            body =   "This text should be visible on all images")

        val unreadableContent = ReadableImageCardContent(
            url = "https://images.pexels.com/photos/104827/cat-pet-animal-domestic-104827.jpeg",
            contentDescription = "Animation",
            body =   "Can you read this? If you can then you have the eyes of an eagle.")

        setContent {
            AppMaterialTheme {
                TopAppBarScaffold(R.string.red_title, true) {
                    Column (modifier = Modifier.fillMaxWidth()) {
                        ReadableImageCard(content = content, shape = RoundedCornerShape(bottomEnd = 16.dp, bottomStart = 16.dp, topStart = 0.dp, topEnd = 0.dp))
                        Row {
                            HalfScreenBox(modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 8.dp)) {
                                ReadableImageCard(content = content)
                            }
                            ReadableImageCard(content = otherContent, modifier = Modifier.padding(top = 16.dp, end = 16.dp, start = 8.dp))
                        }
                        ReadableImageCard(content = unreadableContent, shape = RoundedCornerShape(16.dp), readable = false)
                    }
                }
            }
        }
    }
}
