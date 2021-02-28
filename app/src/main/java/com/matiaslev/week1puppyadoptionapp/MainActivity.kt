package com.matiaslev.week1puppyadoptionapp

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.matiaslev.week1puppyadoptionapp.ui.theme.Week1PuppyadoptionappTheme

class MainActivity : AppCompatActivity() {

    private val mainViewModel = MainViewModel()

    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Week1PuppyadoptionappTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

                    EntryPoint(mainViewModel)

                }
            }
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun EntryPoint(mainViewModel: MainViewModel) {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "list") {

        composable("list") {
            PuppyList(puppies = mainViewModel.puppiesList, navController, mainViewModel)
        }

        composable("details") {
            PuppyDetails(navController, mainViewModel)
        }

    }
}