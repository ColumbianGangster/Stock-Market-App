package com.dowpro.library_design_system.composables.buttons

import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dowpro.library_design_system.composables.spaces.MyModifier
import com.dowpro.library_design_system.theme.PaddingTheme

@Composable
fun PrimaryButton(text: String, enabled: Boolean = true, onClick: () -> Unit) {
    Button(onClick,
        modifier = MyModifier(),
        enabled = enabled,
    ) {
        Text(text.uppercase())
    }
}