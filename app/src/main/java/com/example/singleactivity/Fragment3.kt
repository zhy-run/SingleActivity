package com.example.singleactivity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.singleactivity.ktx.show


class Fragment3: BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //        val bundle = arguments
        return inflater.inflate(R.layout.fragment3, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.to31).setOnClickListener {  show(Fragment1::class.java) }
        view.findViewById<TextView>(R.id.to32).setOnClickListener {  show(Fragment2::class.java) }
        view.findViewById<TextView>(R.id.to33).setOnClickListener {  show(Fragment3::class.java) }
    }
}