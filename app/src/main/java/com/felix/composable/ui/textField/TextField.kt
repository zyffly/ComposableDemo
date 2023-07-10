package com.felix.composable.ui.textField

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.felix.composable.R

/**
 * Created by FelixZhou on 2023/7/10.
 * Dsc :
 */

/**
 * 主演演示label、placeholder,colors等属性使用
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LabelTextField() {
    val editText = remember {
        mutableStateOf("")
    }
    TextField(
        value = editText.value,
        onValueChange = { editText.value = it },
        label = @Composable { Text(text = "label、placeholder、colors") },
        placeholder = @Composable { Text(text = "演示label、placeholder、colors") },
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth(1f)
            .wrapContentHeight(),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Black, //文本的颜色
            focusedLabelColor = Color.Red,
            placeholderColor = Color.Gray
        )
    )
}

/**
 * 主演演示取消下划线
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UnLineTextField() {
    val editText = remember {
        mutableStateOf("")
    }
    TextField(
        value = editText.value,
        onValueChange = { editText.value = it },
        label = @Composable { Text(text = "取消下划线") },
        placeholder = @Composable { Text(text = "取消下划线") },
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth(1f)
            .wrapContentHeight(),
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent
        )
    )
}

/**
 * 圆角背景
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShapeTextField() {
    val editText = remember {
        mutableStateOf("")
    }
    TextField(
        value = editText.value,
        onValueChange = { editText.value = it },
        label = @Composable { Text(text = "圆角背景") },
        placeholder = @Composable { Text(text = "演示圆角背景") },
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth(1f)
            .wrapContentHeight(),
        shape = RoundedCornerShape(12.dp), //圆角背景
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Black, //文本的颜色
            focusedLabelColor = Color.Red,
            placeholderColor = Color.Gray,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent
        )
    )
}


/**
 * 设置键盘类型,定义软键盘右下角按钮显示类型以及点击事件
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KeyboardTextField(context: Context) {
    val editText = remember {
        mutableStateOf("")
    }
    TextField(
        value = editText.value,
        onValueChange = { editText.value = it },
        label = @Composable { Text(text = "键盘类型") },
        placeholder = @Composable { Text(text = "演示KeyboardOptions、KeyboardActions") },
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth(1f)
            .wrapContentHeight(),
        shape = RoundedCornerShape(12.dp), //圆角背景
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Black, //文本的颜色
            focusedLabelColor = Color.Red,
            placeholderColor = Color.Gray,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Go
        ),
        keyboardActions = KeyboardActions(
            onGo = {
                Toast.makeText(
                    context,
                    "onSend",
                    Toast.LENGTH_SHORT
                ).show()
            })
    )
}

/**
 * 输入长度限制
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputFilterLengthTextField() {
    val editText = remember {
        mutableStateOf("")
    }
    TextField(
        value = editText.value,
        onValueChange = {
            if (it.length <= 10) {
                editText.value = it
            } else {
                editText.value = it.substring(0,10)
            }
        },
        label = @Composable { Text(text = "限制输入长度") },
        placeholder = @Composable { Text(text = "演示限制输入长度") },
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth(1f)
            .wrapContentHeight(),
        shape = RoundedCornerShape(12.dp), //圆角背景
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Black, //文本的颜色
            focusedLabelColor = Color.Red,
            placeholderColor = Color.Gray,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent
        )
    )
}

/**
 * 只能输入字母
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputFilterAlphabetTextField() {
    val editText = remember {
        mutableStateOf(TextFieldValue(""))
    }
    val regex = Regex("^[a-zA-Z]+$")
    TextField(
        value = editText.value,
        onValueChange = {
            if(it.text.contains(regex) || it.text.isEmpty()) editText.value = it
        },
        label = @Composable { Text(text = "只能输入字母") },
        placeholder = @Composable { Text(text = "演示只能输入字母") },
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth(1f)
            .wrapContentHeight(),
        shape = RoundedCornerShape(12.dp), //圆角背景
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Black, //文本的颜色
            focusedLabelColor = Color.Red,
            placeholderColor = Color.Gray,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
    )
}

/**
 * 该输入框主演演示label、placeholder、colors、keyboardOptions等属性使用
 * 支持hint和label，
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditName() {
    val editText = remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        value = editText.value,
        onValueChange = { editText.value = it },
        label = @Composable { Text(text = "label、placeholder、colors、keyboardOptions") },
        placeholder = @Composable { Text(text = "演示label、placeholder、colors、keyboardOptions") },
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth(1f)
            .wrapContentHeight(),
        shape = RoundedCornerShape(12.dp), //圆角背景
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Red //获取焦点时的颜色
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
    )
}


/**
 * 密码
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditPassword() {
    val editText = remember {
        mutableStateOf("")
    }
    val pwdOff = remember {//保存密码可见性状态变化
        mutableStateOf(false)
    }
    OutlinedTextField(
        value = editText.value,
        onValueChange = { editText.value = it },
        label = @Composable { Text(text = "密码") },
        placeholder = @Composable { Text(text = "请输入8-16位密码") },
        maxLines = 1,
        modifier = Modifier
            .fillMaxWidth(1f)
            .wrapContentHeight(),
        shape = RoundedCornerShape(12.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Red
        ),
        trailingIcon = {
            IconToggleButton(
                checked = pwdOff.value,
                onCheckedChange = {
                    pwdOff.value = it
                },
            ) {
                Icon(
                    imageVector = if (pwdOff.value) {
                        ImageVector.vectorResource(id = R.drawable.ic_eye_n)
                    } else {
                        ImageVector.vectorResource(id = R.drawable.ic_eye_p)
                    },
                    contentDescription = ""
                )
            }
        },
        visualTransformation = (
                if (pwdOff.value) {
                    VisualTransformation.None//普通文本样式
                } else {
                    PasswordVisualTransformation('*')//密码样式，星号显示文字
                })
    )
}

/**
 * 输入框过滤器
 */
class InputFilter(var beforeText: String, var changeText: String) {

    var filterText = beforeText
}

fun InputFilter.maxLength(max: Int): InputFilter {
    if (changeText.length <= max) {
        filterText = changeText
        return this
    }


    if (changeText.length - beforeText.length > 1) {
        filterText = changeText
        return this
    }

    return this
}