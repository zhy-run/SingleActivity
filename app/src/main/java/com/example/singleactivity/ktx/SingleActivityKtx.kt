package com.example.singleactivity.ktx

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.singleactivity.SingleActivity

fun <FragmentContainer: Fragment> SingleActivity.initFragmentStack(fragmentClass:Class<FragmentContainer>, args: (Bundle.()->Unit)?=null){
    if(fragmentStackList[stackPosition].empty()){
        fragmentStackList[stackPosition].push(fragmentClass,args)
    }
    val transaction = supportFragmentManager.beginTransaction()
    transaction.replace(mainFragmentID,fragmentStackList[stackPosition].peek()!!)
    transaction.commit()
}