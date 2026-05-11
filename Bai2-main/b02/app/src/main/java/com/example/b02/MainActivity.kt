package com.example.b02

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class SmartDevice {

    val name = "Android TV"
    val category = "Entertainment"
    var deviceStatus = "Online"

    fun turnOn(): String {
        return "Smart device is turned on."
    }

    fun turnOff(): String {
        return "Smart device is turned off."
    }
}

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {

                Surface(modifier = Modifier.fillMaxSize()) {

                    SmartDeviceScreen()

                }
            }
        }
    }
}

@Composable
fun SmartDeviceScreen() {

    val smartTvDevice = SmartDevice()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text(
            text = "Device name: ${smartTvDevice.name}",
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Category: ${smartTvDevice.category}",
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Status: ${smartTvDevice.deviceStatus}",
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = smartTvDevice.turnOn(),
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = smartTvDevice.turnOff(),
            fontSize = 18.sp
        )
    }
}