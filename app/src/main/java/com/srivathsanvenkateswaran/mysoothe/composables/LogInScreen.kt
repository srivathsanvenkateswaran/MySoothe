package com.srivathsanvenkateswaran.mysoothe.composables

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.srivathsanvenkateswaran.mysoothe.R
import com.srivathsanvenkateswaran.mysoothe.ui.theme.MySootheTheme

@Composable
fun LogInScreen() {

    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        LogInBackground()

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LoginHeader()
            
            Spacer(modifier = Modifier.height(32.dp))
            
            MySootheTextField(labelText = "Email address")

            Spacer(modifier = Modifier.height(8.dp))

            MySootheTextField(labelText = "Password")

            Spacer(modifier = Modifier.height(8.dp))

            MySootheButton(
                onClick = {  },
                buttonText = "LOG IN",
                buttonColor = MaterialTheme.colors.primary
            )

            SignUpLabel()
        }
    }
}

@Composable
private fun SignUpLabel() {

    val labelText = buildAnnotatedString {
        append("Don't have an account? ")

        withStyle(
            style = SpanStyle(
                textDecoration = TextDecoration.Underline
            )
        ) {
            append("Sign up")
        }
    }

    Text(
        text = labelText,
        modifier = Modifier
            .paddingFromBaseline(32.dp),
        style = MaterialTheme.typography.body1
    )
}

@Composable
private fun LoginHeader() {
    Text(
        text = "LOG IN",
        style = MaterialTheme.typography.h1,
        modifier = Modifier
            .paddingFromBaseline(200.dp)
    )
}

@Composable
fun MySootheTextField(
    labelText: String,
    leadingIcon: ImageVector? = null,
    modifier: Modifier = Modifier
) {
    val textFieldState by remember {
        mutableStateOf("")
    }

    TextField(
        value = "",
        onValueChange = {},
        label = {
            Text(text = labelText)
        },
        modifier = modifier
            .fillMaxWidth(),
        leadingIcon = {
            if (leadingIcon != null) {
                Icon(
                    imageVector = leadingIcon,
                    contentDescription = null
                )
            }
        }
    )
}

@Composable
private fun LogInBackground() {
    val isLight = MaterialTheme.colors.isLight

    val backgroundResource = if (isLight) {
        R.drawable.ic_light_login
    } else {
        R.drawable.ic_dark_login
    }

    Image(
        painter = painterResource(id = backgroundResource),
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier
            .fillMaxSize()
    )
}


@Preview(
    name = "Night Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Preview(
    name = "Day Mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
private fun WelcomeScreenPreview() {
    MySootheTheme {
        LogInScreen()
    }
}