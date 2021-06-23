package com.example.myfirstcompose.ui.util.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

sealed class ButtonColor {
    object Black: ButtonColor()
}

sealed class ButtonSize {
    object Small: ButtonSize()
    object Medium: ButtonSize()
    object Large: ButtonSize()
}

sealed class ButtonStyle {
    object Outline: ButtonStyle()
    object Fill: ButtonStyle()
}

@Composable
fun MyButton(
    modifier: Modifier = Modifier,
    buttonStyle: ButtonStyle = ButtonStyle.Fill,
    buttonColor: ButtonColor = ButtonColor.Black,
    buttonSize: ButtonSize = ButtonSize.Large,
    isLoading: Boolean = false,
    isEnable: Boolean = true,
    onClick: () -> Unit,
    text: String,
    imageResource: Int? = null
) {
    if (isLoading) {
        Box(
            modifier = modifier
                .buttonSize(buttonSize)
                .fillMaxWidth()
        ) {
            CircularProgressIndicator(progress = 0.5f)
        }
    } else {
        MyButton(
            modifier = modifier.buttonSize(buttonSize),
            buttonStyle = buttonStyle,
            buttonColor = buttonColor,
            buttonSize = buttonSize,
            isEnable = isEnable,
            onClick = onClick,
            text = text,
            imageResource = imageResource
        )
    }
}

@Composable
fun FillButton(
    modifier: Modifier = Modifier,
    buttonColor: ButtonColor,
    buttonSize: ButtonSize,
    isEnable: Boolean,
    onClick: () -> Unit,
    text: String,
    imageResource: Int? = null,
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        content = {
            IconButton1(imageResource = imageResource)
            TextButton1(text = text, buttonSize = buttonSize)
        },
        colors = fillButtonColor(),
        enabled = isEnable,
        shape = RoundedCornerShape(8.dp)
    )
}

@Composable
fun OutlineButton(
    modifier: Modifier = Modifier,
    buttonColor: ButtonColor,
    buttonSize: ButtonSize,
    isEnable: Boolean,
    onClick: () -> Unit,
    text: String,
    imageResource: Int? = null
) {
    OutlinedButton(
        modifier = modifier,
        onClick = onClick,
        content = {
            IconButton1(imageResource = imageResource)
            TextButton1(text = text, buttonSize = buttonSize)
        },
        colors = outlineButtonColor(),
        enabled = isEnable,
        border = buttonBorder(),
        shape = RoundedCornerShape(8.dp)
    )
}

@Composable
private fun MyButton(
    modifier: Modifier = Modifier,
    buttonStyle: ButtonStyle,
    buttonColor: ButtonColor,
    buttonSize: ButtonSize,
    isEnable: Boolean,
    onClick: () -> Unit,
    text: String,
    imageResource: Int? = null
) {
    when (buttonStyle) {
        is ButtonStyle.Fill -> FillButton(
            modifier = modifier,
            buttonColor = buttonColor,
            buttonSize = buttonSize,
            isEnable = isEnable,
            onClick = onClick,
            text = text,
            imageResource = imageResource
        )
        is ButtonStyle.Outline -> OutlineButton(
            buttonColor = buttonColor,
            buttonSize = buttonSize,
            isEnable = isEnable,
            onClick = onClick,
            text = text,
            imageResource = imageResource
        )
    }
}

@Composable
fun fillButtonColor(): ButtonColors {
    return ButtonDefaults.buttonColors(
        backgroundColor = Color.White,
        contentColor = Color.Yellow,
        disabledBackgroundColor = Color.White,
        disabledContentColor = Color.White
    )
}

@Composable
fun outlineButtonColor(): ButtonColors {
    return ButtonDefaults.outlinedButtonColors(
        contentColor = Color.Black,
        backgroundColor = Color.Green
    )
}

@Composable
fun buttonBorder(): BorderStroke {
    return BorderStroke(2.dp, Color.Red)
}

fun Modifier.buttonSize(buttonSize: ButtonSize): Modifier = composed {
    when (buttonSize) {
        is ButtonSize.Small -> Modifier
            .height(28.dp)
        is ButtonSize.Medium -> Modifier
            .height(36.dp)
        is ButtonSize.Large -> Modifier
            .height(44.dp)
            .fillMaxWidth()
    }
}

@Composable
fun TextButton1(text: String, buttonSize: ButtonSize) {
    Text(
        text = text,
        fontSize = textButtonSize(buttonSize = buttonSize),
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun IconButton1(imageResource: Int? = null) {
    if (imageResource != null) Icon(
        modifier = Modifier.padding(end = 10.dp),
        painter = painterResource(id = imageResource),
        contentDescription = null
    )
}

@Composable
fun textButtonSize(buttonSize: ButtonSize): TextUnit {
    return when (buttonSize) {
        is ButtonSize.Small -> 10.sp
        is ButtonSize.Medium -> 12.sp
        is ButtonSize.Large -> 14.sp
        else ->  14.sp
    }
}

@Preview
@Composable
fun PreviewButtonPrimaryYellow() {
    MyButton(
        isLoading = false,
        onClick = { /*TODO*/ },
        text = "Button",
        buttonColor = ButtonColor.Black,
        isEnable = true,
        buttonStyle = ButtonStyle.Outline,
        buttonSize = ButtonSize.Large,
    )
}