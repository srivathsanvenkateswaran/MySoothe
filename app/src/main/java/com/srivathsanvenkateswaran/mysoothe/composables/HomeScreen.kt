package com.srivathsanvenkateswaran.mysoothe.composables

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.srivathsanvenkateswaran.mysoothe.models.Collection
import com.srivathsanvenkateswaran.mysoothe.models.alignYourBodyCollections
import com.srivathsanvenkateswaran.mysoothe.models.alignYourMindCollections
import com.srivathsanvenkateswaran.mysoothe.models.favoritesCollections
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
                .padding(start = 16.dp)
        ) {
            Spacer(modifier = Modifier.height(56.dp))

            MySootheTextField(
                labelText = "Search",
                leadingIcon = Icons.Default.Search,
                modifier = Modifier
                    .padding(end = 16.dp)
            )

            SectionHeader(
                headerLabel = "FAVORITE COLLECTIONS",
                baselinePadding = 40.dp
            )
            
            Spacer(modifier = Modifier.height(8.dp))

            FavoriteCollectionsRow()

            AlignYourItemsColumn(
                alignPartName = "BODY",
                collections = alignYourBodyCollections
            )

            AlignYourItemsColumn(
                alignPartName = "MIND",
                collections = alignYourMindCollections
            )
        }
    }
}

@Composable
private fun AlignYourItemsColumn(
    alignPartName: String,
    collections: List<Collection>
) {
    SectionHeader(
        headerLabel = "ALIGN YOUR $alignPartName",
        baselinePadding = 56.dp
    )

    Spacer(modifier = Modifier.height(8.dp))

    AlignYourItemsRow(collections = collections)
}

@Composable
fun AlignYourItemsRow(
    collections: List<Collection>
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(collections) { collection ->
            AlignYourItem(collection = collection)
        }
    }
}

@Composable
fun AlignYourItem(
    collection: Collection
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = collection.imageRes),
            contentDescription = collection.name,
            modifier = Modifier
                .size(88.dp)
                .clip(RoundedCornerShape(44.dp)),
            contentScale = ContentScale.Crop
        )

        Text(
            text = collection.name,
            modifier = Modifier
                .paddingFromBaseline(top = 24.dp)
        )
    }
}

@Composable
fun FavoriteCollectionsRow() {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(count = 3) { 
            FavoritesCollectionPairColumn(
                firstCollection = favoritesCollections[it],
                secondCollection = favoritesCollections[it + 3]
            )
        }
    }
}

@Composable
fun FavoritesCollectionPairColumn(
    firstCollection: Collection,
    secondCollection: Collection
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        FavoritesCardView(collection = firstCollection)

        FavoritesCardView(collection = secondCollection)
    }
}

@Composable
fun FavoritesCardView(
    collection: Collection
) {
    Card(
        modifier = Modifier
            .size(
                height = 56.dp,
                width = 192.dp
            ),
        shape = MaterialTheme.shapes.small
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = collection.imageRes),
                contentDescription = collection.name,
                modifier = Modifier
                    .size(56.dp),
                contentScale = ContentScale.Crop
            )

            Text(
                text = collection.name,
                style = MaterialTheme.typography.h2
            )
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
//        AlignYourBodyItem(collection = alignYourBodyCollections[0])
    }
}