package com.example.singleactivity

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment

class SingleTaskFragmentStack(activity: SingleActivity): FragmentBasicStack(activity) {

    companion object{
        private const val TAG = "SingleTaskFragmentStack"
    }

    override fun <FragmentContainer : Fragment> push(fragmentClass: Class<FragmentContainer>, bundle: (Bundle.() -> Unit)?) {
        if(containsClass(fragmentClass)){
            Log.d(TAG, "myf:true")
            var iterator = fragmentBackStack.iterator()
            while (iterator.hasNext()){
                var temp = iterator.next()
                if(temp::class.java == fragmentClass){
                    bundle?.let { temp.arguments = Bundle().apply(it) }
                    replaceFragment(temp)
                    break
                }else{
                    iterator.remove()
                }
            }
        }else{
            Log.d(TAG, "myf:false")
            super.push(fragmentClass,bundle)
        }
        Log.d(TAG, "myf:${fragmentBackStack.size}")
    }
}