package com.dowpro.marketapp.ui.main.screens


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.dowpro.library_core.domain.CurrencyMapper
import com.dowpro.library_design_system.composables.buttons.PrimaryButton
import com.dowpro.library_design_system.composables.buttons.PrimaryRoundedButton
import com.dowpro.library_design_system.composables.spaces.LargeSpacer
import com.dowpro.library_design_system.composables.spaces.MyModifier
import com.dowpro.library_design_system.composables.spaces.PrimaryScrollingColumn
import com.dowpro.library_design_system.theme.PaddingTheme
import com.dowpro.library_design_system.theme.Typography
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

@Composable // TODO: Migrate this to fully use the design library
fun DesignScreen() {
    PrimaryScrollingColumn {
        Text(
            text = "Design",
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            style = Typography.displayLarge,
        )
        Text(
            text = "Design",
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            style = Typography.displayMedium,
        )
        Text(
            text = "Design",
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            style = Typography.displaySmall,
        )
        Text(
            text = "Design",
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            style = Typography.headlineLarge,
        )
        Text(
            text = "Design",
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            style = Typography.headlineSmall,
        )
        Text(
            text = "Design",
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            style = Typography.titleSmall,
        )
        Text(
            text = "Typography.subtitle1",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(PaddingTheme),
            textAlign = TextAlign.Center,
            style = Typography.labelMedium,
        )

        Text(
            text = "Typography.subtitle2",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(PaddingTheme),
            textAlign = TextAlign.Center,
            style = Typography.labelSmall,
        )

        Text(
            text = "Typography.body1",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(PaddingTheme),
            textAlign = TextAlign.Center,
            style = Typography.bodyLarge,
        )
        Text(
            text = "Typography.body2",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(PaddingTheme),
            textAlign = TextAlign.Center,
            style = Typography.bodyMedium,
        )
//        No longer exists in m3
//        Text(
//            text = "Typography.overline",
//            modifier = Modifier
//                .align(Alignment.CenterHorizontally)
//                .padding(PaddingTheme),
//            textAlign = TextAlign.Center,
//            style = Typography.overline,
//        )
        Text(
            text = "Typography.caption",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(PaddingTheme),
            textAlign = TextAlign.Center,
            style = Typography.bodySmall,
        )

        // https://uxdesign.cc/make-sense-of-rounded-corners-on-buttons-dfc8e13ea7f7

        Buttons(isEnabled = true)
        Text(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
            modifier = Modifier
                .align(Alignment.Start)
                .padding(PaddingTheme),
            textAlign = TextAlign.Justify,
            style = Typography.bodyMedium,
        )

        Text(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
            modifier = Modifier
                .align(Alignment.Start)
                .padding(PaddingTheme),
            textAlign = TextAlign.Center,
            style = Typography.bodyMedium,
        )

        Buttons(isEnabled = false)

        Text(
            text = "Typography.body1 FontWeight.Bold",
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(PaddingTheme),
            textAlign = TextAlign.Center,
            style = Typography.bodyLarge,
        )
        Text(
            text = NumberFormat.getCurrencyInstance().format(10000.toBigDecimal()),
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(PaddingTheme),
            textAlign = TextAlign.Center,
            style = Typography.bodyLarge,
        )
        Text(
            text = NumberFormat.getCurrencyInstance().format(-10000.toBigDecimal()),
            modifier = Modifier
                .align(Alignment.Start)
                .padding(PaddingTheme),
            textAlign = TextAlign.Center,
            style = Typography.bodyLarge,
        )
        Text(
            text = NumberFormat.getCurrencyInstance().format(0.0.toBigDecimal()),
            modifier = Modifier
                .align(Alignment.Start)
                .padding(PaddingTheme),
            textAlign = TextAlign.Center,
            style = Typography.bodyLarge,
        )
        Text(
            text = NumberFormat.getCurrencyInstance().format(1234.5.toBigDecimal()),
            modifier = Modifier
                .align(Alignment.End)
                .padding(PaddingTheme),
            textAlign = TextAlign.Center,
            style = Typography.headlineSmall,
        )
        Text(
            text = NumberFormat.getCurrencyInstance().format(-0.0.toBigDecimal()),
            modifier = Modifier
                .align(Alignment.End)
                .padding(PaddingTheme),
            textAlign = TextAlign.Center,
            style = Typography.bodyLarge,
        )
        val annotatedString = buildAnnotatedString {
            append("Money received: ")
            withStyle(style = SpanStyle(Color.Blue)) {
                append("+${NumberFormat.getCurrencyInstance().format(0.01.toBigDecimal())}")
            }
        }
        Text(
            text = CurrencyMapper().toISO4217TransmissionFormat(12345.56.toBigDecimal()),
            modifier = Modifier
                .align(Alignment.End)
                .padding(PaddingTheme),
            textAlign = TextAlign.Center,
            style = Typography.headlineSmall,
        )

        Text(
            text = annotatedString,
            modifier = Modifier
                .align(Alignment.End)
                .padding(PaddingTheme),
            textAlign = TextAlign.Center,
            style = Typography.bodyLarge,
        )
        Text(
            text = "APR 30.0% FontWeight.Light",
            fontWeight = FontWeight.Light,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(PaddingTheme),
            textAlign = TextAlign.Center,
            style = Typography.bodyLarge,
        )

        Text(
            text = "Typography.body1",
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(PaddingTheme),
            textAlign = TextAlign.Center,
            style = Typography.bodyLarge,
        )

        Text(
            text = "LocalDateTime.now(): "+"${LocalDateTime.now()}",
            modifier = Modifier
                .align(Alignment.Start)
                .padding(PaddingTheme),
            textAlign = TextAlign.Start,
            style = Typography.bodyLarge,
        )

        Text(
            text = "DateTimeFormatter.ISO_DATE: "+LocalDateTime.now().format(DateTimeFormatter.ISO_DATE),
            modifier = Modifier
                .align(Alignment.Start)
                .padding(PaddingTheme),
            textAlign = TextAlign.Start,
            style = Typography.bodyLarge,
        )
        Text(
            text = "DateTimeFormatter.ISO_LOCAL_DATE_TIME: "+LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
            modifier = Modifier
                .align(Alignment.Start)
                .padding(PaddingTheme),
            textAlign = TextAlign.Start,
            style = Typography.bodyLarge,
        )
        Text(
            text = "DateTimeFormatter.ISO_WEEK_DATE: "+LocalDateTime.now().format(DateTimeFormatter.ISO_WEEK_DATE),
            modifier = Modifier
                .align(Alignment.Start)
                .padding(PaddingTheme),
            textAlign = TextAlign.Start,
            style = Typography.bodyLarge,
        )

        LargeSpacer()
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
        modifier = Modifier
            .padding(PaddingTheme)
            .align(Alignment.CenterHorizontally),
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