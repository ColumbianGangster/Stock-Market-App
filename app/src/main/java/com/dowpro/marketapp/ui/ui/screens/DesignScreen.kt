package com.dowpro.marketapp.ui.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dowpro.library_design_system.composables.buttons.PrimaryButton
import com.dowpro.library_design_system.composables.buttons.PrimaryRoundedButton
import com.dowpro.library_design_system.composables.spaces.MyModifier
import com.dowpro.library_design_system.theme.PaddingTheme
import com.dowpro.library_design_system.theme.Typography
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

@Composable
/*
  .verticalScroll(rememberScrollState()) is a compose/gesture.
 */
fun DesignScreen(paddingValues: PaddingValues = PaddingValues()) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "Design",
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            style = Typography.h1,
        )
        Text(
            text = "Design",
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            style = Typography.h2,
        )
        Text(
            text = "Design",
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            style = Typography.h3,
        )
        Text(
            text = "Design",
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            style = Typography.h4,
        )
        Text(
            text = "Design",
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            style = Typography.h5,
        )
        Text(
            text = "Design",
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            style = Typography.h6,
        )
        Text(
            text = "Typography.subtitle1",
            modifier = Modifier.align(Alignment.CenterHorizontally).padding(PaddingTheme),
            textAlign = TextAlign.Center,
            style = Typography.subtitle1,
        )

        Text(
            text = "Typography.subtitle2",
            modifier = Modifier.align(Alignment.CenterHorizontally).padding(PaddingTheme),
            textAlign = TextAlign.Center,
            style = Typography.subtitle2,
        )

        Text(
            text = "Typography.body1",
            modifier = Modifier.align(Alignment.CenterHorizontally).padding(PaddingTheme),
            textAlign = TextAlign.Center,
            style = Typography.body1,
        )
        Text(
            text = "Typography.body2",
            modifier = Modifier.align(Alignment.CenterHorizontally).padding(PaddingTheme),
            textAlign = TextAlign.Center,
            style = Typography.body2,
        )
        Text(
            text = "Typography.overline",
            modifier = Modifier.align(Alignment.CenterHorizontally).padding(PaddingTheme),
            textAlign = TextAlign.Center,
            style = Typography.overline,
        )
        Text(
            text = "Typography.caption",
            modifier = Modifier.align(Alignment.CenterHorizontally).padding(PaddingTheme),
            textAlign = TextAlign.Center,
            style = Typography.caption,
        )

        // https://uxdesign.cc/make-sense-of-rounded-corners-on-buttons-dfc8e13ea7f7

        Buttons(isEnabled = true)
        Text(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
            modifier = Modifier.align(Alignment.Start).padding(PaddingTheme),
            textAlign = TextAlign.Justify,
            style = Typography.body2,
        )

        Text(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
            modifier = Modifier.align(Alignment.Start).padding(PaddingTheme),
            textAlign = TextAlign.Center,
            style = Typography.body2,
        )

        Buttons(isEnabled = false)

        Text(
            text = "Typography.body1 FontWeight.Bold",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.Start).padding(PaddingTheme),
            textAlign = TextAlign.Center,
            style = Typography.body1,
        )
        Text(
            text = NumberFormat.getCurrencyInstance().format(10000.toBigDecimal()),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.Start).padding(PaddingTheme),
            textAlign = TextAlign.Center,
            style = Typography.body1,
        )
        Text(
            text = NumberFormat.getCurrencyInstance().format(-10000.toBigDecimal()),
            modifier = Modifier.align(Alignment.Start).padding(PaddingTheme),
            textAlign = TextAlign.Center,
            style = Typography.body1,
        )
        Text(
            text = NumberFormat.getCurrencyInstance().format(0.0.toBigDecimal()),
            modifier = Modifier.align(Alignment.Start).padding(PaddingTheme),
            textAlign = TextAlign.Center,
            style = Typography.body1,
        )
        Text(
            text = NumberFormat.getCurrencyInstance().format(1234.5.toBigDecimal()),
            modifier = Modifier.align(Alignment.End).padding(PaddingTheme),
            textAlign = TextAlign.Center,
            style = Typography.h5,
        )
        Text(
            text = NumberFormat.getCurrencyInstance().format(-0.0.toBigDecimal()),
            modifier = Modifier.align(Alignment.End).padding(PaddingTheme),
            textAlign = TextAlign.Center,
            style = Typography.body1,
        )
        val annotatedString = buildAnnotatedString {
            append("Money received: ")
            withStyle(style = SpanStyle(Color.Blue)) {
                append("+${NumberFormat.getCurrencyInstance().format(0.01.toBigDecimal())}")
            }
        }
        Text(
            text = annotatedString,
            modifier = Modifier.align(Alignment.End).padding(PaddingTheme),
            textAlign = TextAlign.Center,
            style = Typography.body1,
        )
        Text(
            text = "APR 30.0% FontWeight.Light",
            fontWeight = FontWeight.Light,
            modifier = Modifier.align(Alignment.Start).padding(PaddingTheme),
            textAlign = TextAlign.Center,
            style = Typography.body1,
        )

        Text(
            text = "Typography.body1",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.Start).padding(PaddingTheme),
            textAlign = TextAlign.Center,
            style = Typography.body1,
        )
