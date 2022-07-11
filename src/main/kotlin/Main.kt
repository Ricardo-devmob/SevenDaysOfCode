// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import extensions.loadImageBitmap
import model.Movie
import webClient.MovieWebClient

@Composable
@Preview
fun App() {

    MaterialTheme(colors = darkColors()) {
        Surface {
            Box(modifier = Modifier.fillMaxSize()) {
                val movies = listOf(
                    Movie(
                        title = "The Shawshank Redemption",
                        image = "https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_UX128_CR0,3,128,176_AL_.jpg",
                        rating = 9.2,
                        year = 1994
                    ),
                    Movie(
                        title = "The Godfather",
                        image = "https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_UX128_CR0,1,128,176_AL_.jpg",
                        rating = 9.2,
                        year = 1972
                    ),
                    Movie(
                        title = "The Dark Knight",
                        image = "https://m.media-amazon.com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@._V1_UX128_CR0,3,128,176_AL_.jpg",
                        rating = 9.0,
                        year = 2008
                    ),
                    Movie(
                        title = "The Godfather II",
                        image = "https://m.media-amazon.com/images/I/41N2vp6wUiL._AC_.jpg",
                        rating = 9.0,
                        year = 1974
                    )
                )
                LazyColumn {
                    items(movies) {movie ->
                        MovieItem(movie)
                    }
                }
            }
        }

    }
}

@Composable
private fun MovieItem(movie: Movie) {
    Column(
        modifier = Modifier
            .width(200.dp)
            .padding(vertical = 16.dp)
    ) {
        Image(
            bitmap = movie.image.loadImageBitmap(),
            contentDescription = "Poster",
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(4.dp)),
            contentScale = ContentScale.Crop
        )
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(
                    top = 8.dp,
                    start = 8.dp,
                    end = 8.dp
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    Icons.Default.Star,
                    "Ícone de estrela para nota",
                    tint = Color.Yellow,
                    modifier = Modifier.height(16.dp)
                )
                Text(
                    movie.rating.toString(),
                    modifier = Modifier.padding(start = 2.dp),
                    color = Color(0xffeeeeee),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Text(
                movie.year.toString(),
                color = Color(0xffeeeeee),
                fontSize = 14.sp
            )
        }
        Text(
            movie.title,
            modifier = Modifier.padding(
                start = 16.dp,
                top = 8.dp,
                end = 16.dp
            ),
            fontSize = 12.sp,
            color = Color.White,
            textAlign = TextAlign.Center
        )
    }
}


fun main() = application {
    MovieWebClient().findTop250Movies()
    Window(
        title = "IMDB",
        onCloseRequest = ::exitApplication
    ) {
        App()
    }

}
