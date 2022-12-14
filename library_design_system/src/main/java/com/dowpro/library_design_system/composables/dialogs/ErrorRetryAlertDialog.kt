package com.dowpro.library_design_system.composables.dialogs

import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.dowpro.library_design_system.R

@Composable
fun ErrorRetryAlertDialog(exception: Throwable, retry: () -> Unit, dismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = {
        },
        title = {
            Text(stringResource(R.string.something_went_wrong))
        },
        confirmButton = {
            TextButton(
                onClick = {
                    retry.invoke()
                },
            ) {
                Text(stringResource(R.string.retry))
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    dismiss.invoke()
                },
            ) {
                Text(stringResource(R.string.close))
            }
        },
        text = {
            Text(exception.message.toString())
        },
    )
}