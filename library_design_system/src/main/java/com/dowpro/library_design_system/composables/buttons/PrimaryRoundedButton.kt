package com.dowpro.library_design_system.composables.buttons

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.dowpro.library_design_system.composables.spaces.MyModifier

@Composable
fun PrimaryRoundedButton(text: String, modifier: Modifier = Modifier, isEnabled: Boolean = true, onClick: () -> Unit) {
    Button(onClick,
        shape = RoundedCornerShape(50),
        modifier = MyModifier().then(modifier),
        enabled = isEnabled,
    ) {
        Text(text.uppercase())
    }
}
