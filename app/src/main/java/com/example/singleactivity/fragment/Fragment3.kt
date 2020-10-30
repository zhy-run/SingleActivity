package com.example.singleactivity.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.singleactivity.R
import com.example.singleactivity.ktx.show
import kotlinx.android.synthetic.main.fragment3.*


class Fragment3: BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //        val bundle = arguments
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment3, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        to31.setOnClickListener {  show(Fragment1::class.java) }
        to32.setOnClickListener {  show(Fragment2::class.java) }
        to33.setOnClickListener {  show(Fragment3::class.java) }
    }
}