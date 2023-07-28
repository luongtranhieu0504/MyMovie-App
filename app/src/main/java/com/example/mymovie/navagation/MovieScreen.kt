package com.example.mymovie.navagation

enum class MovieScreen {
    HomeScreens,
    DetailScreen;

    companion object {
        fun fromRoute(route : String?): MovieScreen
        = when (route?.substringBefore("/")){
                HomeScreens.name -> HomeScreens
                DetailScreen.name -> DetailScreen
                null -> HomeScreens
                else -> throw IllegalAccessException("Route $route is not recognize")
        }

    }


}
