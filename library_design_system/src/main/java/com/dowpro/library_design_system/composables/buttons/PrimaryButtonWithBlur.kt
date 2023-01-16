package com.dowpro.library_design_system.composables.buttons

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.unit.dp
import com.dowpro.library_design_system.composables.spaces.MyModifier

@Composable
fun PrimaryButtonWithBlur(text: String, enabled: Boolean = true, onClick: () -> Unit) {
    Column {
        Box(
            modifier = Modifier
                .height(16.dp)
                .blur(30.dp, edgeTreatment = BlurredEdgeTreatment.Unbounded)
        ) {
            Spacer(modifier = Modifier.height(40.dp))
        }
        Button(onClick,
            modifier = MyModifier(),
            enabled = enabled,
        ) {
            Text(text.uppercase())
        }
    }
}