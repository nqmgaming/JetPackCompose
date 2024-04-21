package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
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
import androidx.compose.material3.Button
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.ui.theme.JetPackComposeTheme
import com.example.jetpackcompose.ui.theme.Typography


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPackComposeTheme {
                Surface(
                    modifier = Modifier.background(Color.White),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Row {
                        CustomItem(weight = 2f, color = Color.Red)
                        Spacer(modifier = Modifier.height(8.dp))
                        CustomItem(weight = 1f)
                        Spacer(modifier = Modifier.height(8.dp))
                        CustomItem(weight = 1f, color = Color.Green)
                    }
                }
            }
        }
    }
}

@Composable
fun BoxExample() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(200.dp)
                .background(Color.Blue)
        )
        Box(
            modifier = Modifier
                .size(150.dp)
                .background(Color.Red)
        )
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Green)
        )
    }
}

@Composable
fun RowScope.CustomItem(weight: Float, color: Color = Color.Gray) {
    Surface(
        modifier = Modifier
            .width(200.dp)
            .weight(weight)
            .height(50.dp),
        color = color
    ) {
        Text(
            text = "Hello, World!",
            style = Typography.bodySmall
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetPackComposeTheme {
        BoxExample()
    }
}