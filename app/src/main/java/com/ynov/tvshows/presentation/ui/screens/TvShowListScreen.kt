package presentation.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import presentation.viewmodel.TvShowListViewModel

typealias OnTvShowClick = (String) -> Unit

@Composable
fun TvShowListScreen(viewModel: TvShowListViewModel, onItemClick: OnTvShowClick) {
    val shows = viewModel.shows.collectAsState().value

    LazyColumn(modifier = Modifier.fillMaxSize().padding(8.dp)) {
        items(shows) { show ->
            Row(
                modifier = Modifier.fillMaxWidth().clickable { onItemClick(show.name) }.padding(8.dp)
            ) {
                Image(
                    painter = rememberAsyncImagePainter(show.imageUrl),
                    contentDescription = null,
                    modifier = Modifier.size(80.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = show.name, style = MaterialTheme.typography.titleMedium)
            }
        }
    }
}