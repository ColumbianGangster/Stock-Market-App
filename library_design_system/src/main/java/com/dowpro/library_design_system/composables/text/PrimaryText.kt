package com.dowpro.library_design_system.composables.text

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.dowpro.library_design_system.composables.spaces.MyModifier

@Composable
fun PrimaryText(text: String, modifier: Modifier = Modifier) {
    Text(text = text, modifier = MyModifier().then(modifier))
}