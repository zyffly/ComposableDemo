package com.felix.composable.ui.theme

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Created by FelixZhou on 2023/7/5.
 * Dsc :
 */

/**
 * 通用修饰符，水平填满设置水平内边距16.dp
 */
val fillModifier = Modifier
    .fillMaxSize(1f)


/**
 * 通用修饰符，水平填满设置水平内边距16.dp
 */
val fillWP16Modifier = Modifier
    .fillMaxWidth(1f)
    .padding(horizontal = 16.dp)
