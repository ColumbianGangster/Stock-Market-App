package com.dowpro.library_design_system.composables.buttons

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.dowpro.library_design_system.composables.spaces.MyModifier

@Composable
fun PrimaryButton(text: String, enabled: Boolean = true, onClick: () -> Unit) {
    Button(onClick,
        modifier = MyModifier(),
        enabled = enabled,
    ) {
        Text(text.uppercase())
    }
}