//            text = "${DateMapper().getAbsoluteTime(LocalDateTime.now())}",
        Text(
            text = "LocalDateTime.now(): "+"${LocalDateTime.now()}",
            modifier = Modifier.align(Alignment.Start).padding(PaddingTheme),
            textAlign = TextAlign.Start,
            style = Typography.body1,
        )
        Text(
            text = "DateTimeFormatter.ISO_DATE: "+LocalDateTime.now().format(DateTimeFormatter.ISO_DATE),
            modifier = Modifier.align(Alignment.Start).padding(PaddingTheme),
            textAlign = TextAlign.Start,
            style = Typography.body1,
        )
        Text(
            text = "DateTimeFormatter.ISO_LOCAL_DATE_TIME: "+LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
            modifier = Modifier.align(Alignment.Start).padding(PaddingTheme),
            textAlign = TextAlign.Start,
            style = Typography.body1,
        )
        Text(
            text = "DateTimeFormatter.ISO_WEEK_DATE: "+LocalDateTime.now().format(DateTimeFormatter.ISO_WEEK_DATE),
            modifier = Modifier.align(Alignment.Start).padding(PaddingTheme),
            textAlign = TextAlign.Start,
            style = Typography.body1,
        )

        Spacer(modifier = Modifier.height(90.dp))
    }
}

const val DATE_OF_BIRTH_FORMAT = "dd/MM/yyyy"
const val FRIENDLY_DATE_FORMAT = "dd MMMM yyyy"
const val CASUAL_DATE_FORMAT = "d MMMM yyyy"
const val NODE_DATE_OF_BIRTH_FORMAT = "yyyy-MM-dd"

fun String.convertFormat(formatA: String, formatB: String): String {
    val formatter = SimpleDateFormat(formatA, Locale.getDefault())
    val date = try {
        formatter.parse(this)
    } catch (e: Exception) {
        Date()
    }
    val bFormatter = SimpleDateFormat(formatB, Locale.getDefault())
    return bFormatter.format(date)

}

@Composable
/*
 It needs to be an extension function of ColumnScope for .align(Alignment.CenterHorizontally).
 */
fun ColumnScope.Buttons(isEnabled: Boolean) {
    PrimaryButton(text = "I'm a Button",
        onClick = { /* Do something! */ },
        enabled = isEnabled,
    )

    Button(onClick = { /* Do something! */ },
        modifier = MyModifier(),
        enabled = isEnabled,
    ) {
        Icon(
            Icons.Filled.Favorite,
            contentDescription = null,
            modifier = Modifier.size(ButtonDefaults.IconSize),
        )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text("I'm an Icon Button".uppercase())
    }
    PrimaryRoundedButton(text = "I'm an Rounded Button", modifier = Modifier, isEnabled = isEnabled, {})

    OutlinedButton(onClick = { /* Do something! */ },
        modifier = MyModifier(),
        enabled = isEnabled,
    ) {
        Text("I'm an Outlined Button".uppercase())
    }
    OutlinedButton(onClick = { /* Do something! */ },
        modifier = MyModifier(),
        enabled = isEnabled,
    ) {
        Icon(
            Icons.Filled.Favorite,
            contentDescription = null,
            modifier = Modifier.size(ButtonDefaults.IconSize),
        )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text("I'm an Outlined Icon Button".uppercase())
    }

    OutlinedButton(onClick = { /* Do something! */ },
        shape = RoundedCornerShape(50),
        modifier = MyModifier(),
        enabled = isEnabled,
    ) {
        Text("I'm an Rounded Outlined Button".uppercase())
    }

    Button(onClick = { /* Do something! */ },
        shape = RoundedCornerShape(50),
        modifier = Modifier.padding(PaddingTheme).align(Alignment.CenterHorizontally),
        enabled = isEnabled,
    ) {
        Text("Press me".uppercase())
    }

    TextButton(onClick = { /* Do something! */ },
        modifier = MyModifier(),
        enabled = isEnabled,
    ) {
        Text("I'm a text button".split(" ").joinToString(" ") { w -> w.replaceFirstChar { c ->  c.uppercaseChar() } })
    }
}

@Preview(showBackground = true)
@Composable
fun DesignScreenPreview() {
    DesignScreen()
}