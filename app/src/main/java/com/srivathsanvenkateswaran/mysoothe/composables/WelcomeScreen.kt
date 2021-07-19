package com.srivathsanvenkateswaran.mysoothe.composables

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.srivathsanvenkateswaran.mysoothe.R
import com.srivathsanvenkateswaran.mysoothe.ui.theme.MySootheTheme

@Composable
fun WelcomeScreen(
    onLoginClick: () -> Unit,
    onSignUpClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = MaterialTheme.colors.background
            )
    ) {
        WelcomeBackground()

        LogoButtonColumn(
            modifier = Modifier
                .align(Alignment.Center),
            onLoginClick = onLoginClick,
            onSignUpClick = onSignUpClick
        )
    }
}

@Composable
private fun LogoButtonColumn(
    modifier: Modifier,
    onLoginClick: () -> Unit,
    onSignUpClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(
                horizontal = 16.dp
            )
    ) {
        MySootheLogo()
        
        Spacer(modifier = Modifier.height(32.dp))

        MySootheButton(
            onClick = onSignUpClick,
            buttonText = "SIGN UP",
            buttonColor = MaterialTheme.colors.primary
        )
        
        Spacer(modifier = Modifier.height(8.dp))

        MySootheButton(
            onClick = onLoginClick,
            buttonText = "LOG IN",
            buttonColor = MaterialTheme.colors.secondary
        )
    }
}

@Composable
private fun MySootheLogo() {

    val isLight = MaterialTheme.colors.isLight

    val appLogoRes = if(isLight) {
        R.drawable.ic_light_logo
    } else {
        R.drawable.ic_dark_logo
    }

    Image(
        painter = painterResource(id = appLogoRes),
        contentDescription = "MySoothe Logo"
    )
}

@Composable
fun MySootheButton(
    onClick: () -> Unit,
    buttonText: String,
    buttonColor: Color
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .height(72.dp)
            .fillMaxWidth(),
        shape = MaterialTheme.shapes.medium,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = buttonColor
        )
    ) {
        Text(text = buttonText)
    }
}

@Composable
private fun WelcomeBackground() {
    val isLight = MaterialTheme.colors.isLight

    val backgroundResource = if (isLight) {
        R.drawable.ic_light_welcome
    } else {
        R.drawable.ic_dark_welcome
    }

    Image(
        painter = painterResource(id = backgroundResource),
        contentDescription = null,
        modifier = Modifier
            .fillMaxSize(),
        contentScale = ContentScale.FillBounds
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
        WelcomeScreen(
            onSignUpClick = {},
            onLoginClick = {}
        )
    }
}
