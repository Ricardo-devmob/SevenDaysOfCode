// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

    val image =
        "https://media.fstatic.com/NzPYyyiQ7w8wQkuGouRnq4SPKWM=/290x478/smart/media/movies/covers/2013/01/9144285c2a269b1a161b5a7e41e3761e.jpg"

    MaterialTheme(colors = darkColors()) {
        Surface {
            Box(modifier = Modifier.fillMaxSize()) {
                Column(
                    modifier = Modifier
                        .width(200.dp)
                        .padding(vertical = 16.dp)
                ) {
                    Image(
                        bitmap = image.loadImageBitmap(),
                        contentDescription = "Poster",
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(4.dp))
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
                                text = "9.2",
                                modifier = Modifier.padding(start = 2.dp),
                                color = Color(0xffeeeeee),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Text(
                            text = "1994",
                            color = Color(0xffeeeeee),
                            fontSize = 14.sp
                        )
                    }
                    Text(
                        text = "Um sonho de liberdade",
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
