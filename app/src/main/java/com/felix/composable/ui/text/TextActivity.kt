package com.felix.composable.ui.text

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.felix.composable.ui.theme.fillModifier

/**
 * Created by FelixZhou on 2023/7/7.
 * Dsc :
 */
class TextActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { InitUI() }
    }

    @Preview
    @Composable
    fun InitUI(){
        Column(
            modifier = fillModifier.background(Color.White).padding(horizontal = 16.dp),
        ) {
            SimpleText(text = "简单Text示例")
            Spacer(modifier = Modifier.padding(10.dp))
//            EditName()
//            Spacer(modifier = Modifier.padding(10.dp))
//            EditPassword()
//            Spacer(modifier = Modifier.padding(10.dp))
        }
    }
}