package presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import domain.model.TvShow

typealias OnTvShowClick = (String) -> Unit

@Composable
fun TvShowItem(tvShow: TvShow, onClick: OnTvShowClick) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick(tvShow.name) }
            .padding(8.dp)
    ) {
        Image(
            painter = rememberAsyncImagePainter(tvShow.imageUrl),
            contentDescription = null,
            modifier = Modifier.size(80.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(text = tvShow.name, style = MaterialTheme.typography.titleMedium)
            tvShow.network?.let {
                Text(text = it, style = MaterialTheme.typography.bodySmall)
            }
            tvShow.status?.let {
                Text(text = it, style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}