package com.example.oque_vamos_assistir

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oque_vamos_assistir.ui.theme.OquevamosassistirTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OquevamosassistirTheme {
                Inicio()
            }
        }
    }
}

val background = Color(0xFF2B2D42)
@Composable
fun Inicio() {
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
        modifier = Modifier.background(background).fillMaxSize()
    ) {
        Text(
            text = "O que vamos \n\n\nassistir?",
            color = Color.White,
            fontSize = 65.sp,
            fontFamily = FontFamily(Font(R.font.jockey_one)),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
        )

        Image(
            painter = painterResource(image),
            contentDescription = "Filme",
            modifier = Modifier
                .clip(shape = RoundedCornerShape(10.dp))
                .padding(horizontal = 14.dp)
                .padding(top = 40.dp)
                .padding(bottom = 40.dp)
        )

        Text(
            text = choose,
            color = Color.White,
            fontSize = 40.sp,
            modifier = Modifier.padding(bottom = 40.dp),
            fontFamily = FontFamily(Font(R.font.jockey_one))
        )

        Button(
            onClick = { random = (1..8).random() },
            modifier = Modifier.size(
                width = 225.dp,
                height = 75.dp
            ),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFD90429)
            )
        ) {
            Text(
                text = "Sortear",
                fontSize = 40.sp,
                fontFamily = FontFamily(Font(R.font.jockey_one)),
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(64.dp))
    }
}

@Preview
@Composable
private fun Preview() {
    OquevamosassistirTheme {
        Inicio()
    }
}
