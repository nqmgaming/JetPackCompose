package com.example.jetpackcompose

import androidx.compose.animation.ContentTransform
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import com.example.jetpackcompose.ui.theme.JetPackComposeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExpandableCard(
    title: String,
    titleFontSize: TextUnit = MaterialTheme.typography.bodyMedium.fontSize,
    titleFontWeight: FontWeight = FontWeight.Bold,
    description: String,
    descriptionFontSize: TextUnit = MaterialTheme.typography.bodySmall.fontSize,
    descriptionMaxLines: Int = 4,
    shape: CornerBasedShape = MaterialTheme.shapes.medium,
    padding: PaddingValues = PaddingValues(12.dp),
) {
    var expandedState by remember {
        mutableStateOf(
            false
        )
    }
    val rotationState by animateFloatAsState(
        targetValue = if (expandedState) 180f else 0f,
        label = "rotationState"
    )
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            ),
        shape = shape,
        onClick = {
            expandedState = !expandedState
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(padding)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = title,
                    fontWeight = titleFontWeight,
                    fontSize = titleFontSize,
                    modifier = Modifier.weight(1f),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                IconButton(
                    modifier = Modifier
                        .alpha(3f)
                        .rotate(rotationState),
                    onClick = { expandedState = !expandedState }) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Drop-Down Arrow"
                    )
                }
            }

            if (expandedState) {
                Text(
                    text = description,
                    fontSize = descriptionFontSize,
                    maxLines = descriptionMaxLines,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewExpandableCard() {
    JetPackComposeTheme {
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