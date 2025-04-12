package presentation.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import presentation.viewmodel.TvShowDetailViewModel

@Composable
fun TvShowDetailScreen(
    permalink: String,
    viewModel: TvShowDetailViewModel = hiltViewModel()
) {
    // ⚠️ Déclenchement du chargement des données quand on entre dans l'écran
    LaunchedEffect(permalink) {
        viewModel.loadDetails(permalink)
    }

    val details = viewModel.details.collectAsState().value

    details?.let {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Image(
                painter = rememberAsyncImagePainter(it.imageUrl),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = it.name, style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = it.description, style = MaterialTheme.typography.bodyLarge)
        }
    } ?: run {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }
}
