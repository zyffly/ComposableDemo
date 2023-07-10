package com.felix.composable.ui.text

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.felix.composable.R
import com.felix.composable.ui.theme.fillWP16Modifier

/**
 * Created by FelixZhou on 2023/7/7.
 * Dsc :
 */

/**
 *  简单Text示例
 */
@Composable
fun SimpleText(text: String) {
    Text(
        text = text,
        modifier = Modifier
            .fillMaxWidth(1f)
            .wrapContentHeight()
    )
}

/**
 *  简单Text示例
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterTextField() {
    TextField(value = "", onValueChange = {})
}
