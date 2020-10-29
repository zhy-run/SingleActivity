package com.example.singleactivity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.singleactivity.ktx.show
import kotlinx.android.synthetic.main.fragment4.*

class Fragment4: BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //        val bundle = arguments
        return inflater.inflate(R.layout.fragment4, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        to41.setOnClickListener {  show(Fragment1::class.java) }
        to42.setOnClickListener {  show(Fragment2::class.java) }
        to43.setOnClickListener {  show(Fragment3::class.java) }
    }
}