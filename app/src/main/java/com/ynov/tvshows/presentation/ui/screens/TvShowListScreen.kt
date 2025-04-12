package presentation.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import presentation.viewmodel.TvShowListViewModel
import domain.model.TvShow

@Composable
fun TvShowListScreen(viewModel: TvShowListViewModel = hiltViewModel()) {
    val shows by viewModel.shows.collectAsState()

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(shows) { show ->
            TvShowItem(show = show)
        }
    }
}

@Composable
fun TvShowItem(show: TvShow) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        AsyncImage(
            model = show.imageUrl,
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.align(Alignment.CenterVertically)
        ) {
            Text(
                text = show.name,
                style = MaterialTheme.typography.titleMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "${show.network ?: "Unknown"} - ${show.status ?: "N/A"}",
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}
