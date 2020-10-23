package com.example.singleactivity

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment

class SynSingleTaskFragmentStack(activity: SingleActivity): SynFragmentBasicStack(activity) {

    companion object{
        private const val TAG = "SynSingleTaskFragmentStack"
    }

    @SuppressLint("LongLogTag")
    override fun <FragmentContainer : Fragment> push(fragmentClass: Class<FragmentContainer>,bundle: Bundle?) {
        if(containsClass(fragmentClass)){
            Log.d(TAG, "myf:true")
            while (fragmentBackStack.peekLast()::class.java != fragmentClass){
                fragmentBackStack.pollLast()
            }
            fragmentBackStack.peekLast().arguments = bundle
            replaceFragment(fragmentBackStack.peekLast())
        }else{
            Log.d(TAG, "myf:false")
            super.push(fragmentClass,bundle)
        }
        Log.d(TAG, "myf:${fragmentBackStack.size}")
    }
}