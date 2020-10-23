package com.example.singleactivity

import android.os.Bundle
import androidx.fragment.app.Fragment

interface IFragmentStack {
    fun <FragmentContainer:Fragment> push(fragmentClass:Class<FragmentContainer>,bundle: Bundle?)
    fun peek():Fragment
    fun pop():Fragment
    fun empty():Boolean
    fun stackSize():Int
}