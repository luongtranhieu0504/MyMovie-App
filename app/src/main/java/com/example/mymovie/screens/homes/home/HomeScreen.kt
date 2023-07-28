package com.example.mymovie.screens.homes.home

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mymovie.model.Movie
import com.example.mymovie.model.getMovies
import com.example.mymovie.navagation.MovieScreen
import com.example.mymovie.screens.homes.details.DetailScreen
import com.example.mymovie.widgets.MovieRow

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController){
    Scaffold(topBar = {
        TopAppBar(backgroundColor = Color.LightGray,
            elevation = 5.dp) {
            Text(text = "Movie")
        }
    },) {
        MainContent(navController = navController)

    }
}

@Composable
fun MainContent(
    navController: NavController,
    movieList: List<Movie> = getMovies()){
    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn{
            items(items = movieList){
                MovieRow(names = it){movie ->
                    navController.navigate(route = MovieScreen.DetailScreen.name+"/$movie")
                }

            }
        }
    }
}
