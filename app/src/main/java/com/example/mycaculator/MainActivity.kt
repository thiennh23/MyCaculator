package com.example.mycaculator

import android.os.Bundle
import android.widget.Space
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycaculator.ui.theme.MyCaculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Caculator()
            /*MyCaculatorTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }*/
        }
    }
}

@Composable
fun Caculator() {

    val mContext = LocalContext.current

    var num1 by remember {
        mutableStateOf("0")
    }

    var num2 by remember {
        mutableStateOf("0")
    }

    var resultString: String = ""

    Column(
        Modifier
            .fillMaxSize()
            .padding(top = 150.dp, start = 15.dp, end = 15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
        ) {
        Text(text = "CALCULATOR",
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 15.dp)
            )

        TextField(value = num1, onValueChange = {num1 = it}, Modifier.fillMaxWidth())
        TextField(value = num2, onValueChange = {num2 = it}, Modifier.fillMaxWidth())

        Row (
            Modifier
                .fillMaxWidth()
                .padding(top = 17.dp),
            horizontalArrangement = Arrangement.Center,
            /*Modifier.padding(start = 15.dp, top = 15.dp)*/
        ) {
            Button(onClick = {
                var result: Int = num1.toInt() + num2.toInt()
                resultString = "$num1 + $num2 = $result"
                Toast.makeText(mContext,"Result is $result", Toast.LENGTH_SHORT).show()
            }) {
                Text(text = "Add")
            }

            Spacer(modifier = Modifier.width(16.dp))

            Button(onClick = {
                var result: Int = num1.toInt() - num2.toInt()
                resultString = "$num1 - $num2 = $result"
                Toast.makeText(mContext, "Result is $result", Toast.LENGTH_SHORT).show()
            }) {
                Text(text = "Sub")
            }

            Spacer(modifier = Modifier.width(16.dp))

            Button(onClick = {
                var result: Int = num1.toInt() * num2.toInt()
                resultString = "$num1 * $num2 = $result"
                Toast.makeText(mContext, "Result is $result", Toast.LENGTH_SHORT).show()
            }) {
                Text(text = "Mul")
            }

            Spacer(modifier = Modifier.width(16.dp))

            Button(onClick = {
                var result: Int = num1.toInt() / num2.toInt()
                resultString = "$num1 / $num2 = $result"
                Toast.makeText(mContext, "Result is $result", Toast.LENGTH_SHORT).show()
            }) {
                Text(text = "Div")
            }
        }

    }
}


@Preview
@Composable
fun CaculatorPreview() {
    Caculator()
}