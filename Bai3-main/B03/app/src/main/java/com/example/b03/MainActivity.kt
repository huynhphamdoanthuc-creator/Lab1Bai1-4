package com.example.b03

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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.b03.ui.theme.B03Theme

class MainActivity : ComponentActivity() {

    // ===== BÀI 3 =====
    fun runBai3(): String {
        val result = StringBuilder()

        // ===== SET =====
        val numbers = listOf(0, 3, 8, 4, 0, 5, 5, 8, 9, 2)
        val setOfNumbers = numbers.toSet()
        result.append("SET từ List:\n$setOfNumbers\n\n")

        val set1 = setOf(1, 2, 3)
        val set2 = mutableSetOf(3, 4, 5)
        result.append("Giao (Intersect): ${set1.intersect(set2)}\n")
        result.append("Hợp (Union): ${set1.union(set2)}\n\n")

        // ===== MAP =====
        val peopleAges = mutableMapOf(
            "Fred" to 30,
            "Ann" to 23
        )
        peopleAges["Barbara"] = 42
        peopleAges["Joe"] = 51

        result.append("MAP People Ages:\n")
        peopleAges.forEach {
            result.append("${it.key} is ${it.value}\n")
        }
        result.append("\n")

        val filteredNames = peopleAges.filter { it.key.length < 4 }
        result.append("Filtered Names (length < 4):\n$filteredNames\n\n")

        // ===== COLLECTION OPERATIONS =====
        val words = listOf("about", "acute", "balloon", "best", "brief", "class")
        val filteredWords = words
            .filter { it.startsWith("b", ignoreCase = true) }
            .shuffled()
            .take(2)
            .sorted()

        result.append("Filtered Words:\n$filteredWords\n\n")

        // ===== LAMBDA =====
        val triple: (Int) -> Int = { a -> a * 3 }
        result.append("Lambda triple(5): ${triple(5)}\n\n")

        // ===== ELVIS =====
        var quantity: Int? = null
        result.append("Quantity null ?: ${quantity ?: 0}\n")
        quantity = 4
        result.append("Quantity = 4 ?: ${quantity ?: 0}\n")

        return result.toString()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val bai3Result = runBai3()

        setContent {
            B03Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Bai3Screen(
                        text = bai3Result,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Bai3Screen(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        modifier = modifier.verticalScroll(rememberScrollState())
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewBai3() {
    B03Theme {
        Bai3Screen(text = "Preview Bài 3")
    }
}
