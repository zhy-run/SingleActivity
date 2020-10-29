package com.example.singleactivity

import android.os.Bundle
import androidx.fragment.app.Fragment

interface IFragmentStack {
    fun <FragmentContainer:Fragment> push(fragmentClass: Class<FragmentContainer>, bundle: (Bundle.() -> Unit)?=null)
    fun peek():Fragment?
    fun poll():Fragment?
    fun empty():Boolean
    fun stackSize():Int
    fun clear()
}
