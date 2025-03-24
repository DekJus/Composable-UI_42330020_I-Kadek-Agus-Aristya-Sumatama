package com.example.lemontea

import android.os.Bundle
import android.widget.Toast
import androidx.compose.ui.tooling.preview.Preview
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemontea.ui.theme.LemonteaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonteaTheme {
                MainScreen { message ->
                    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}

@Composable
fun MainScreen(onButtonClick: (String) -> Unit) {
    var name by remember { mutableStateOf(TextFieldValue()) }

    Column(
        modifier = Modifier.fillMaxSize().padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Welcome to Little Lemon Cafe", fontSize = 28.sp, color = Color(0xFF6200EE))
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Enjoy fresh and delicious lemon tea!", fontSize = 18.sp, color = Color.Gray)
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Enter your name") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { onButtonClick("Hello, ${name.text}!") },
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6200EE))
        ) {
            Text(text = "Say Hello", color = Color.White)
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = { onButtonClick("Enjoy your tea!") },
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF03DAC5))
        ) {
            Text(text = "Order Tea", color = Color.Black)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    LemonteaTheme {
        MainScreen(onButtonClick = {})
    }
}
