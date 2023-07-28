package com.example.mymovie.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.mymovie.model.Movie
import com.example.mymovie.model.getMovies

@Preview
@Composable
fun MovieRow(names: Movie = getMovies()[0], onItemClick: (String) -> Unit = {}){
    var expanded by remember {
        mutableStateOf(false)
    }
    Card(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()
//        .height(120.dp)
        .clickable {
            onItemClick(names.id)
        },
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = 6.dp) {
        Row(horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically) {
            Surface(modifier = Modifier
                .padding(12.dp)
                .size(100.dp),
                shape = RectangleShape,
                elevation = 4.dp) {

                Image(painter = rememberImagePainter(data = names.poster,
                                                    builder = {
                                                        crossfade(true)
                                                        transformations(CircleCropTransformation())
                                                    }),
                    contentDescription = "Movie Poster")
//                Icon(imageVector = Icons.Default.AccountBox,
//                    contentDescription = "Movie Image")

            }
            Column(modifier = Modifier.padding(4.dp)) {
                Text(text = names.title,
                    style = MaterialTheme.typography.h6)
                Text(text = "Director: ${names.director}",
                    style = MaterialTheme.typography.caption)
                Text(text = "Release: ${names.year}",
                    style = MaterialTheme.typography.caption)

                AnimatedVisibility(visible = expanded) {
                    Column {
                        Text(buildAnnotatedString {
                            withStyle(style = SpanStyle(Color.DarkGray,
                                    fontSize = 13.sp)){
                                append("Plot: ")
                            }
                            withStyle(style = SpanStyle(Color.DarkGray,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Light)){
                                append(names.plot)
                            }
                        },modifier=Modifier.padding(6.dp))
                        Divider(modifier = Modifier.padding(3.dp))
                        Text(text = "Actor: ${names.actor}", style = MaterialTheme.typography.caption)
                        Text(text = "Genre: ${names.genre}", style = MaterialTheme.typography.caption)
                        Text(text = "Rating: ${names.rating}", style = MaterialTheme.typography.caption)
                    }
                }

                Icon(imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else
                    Icons.Filled.KeyboardArrowDown,
                    contentDescription = "Arrow Down",
                    Modifier
                        .size(25.dp)
                        .clickable {
                            expanded = !expanded
                        })
            }
        }

    }
}


