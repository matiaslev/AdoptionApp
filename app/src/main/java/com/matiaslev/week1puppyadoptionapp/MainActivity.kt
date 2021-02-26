package com.matiaslev.week1puppyadoptionapp

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.matiaslev.week1puppyadoptionapp.ui.theme.Week1PuppyadoptionappTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Week1PuppyadoptionappTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    PuppyList(Puppy.getMockedList())
                }
            }
        }
    }
}

@Composable
fun PuppyList(puppies: List<Puppy>) {
    LazyColumn(modifier = Modifier
        .fillMaxWidth()
    ) {
        items(puppies) { puppy ->
            PuppyItem(puppy)
        }
    }
}

@Composable
fun PuppyItem(puppy: Puppy) {
    Row(modifier = Modifier
        .clickable {

        }
    ) {
        Image(modifier = Modifier
            .padding(15.dp)
            .clickable {

            },
            painter =  painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Photo of: ${puppy.name}"
        )
        Column(modifier = Modifier
            .padding(15.dp)
        ) {
            Text(text = puppy.name, style = typography.h5.copy(fontWeight = FontWeight.Bold))
            Text(text = puppy.description, modifier = Modifier.padding(top = 10.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Week1PuppyadoptionappTheme {
        Surface(color = MaterialTheme.colors.background) {
            PuppyList(Puppy.getMockedList())
        }
    }
}