// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import extensions.loadImageBitmap

@Composable
@Preview
fun App() {

    val image = "https://media.fstatic.com/NzPYyyiQ7w8wQkuGouRnq4SPKWM=/290x478/smart/media/movies/covers/2013/01/9144285c2a269b1a161b5a7e41e3761e.jpg"

    MaterialTheme {
        Column(modifier = Modifier.padding(vertical = 10.dp)) {
            Text(text = "Um sonho de liberdade")
            Image(
                bitmap = image.loadImageBitmap(),
                contentDescription = "Poster",
                modifier = Modifier.height(300.dp).width(200.dp)
            )
            Text(text = "Nota: 9.2-Ano: 1994")
        }
    }
}



fun main() = application {
    Window(
        title = "IMDB",
        onCloseRequest = ::exitApplication
    ) {
        App()
    }

}
