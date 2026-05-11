package com.example.b04

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.b04.ui.theme.B04Theme
import kotlinx.coroutines.*
import kotlin.random.Random

class MainActivity : ComponentActivity() {

    // ===== SUSPEND FUNCTION =====
    suspend fun getValue(): Double {
        delay(2000) // giả lập tác vụ lâu
        return Random.nextDouble(1.0, 100.0)
    }

    // ===== ENUM =====
    enum class Direction {
        NORTH, SOUTH, WEST, EAST
    }

    // ===== OBJECT =====
    object DataProviderManager {
        fun getName() = "Coroutine Demo"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            B04Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Bai4Screen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }

    @Composable
    fun Bai4Screen(modifier: Modifier = Modifier) {
        var textResult by remember {
            mutableStateOf("Đang chạy Coroutine...\n")
        }

        // ===== COROUTINE =====
        LaunchedEffect(Unit) {
            try {
                textResult += "Gọi suspend fun...\n"
                val value = getValue()
                textResult += "Giá trị nhận được: $value\n\n"

                val direction = Direction.NORTH
                textResult += "Enum direction: $direction\n"

                when (direction) {
                    Direction.NORTH -> textResult += "Đi về hướng Bắc\n"
                    Direction.SOUTH -> textResult += "Đi về hướng Nam\n"
                    Direction.WEST -> textResult += "Đi về hướng Tây\n"
                    Direction.EAST -> textResult += "Đi về hướng Đông\n"
                }

                textResult += "\nObject name: ${DataProviderManager.getName()}"
            } catch (e: Exception) {
                textResult += "Lỗi: ${e.message}"
            }
        }

        Text(
            text = textResult,
            modifier = modifier.verticalScroll(rememberScrollState())
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBai4() {
    B04Theme {
        Text("Preview Bài 4")
    }
}
