package com.example.retrofit_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.retrofit_compose.model.Data
import com.example.retrofit_compose.ui.theme.RetrofitcomposeTheme
import com.example.retrofit_compose.view.DataItem
import com.example.retrofit_compose.viewModel.DataViewModel

class MainActivity : ComponentActivity() {

    private val dataViewModel by viewModels<DataViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RetrofitcomposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        Id()
                        DataList(dataViewModel.dataResponse)
                        dataViewModel.getDataList()
                    }
                }
            }
        }
    }
}

@Composable
fun Id(){
    Text(text = "Retrofit-Compose")
}


@Composable
fun DataList(dataList : List<Data>){
    LazyColumn{
        itemsIndexed(items = dataList){_, item ->
            DataItem(data = item)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RetrofitcomposeTheme {

    }
}