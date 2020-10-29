package com.example.singleactivity

import android.os.Bundle
import android.util.Log
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.singleactivity.ktx.initFragmentStack
import com.example.singleactivity.tab.NavTabContainerView
import kotlinx.android.synthetic.main.activity_main.*

class SingleActivity: AppCompatActivity(), NavTabContainerView.OnNavTabContainerViewListener {

    @IdRes
    internal val mainFragmentID = R.id.mainFragment

    internal val fragmentStackList = listOf<IFragmentStack>(
        SynSingleTaskFragmentStack(this),
        SynSingleTaskFragmentStack(this),
        SynSingleTaskFragmentStack(this),
        SynSingleTaskFragmentStack(this))

    internal var stackPosition:Int = 0

    private val initFragmentList = listOf<Class<out Fragment>>(Fragment1::class.java,Fragment2::class.java,Fragment3::class.java,Fragment4::class.java)

    companion object{
        private const val TAG = "SingleActivity a85l"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate: ")

        nav_tab_view_container.setOnNavTabContainerViewListener(this)
        nav_tab_view_container.renderForClick(0)

//        fragmentStack = SingleTaskFragmentStack(this)
    }

    override fun onNavItem(position: Int) {
        stackPosition = position
        initFragmentStack(initFragmentList[position],null)
    }

    override fun onStart() {
        Log.d(TAG, "onStart: ")
        super.onStart()
    }

    override fun onResume() {
        Log.d(TAG, "onResume: ")
        super.onResume()
    }

    override fun onPause() {
        Log.d(TAG, "onPause: ")
        super.onPause()
    }

    override fun onStop() {
        Log.d(TAG, "onStop: ")
        super.onStop()
    }

    override fun onRestart() {
        Log.d(TAG, "onRestart: ")
        super.onRestart()
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy: ")
        super.onDestroy()
    }

    override fun onBackPressed() {
        fragmentStackList[stackPosition].poll()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("a",1)
        Log.d(TAG, "onSaveInstanceState: ")
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        Log.d(TAG, "onRestoreInstanceState: ${savedInstanceState.getInt("a")}")
        super.onRestoreInstanceState(savedInstanceState)
    }
}