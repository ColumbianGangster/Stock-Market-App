package com.example.marketapp.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun MarketAlertDialog(throwable: Throwable, retry: () -> Unit, dismiss: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ErrorAlertDialog(exception = throwable, retry, dismiss)
    }
}

@Composable
fun ErrorAlertDialog(exception: Throwable, retry: () -> Unit, dismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = {
        },
        title = {
            Text("Something went wrong")
        },
        confirmButton = {
            TextButton(
                onClick = {
                    retry.invoke()
                },
            ) {
                Text("Retry")
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    dismiss.invoke()
                },
            ) {
                Text("Close")
            }
        },
        text = {
            Text(exception.message.toString())
        },
    )
}