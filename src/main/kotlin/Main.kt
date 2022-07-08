// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import extensions.loadImageBitmap
import org.jetbrains.skia.Bitmap
import org.jetbrains.skia.FontStyle
import org.jetbrains.skia.FontStyle.Companion.BOLD
import javax.swing.text.Style

@Composable
@Preview
fun App() {

    val image = "https://media.fstatic.com/NzPYyyiQ7w8wQkuGouRnq4SPKWM=/290x478/smart/media/movies/covers/2013/01/9144285c2a269b1a161b5a7e41e3761e.jpg"

    MaterialTheme (colors = darkColors()){
        Surface(color = Color.Black) {
            Box(modifier = Modifier.fillMaxSize()){
                Column(modifier = Modifier.padding(vertical = 10.dp)) {
                    Image(
                        bitmap = image.loadImageBitmap(),
                        contentDescription = "Poster",
                        modifier = Modifier.height(300.dp).width(200.dp)
                    )
                    Row(modifier = Modifier.padding(5.dp)) {
                        Row {
                            Row {
//                                Icon()
                                Text(
                                    text = "9.2",
                                    color = Color.White,
                                    style = TextStyle(fontStyle = androidx.compose.ui.text.font.FontStyle.Normal)
                                )
                            }
                            Text(
                                text = "1994",
                                color = Color.White,
                                textAlign = TextAlign.Right
                            )
                        }
                    }

                    Text(
                        text = "Um sonho de liberdade",
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                }
            }
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
