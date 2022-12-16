package com.dowpro.library_design_system.composables.buttons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.dowpro.library_design_system.theme.PaddingTheme

@Composable
fun PrimaryRoundedButton(text: String, isEnabled: Boolean = true, onClick: () -> Unit) {
    Button(onClick,
        shape = RoundedCornerShape(50),
        modifier = Modifier.fillMaxWidth().padding(PaddingTheme),
        enabled = isEnabled,
    ) {
        Text(text.uppercase())
    }
}