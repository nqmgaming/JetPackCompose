package com.example.jetpackcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.ui.theme.JetPackComposeTheme
import com.example.jetpackcompose.ui.theme.Typography


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPackComposeTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        ExpandableCard(
                            title = "My Title",
                            description = "Staying fit doesn't need to be expensive; I've found several effective free exercise ways. One of my favorite methods is simply going for a walk or run. It's easy, flexible, and requires no special equipment—perfect for getting my heart rate up and burning calories. \n" +
                                    "\n" +
                                    "I also include bodyweight exercises in my routine, like push-ups, squats, and planks. These exercises help me build muscle and improve my fitness without needing any gear. \n" +
                                    "\n" +
                                    "Sometimes, I enjoy using free online workout videos. A huge variety is available, making it easy to keep my workouts fresh and exciting. On weekends, I love to go outside for a hike or bike ride, which combines exercise with enjoying the outdoors.\n" +
                                    "\n" +
                                    "Lastly, I make sure to integrate physical activity into my daily life by doing household chores and choosing more active options like taking the stairs. By incorporating these activities into my routine, I keep fit without spending a dime.\n" +
                                    "\n",
                        )
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetPackComposeTheme {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            ExpandableCard(
                title = "My Title",
                description = "Staying fit doesn't need to be expensive; I've found several effective free exercise ways. One of my favorite methods is simply going for a walk or run. It's easy, flexible, and requires no special equipment—perfect for getting my heart rate up and burning calories. \n" +
                        "\n" +
                        "I also include bodyweight exercises in my routine, like push-ups, squats, and planks. These exercises help me build muscle and improve my fitness without needing any gear. \n" +
                        "\n" +
                        "Sometimes, I enjoy using free online workout videos. A huge variety is available, making it easy to keep my workouts fresh and exciting. On weekends, I love to go outside for a hike or bike ride, which combines exercise with enjoying the outdoors.\n" +
                        "\n" +
                        "Lastly, I make sure to integrate physical activity into my daily life by doing household chores and choosing more active options like taking the stairs. By incorporating these activities into my routine, I keep fit without spending a dime.\n" +
                        "\n",
            )
        }

    }
}