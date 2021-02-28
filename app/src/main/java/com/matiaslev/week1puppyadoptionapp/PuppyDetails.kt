package com.matiaslev.week1puppyadoptionapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun PuppyDetails(navController: NavController) {
    Column {
        TopAppBar {

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

        Text(text = "Comming Soon...")
    }
}

@Preview(showBackground = true)
@Composable
fun PuppyDetailsPreview() {
    val navController = rememberNavController()

    PuppyDetails(navController)
}