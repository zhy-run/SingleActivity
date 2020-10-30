package com.example.singleactivity.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.singleactivity.R

class fragment6:BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //        val bundle = arguments
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment6, container, false)
    }
}