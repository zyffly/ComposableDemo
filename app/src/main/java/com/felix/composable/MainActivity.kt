package com.felix.composable

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.felix.composable.ui.text.TextActivity
import com.felix.composable.ui.textField.TextFieldActivity
import com.felix.composable.ui.theme.ComposableDemoTheme
import com.felix.composable.ui.theme.fillModifier

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposableDemoTheme {
                // A surface container using the 'background' color from the theme
                InitUI()
            }
        }
    }

    @Preview
    @Composable
    fun InitUI() {
        Column(
            modifier = fillModifier.background(Color.White),
        ) {
            Item(text = "Text", clazz = TextActivity::class.java)
            Divider(color = Color.Gray, thickness = 1.dp)
            Item(text = "TextField", clazz = TextFieldActivity::class.java)
        }
    }

    @Composable
    fun Item(text: String, clazz: Class<*>) {
        Box(
            modifier = Modifier
                .fillMaxWidth(1f)
                .height(35.dp)
                .clickable(onClick = {
                    startActivity(Intent(this@MainActivity, clazz))
                }),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = text,
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .wrapContentHeight()
                    .padding(horizontal = 16.dp)
            )
        }
    }
}
