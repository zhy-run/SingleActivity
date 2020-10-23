package com.example.singleactivity

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import java.util.*

class synSingle(activity: SingleActivity): synStack(activity) {

    companion object{
        private const val TAG = "synSingle"
    }

    @SuppressLint("LongLogTag")
    override fun <FragmentContainer : Fragment> push(fragmentClass: Class<FragmentContainer>,bundle:Bundle?) {
        if(containsClass(fragmentClass)){
//            Log.d(TAG, "myf:true")
//            var iterator = fragmentBackStack.iterator()
//            while (iterator.hasNext()){
//                var findFlag = false
//                var temp = iterator.next()
//                if(findFlag){
//                    iterator.remove()
//                }
//                if(temp::class.java == fragmentClass && !findFlag){
//                    replaceFragment(temp)
//                    findFlag = true
//                }
//            }

//            var iterator = fragmentBackStack.iterator()
//            while (iterator.hasNext()){
//                var temp = iterator.next()
//                if(temp::class.java == fragmentClass){
//                    replaceFragment(temp)
//                    break
//                }else{
//                    iterator.remove()
//                }
//            }

            for (i in fragmentBackStack.size downTo 1){
                if(fragmentBackStack[i-1]::class.java == fragmentClass){
                    fragmentBackStack[i-1].arguments = bundle
                    replaceFragment(fragmentBackStack[i-1])
                    break
                }else{
                    fragmentBackStack.removeAt(i-1)
                }
            }
        }else{
            Log.d(TAG, "myf:false")
            super.push(fragmentClass,bundle)
        }
        Log.d(TAG, "myf:${fragmentBackStack.size}")
    }
}