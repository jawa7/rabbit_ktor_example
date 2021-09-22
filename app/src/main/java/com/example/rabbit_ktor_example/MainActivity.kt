package com.example.rabbit_ktor_example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.example.rabbit_ktor_example.ui.theme.Rabbit_ktor_exampleTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Rabbit_ktor_exampleTheme {

                val viewModel: MainViewModel = hiltViewModel()
                val rabbit = viewModel.state.value.rabbit
                val isLoading = viewModel.state.value.isLoading

                Box(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(32.dp)
                    ) {
                        rabbit?.let {
                            if (!isLoading) {
                                Image(
                                    painter = rememberImagePainter(
                                        data = rabbit.imageUrl,
                                        builder = { crossfade(true) }
                                    ),
                                    contentDescription = "rabbit"
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(
                                    text = rabbit.name,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(
                                    text = rabbit.description
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                            } else {
                                Box(
                                    modifier = Modifier.fillMaxSize()
                                ) {
                                    CircularProgressIndicator(
                                        modifier = Modifier.align(Alignment.Center)
                                    )
                                }
                            }
                        }
                    }
                    Column(
                        verticalArrangement = Arrangement.Bottom,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Button(
                            onClick = viewModel::getRandomRabbit,
                            modifier = Modifier
                                .padding(bottom = 8.dp)
                        ) {
                            Text(
                                text = "Random Rabbit"
                            )
                        }
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Button(
                                onClick = viewModel::getFirstRabbit,
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)
                                    .padding(8.dp)

                            ) {
                                Text(
                                    text = "First Rabbit"
                                )
                            }
                            Button(
                                onClick = viewModel::getSecondRabbit,
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)
                                    .padding(8.dp)
                            ) {
                                Text(
                                    text = "Second Rabbit"
                                )
                            }
                        }
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Button(
                                onClick = viewModel::getFourthRabbit,
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)
                                    .padding(8.dp)
                            ) {
                                Text(
                                    text = "Fourth Rabbit"
                                )
                            }
                            Button(
                                onClick = viewModel::getThirdRabbit,
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)
                                    .padding(8.dp)
                            ) {
                                Text(
                                    text = "Third Rabbit"
                                )
                            }
                        }
                        Button(
                            onClick = viewModel::getFifthRabbit,
                            modifier = Modifier
                                .padding(bottom = 24.dp, top = 8.dp)
                        ) {
                            Text(
                                text = "Fifth Rabbit"
                            )
                        }
                    }
                }
            }
        }
    }
}