package com.example.singleactivity.ktx

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.singleactivity.SingleActivity

@JvmOverloads
fun <FragmentContainer:Fragment>Fragment.show(
        fragmentClazz: Class<FragmentContainer>,
        args: (Bundle.() -> Unit)? = null
) {
    (activity as SingleActivity).fragmentStackList[(activity as SingleActivity).stackPosition].push(fragmentClazz,args)
}