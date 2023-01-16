package com.dowpro.library_design_system.composables.text

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import com.dowpro.library_design_system.composables.spaces.MyModifier

@Composable
fun PrimaryText(text: String, modifier: Modifier = Modifier, style: TextStyle = TextStyle.Default) {
    Text(text = text, modifier = MyModifier().then(modifier), style = style)
}