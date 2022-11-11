package com.github.triazane

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.github.triazane.optimization1.MainViewModel
import com.github.triazane.optimization1.RgbSelector
import com.github.triazane.ui.theme.TriazaneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TriazaneTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel = viewModel<MainViewModel>()
                    val changeColorLambda = remember<(Color) -> Unit> {
                        {
                            viewModel.changeColor(it)
                        }
                    }
                    var color by remember {
                        mutableStateOf(Color.Red)
                    }
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        RgbSelector(
                            color = viewModel.color,
                            onColorClick = {
                                viewModel.changeColor(color = it)
                            }
                        )
                    }
                }
            }
        }
    }
}

