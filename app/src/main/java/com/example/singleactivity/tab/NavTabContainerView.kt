package com.example.singleactivity.tab

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import com.example.singleactivity.R
import com.example.singleactivity.ktx.dp2pxInt

class NavTabContainerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    FrameLayout(context, attrs, defStyleAttr) {

    private val navItemViewContainer = LinearLayout(context)

    private var onNavTabContainerViewListener: OnNavTabContainerViewListener? = null

    init {
        initNavTabViews()
    }

    private fun initNavTabViews() {
        val qiyeNavItem = NavItemView.NavItem(R.drawable.ic_tab_qiye)
        val mendianNavItem = NavItemView.NavItem(R.drawable.ic_tab_mendian)
        val settingNavItem = NavItemView.NavItem(R.drawable.ic_tab_setting)
        val shoucangNavItem = NavItemView.NavItem(R.drawable.ic_tab_shoucang)

        val navItemList = listOf(
            qiyeNavItem,
            mendianNavItem,
            settingNavItem,
            shoucangNavItem,
        )

        navItemViewContainer.gravity = Gravity.CENTER
        navItemViewContainer.orientation = LinearLayout.HORIZONTAL

        val navItemContainerLayoutParams = LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dp2pxInt(50.0f))
        navItemContainerLayoutParams.gravity = Gravity.BOTTOM
        addView(navItemViewContainer, navItemContainerLayoutParams)

        var navItemView: NavItemView
        val navItemViewLayoutParams: LinearLayout.LayoutParams = LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1.0f)
        navItemList.forEachIndexed { index, navItem ->
            navItemView = NavItemView(context)
            navItemView.tag = index
            navItemView.setOnClickListener {
                val navItemPosition = it.tag as Int
                renderForClick(navItemPosition)
            }
            navItemView.setState(navItem)
//            when (index) {
//                0 -> {
//                    navItemView.checked()
//                }
//                2 -> {
//                    navItemView.visibility = View.INVISIBLE
//                }
//            }
            navItemViewContainer.addView(navItemView, navItemViewLayoutParams)
        }

    }

    fun renderForClick(position: Int) {
        for (index in 0 until navItemViewContainer.childCount) {
            val child = navItemViewContainer.getChildAt(index) as NavItemView
            if (position == index) {
                child.checked()
                onNavTabContainerViewListener?.onNavItem(position)
            } else {
                child.unChecked()
            }
        }
    }

    fun setOnNavTabContainerViewListener(onNavTabContainerViewListener: OnNavTabContainerViewListener) {
        this.onNavTabContainerViewListener = onNavTabContainerViewListener
    }

    interface OnNavTabContainerViewListener {
        fun onNavItem(position: Int)
    }
}