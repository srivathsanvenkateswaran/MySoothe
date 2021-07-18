package com.srivathsanvenkateswaran.mysoothe.composables

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.srivathsanvenkateswaran.mysoothe.ui.theme.MySootheTheme
import java.util.function.DoublePredicate

@Composable
fun HomeScreen() {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Spacer(modifier = Modifier.height(56.dp))

            MySootheTextField(
                labelText = "Search",
                leadingIcon = Icons.Default.Search
            )

            SectionHeader(
                headerLabel = "FAVORITE COLLECTIONS",
                baselinePadding = 40.dp
            )
            
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
private fun SectionHeader(
    headerLabel: String,
    baselinePadding: Dp
) {
    Text(
        text = headerLabel,
        style = MaterialTheme.typography.h2,
        modifier = Modifier
            .paddingFromBaseline(baselinePadding)
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
        HomeScreen()
    }
}