package com.dowpro.library_design_system.composables.buttons

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.dowpro.library_design_system.composables.spaces.MyModifier

@Composable
fun PrimaryRoundedButton(text: String, isEnabled: Boolean = true, onClick: () -> Unit) {
    Button(onClick,
        shape = RoundedCornerShape(50),
        modifier = MyModifier(),
        enabled = isEnabled,
    ) {
        Text(text.uppercase())
    }
}
