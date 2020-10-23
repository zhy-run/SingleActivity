package com.example.singleactivity.ktx

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.singleactivity.SingleActivity

@JvmOverloads
fun <FragmentContainer:Fragment>Fragment.show(
        fragmentClazz: Class<FragmentContainer>,
        args: (Bundle.() -> Unit)? = null
) {
    if(args!=null){
        val bundle = Bundle().apply(args)
        SingleActivity.fragmentStack.push(fragmentClazz,bundle)
    }else{
        SingleActivity.fragmentStack.push(fragmentClazz,null)
    }
}