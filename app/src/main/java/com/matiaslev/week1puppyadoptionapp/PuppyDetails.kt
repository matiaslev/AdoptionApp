package com.matiaslev.week1puppyadoptionapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun PuppyDetails(navController: NavController, mainViewModel: MainViewModel) {
    val puppy = mainViewModel.getSelectedPuppy()

    Column(modifier = Modifier
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        TopAppBar(
            backgroundColor = MaterialTheme.colors.background
        ) {

            Row(modifier = Modifier
                .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Image(modifier = Modifier
                    .padding(15.dp)
                    .clickable {
                        navController.popBackStack()
                    },
                    painter =  painterResource(id = R.drawable.ic_baseline_arrow_back_24),
                    contentDescription = "Back"
                )

                Text(text = "Puppy Details")

            }

        }

        LazyRow(modifier = Modifier) {
            items(puppy.image) { image ->
                Image(modifier = Modifier
                    .width(300.dp)
                    .height(300.dp)
                    .padding(20.dp),
                    contentScale = ContentScale.Crop,
                    painter = painterResource(id = image),
                    contentDescription = "Photo of: ${puppy.name}")
            }
        }

        Text(
            text = puppy.name,
            style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.Bold)
        )
        Text(
            modifier = Modifier.padding(15.dp),
            text = puppy.description,
            style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.Bold)
        )
        Text(
            modifier = Modifier.padding(15.dp),
            text = "Parque Luro",
            style = MaterialTheme.typography.body2.copy(fontWeight = FontWeight.Bold)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PuppyDetailsPreview() {
    val navController = rememberNavController()
    val mainViewModel = MainViewModel()
    mainViewModel.selectedPuppy.value = 0

    PuppyDetails(navController, mainViewModel)
}