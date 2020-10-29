package com.example.singleactivity.tab

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.annotation.DrawableRes
import com.example.singleactivity.R
import kotlinx.android.synthetic.main.tab_item.view.*

class NavItemView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : FrameLayout(context, attrs, defStyleAttr){
    init {
        View.inflate(context, R.layout.tab_item, this)
    }

    fun setState(navItem: NavItem) {
        icon.setImageResource(navItem.iconId)
    }

    fun checked() {
        icon.isActivated = true
    }

    fun unChecked() {
        icon.isActivated = false
    }

    data class NavItem(@DrawableRes val iconId: Int)
}