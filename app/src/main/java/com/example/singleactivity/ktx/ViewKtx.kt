package com.example.singleactivity.ktx

import android.util.TypedValue
import android.view.View
import kotlin.math.roundToInt

fun View.dp2pxInt(dp: Float): Int {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.displayMetrics).roundToInt()
}