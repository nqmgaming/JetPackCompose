package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImage
import com.example.jetpackcompose.ui.theme.JetPackComposeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPackComposeTheme {

                val constraints = ConstraintSet {
                    val greenBox = createRefFor("greenBox")
                    val redBox = createRefFor("redBox")
                    val blueBox = createRefFor("blueBox")

                    constrain(greenBox) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        width = Dimension.value(100.dp)
                        height = Dimension.value(100.dp)
                    }

                    constrain(redBox) {
                        top.linkTo(parent.top)
                        start.linkTo(greenBox.end)
                        width = Dimension.value(100.dp)
                        height = Dimension.value(100.dp)
                    }

                    constrain(blueBox) {
                        top.linkTo(parent.top)
                        start.linkTo(redBox.end)
                        width = Dimension.value(100.dp)
                        height = Dimension.value(100.dp)
                    }

                }

                Column {
                    ConstraintLayout(constraints) {
                        Box(
                            modifier = Modifier
                                .background(Color.Green)
                                .layoutId("greenBox")
                        )
                        Box(
                            modifier = Modifier
                                .background(Color.Red)
                                .layoutId("redBox")
                        )
                        Box(
                            modifier = Modifier
                                .background(Color.Blue)
                                .layoutId("blueBox")
                        )
                    }
                }

            }
        }
    }
}