package com.matiaslev.week1puppyadoptionapp

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.matiaslev.week1puppyadoptionapp.ui.theme.Week1PuppyadoptionappTheme

@ExperimentalAnimationApi
@Composable
fun PuppyList(puppies: List<Puppy>, navController: NavController, mainViewModel: MainViewModel) {

    val isAddPuppyVisible = remember { mutableStateOf(false) }

    Column {
        TopAppBar(
            backgroundColor = MaterialTheme.colors.background
        ) {
            
            Row(modifier = Modifier
                .fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier)
                Text(color = MaterialTheme.colors.primary, text = "Puppies")

                Image(modifier = Modifier
                    .padding(15.dp)
                    .clickable {
                        isAddPuppyVisible.value = !isAddPuppyVisible.value
                    },
                    painter =  painterResource(id = R.drawable.ic_baseline_add_24),
                    contentDescription = "Add"
                )
            }
            
        }

        AddPuppy(isAddPuppyVisible)

        LazyColumn(modifier = Modifier
            .fillMaxWidth()
        ) {

            items(puppies) { puppy ->
                PuppyItem(puppy, navController, mainViewModel)
            }
        }
    }

}

@ExperimentalAnimationApi
@Composable
fun AddPuppy(isAddPuppyVisible: MutableState<Boolean>) {
    AnimatedVisibility(visible = isAddPuppyVisible.value) {

        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Row(modifier = Modifier
                .clickable {

                }
            ) {
                Image(modifier = Modifier
                    .padding(15.dp)
                    .clickable {

                    },
                    painter =  painterResource(id = R.drawable.ic_baseline_add_a_photo_24),
                    contentDescription = "Add Photos"
                )
                Column(modifier = Modifier
                    .padding(15.dp)
                ) {
                    OutlinedTextField(
                        value = "",
                        onValueChange = {  },
                        label = { Text(text = "Name") }
                    )
                    OutlinedTextField(
                        value = "",
                        onValueChange = {  },
                        label = { Text(text = "Description") }
                    )
                }
            }

            OutlinedButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp, end = 15.dp),
                onClick = { }
            ) {
                Text(text = "Add Puppy")
            }

        }

    }
}

@Composable
fun PuppyItem(puppy: Puppy, navController: NavController, mainViewModel: MainViewModel) {
    val currentImage = remember { mutableStateOf(0) }

    Row(modifier = Modifier
        .clickable {
            mainViewModel.selectedPuppy.value = puppy.id
            navController.navigate("details")
        }
    ) {
        Image(modifier = Modifier
            .width(150.dp)
            .height(150.dp)
            .padding(15.dp)
            .clickable {
                if (currentImage.value == puppy.image.size - 1) {
                    currentImage.value = 0
                } else currentImage.value++
            },
            contentScale = ContentScale.Crop,
            painter =  painterResource(id = puppy.image[currentImage.value]),
            contentDescription = "Photo of: ${puppy.name}"
        )
        Column(modifier = Modifier
            .padding(15.dp)
        ) {
            Text(text = puppy.name, style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.Bold))
            Text(text = puppy.description, modifier = Modifier.padding(top = 10.dp))
        }
    }
}

@ExperimentalAnimationApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val navController = rememberNavController()
    val mainViewModel = MainViewModel()

    Week1PuppyadoptionappTheme {
        Surface(color = MaterialTheme.colors.background) {
            PuppyList(mainViewModel.puppiesList, navController, mainViewModel)
        }
    }
}