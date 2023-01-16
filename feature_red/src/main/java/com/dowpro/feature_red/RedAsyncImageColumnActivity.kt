package com.dowpro.feature_red

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Help
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.Settings
import com.dowpro.library_design_system.composables.cards.AsyncImageCardContent
import com.dowpro.library_design_system.composables.cards.AsyncImageLazyColumn
import com.dowpro.library_design_system.composables.cards.IconCardLazyRow
import com.dowpro.library_design_system.composables.cards.RowContent
import com.dowpro.library_design_system.composables.scaffolds.MyScaffold
import com.dowpro.library_design_system.theme.MarketAppTheme

class RedAsyncImageColumnActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MarketAppTheme {
                MyScaffold(R.string.red_title, true) {
                    AsyncImageLazyColumn(contents = listOf(
                        AsyncImageCardContent(
                            url = "https://developer.android.com/static/images/jetpack/compose/graphics-sourceimagesmall.jpg",
                            contentDescription = R.string.content_description_help,
                            title = "Title",
                            body = "There are many variations of passages of Lorem Ipsum available, "
                        ),
                        AsyncImageCardContent(
                            url = "https://developer.android.com/static/images/jetpack/compose/graphics-sourceimageland.jpg",
                            contentDescription = R.string.content_description_help,
                            title = "Title",
                            body = "but the majority have suffered alteration in some form, by injected humour, or randomised words "
                        ),
                        AsyncImageCardContent(
                            url = "https://developer.android.com/static/images/jetpack/compose/graphics-sourceimagesmall.jpg",
                            contentDescription = R.string.content_description_help,
                            title = "Title",
                            body = "which don't look even slightly believable."
                        ),
                        AsyncImageCardContent(
                            url = "https://developer.android.com/static/images/jetpack/compose/graphics-sourceimageland.jpg",
                            contentDescription = R.string.content_description_help,
                            title = "Title",
                            body = "If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text."
                        ),
                        AsyncImageCardContent(
                            url = "https://developer.android.com/static/images/jetpack/compose/graphics-sourceimageland.jpg",
                            contentDescription = R.string.content_description_help,
                            title = "Title",
                            body = "If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text."
                        ),
                        AsyncImageCardContent(
                            url = "https://developer.android.com/static/images/jetpack/compose/graphics-sourceimageland.jpg",
                            contentDescription = R.string.content_description_help,
                            title = "Title",
                            body = "If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text."
                        ),
                        AsyncImageCardContent(
                            url = "https://developer.android.com/static/images/jetpack/compose/graphics-sourceimageland.jpg",
                            contentDescription = R.string.content_description_help,
                            title = "Title",
                            body = "If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text."
                        ),
                        AsyncImageCardContent(
                            url = "https://developer.android.com/static/images/jetpack/compose/graphics-sourceimageland.jpg",
                            contentDescription = R.string.content_description_help,
                            title = "Title",
                            body = "If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text."
                        ),
                        AsyncImageCardContent(
                            url = "https://developer.android.com/static/images/jetpack/compose/graphics-sourceimageland.jpg",
                            contentDescription = R.string.content_description_help,
                            title = "Title",
                            body = "If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text."
                        ),
                        AsyncImageCardContent(
                            url = "https://developer.android.com/static/images/jetpack/compose/graphics-sourceimageland.jpg",
                            contentDescription = R.string.content_description_help,
                            title = "Title",
                            body = "If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text."
                        ),
                        AsyncImageCardContent(
                            url = "https://developer.android.com/static/images/jetpack/compose/graphics-sourceimageland.jpg",
                            contentDescription = R.string.content_description_help,
                            title = "Title",
                            body = "If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text."
                        ),
                    ))
                }
            }
        }
    }
}