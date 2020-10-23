package com.example.singleactivity

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class SingleActivity: AppCompatActivity() {
    val mainFragmentID = R.id.mainFragment

    companion object{
        @JvmStatic
//        lateinit var fragmentStack:FragmentBasicStack
        lateinit var fragmentStack:SynFragmentBasicStack
//        lateinit var fragmentStack:synStack

        private const val TAG = "SingleActivity a85l"

        @JvmStatic
        @Volatile
        lateinit var appContext: Context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate: ")
//        fragmentStack = SingleTaskFragmentStack(this)
        fragmentStack = SynSingleTaskFragmentStack(this)
//        fragmentStack = synSingle(this)
        Log.d(TAG, "myf:before push ")
        fragmentStack.push(Fragment1::class.java,null)
        supportFragmentManager
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
        fragmentStack.pop()
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