package com.example.oque_vamos_assistir

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oque_vamos_assistir.ui.theme.OquevamosassistirTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OquevamosassistirTheme {
                Surface(
                    color = Color(0xFF424242),
                    modifier = Modifier.fillMaxSize()
                ) {
                    var random by remember {
                        mutableIntStateOf(1)
                    }

                    val choose = when (random) {
                        1 -> "COMÉDIA"
                        2 -> "AÇÃO"
                        3 -> "TERROR"
                        4 -> "FICÇÃO"
                        5 -> "ROMANCE"
                        6 -> "ANIMAÇÃO"
                        7 -> "SUSPENSE"
                        8 -> "FANTASIA"
                        else -> "AVENTURA"
                    }

                    val image = when (random) {
                        1 -> R.drawable.comedia
                        2 -> R.drawable.acao
                        3 -> R.drawable.terror
                        4 -> R.drawable.ficcao
                        5 -> R.drawable.romance
                        6 -> R.drawable.animacao
                        7 -> R.drawable.suspense
                        8 -> R.drawable.fantasia
                        else -> R.drawable.aventura
                    }


                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text("O que vamos assistir?", color = Color.White, fontSize = 30.sp, fontFamily = FontFamily(
                            Font(R.font.jockey_one)
                        ))

                        Image(
                            painter = painterResource(image),
                            contentDescription = "Filme",
                            modifier = Modifier
                                .width(225.dp).height(250.dp)
                                .padding(bottom = 43.dp).clip(shape = RoundedCornerShape(10.dp))
                        )


                        Text(
                            text = choose,
                            color = Color.White,
                            fontSize = 30.sp,
                            modifier = Modifier.padding(bottom = 58.dp, top = 29.dp),
                            fontFamily = FontFamily(Font(R.font.jockey_one))
                        )



                        Button(onClick = { random = (1..5).random() }, modifier = Modifier.size(width = 200.dp, height = 50.dp)) {
                            Text("Sortear", fontSize = 25.sp)
                        }



                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    OquevamosassistirTheme {
        Greeting("Android")
    }
}