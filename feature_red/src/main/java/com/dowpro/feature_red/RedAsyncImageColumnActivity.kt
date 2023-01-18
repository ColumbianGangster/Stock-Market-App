package com.dowpro.feature_red

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.dowpro.library_design_system.composables.cards.AsyncImageCardContent
import com.dowpro.library_design_system.composables.cards.AsyncImageLazyColumn
import com.dowpro.library_design_system.composables.scaffolds.TopAppBarScaffold
import com.dowpro.library_design_system.theme.AppMaterialTheme

class RedAsyncImageColumnActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppMaterialTheme {
                TopAppBarScaffold(R.string.red_title, true) {
                    AsyncImageLazyColumn(contents = listOf(
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
                    ))
                }
            }
        }
    }
}