package com.example.singleactivity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.singleactivity.ktx.show


class Fragment1: BaseFragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        //        val bundle = arguments
        return inflater.inflate(R.layout.fragment1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.to11).setOnClickListener {  show(Fragment1::class.java) }
        view.findViewById<TextView>(R.id.to12).setOnClickListener {  show(Fragment2::class.java) }
        view.findViewById<TextView>(R.id.to13).setOnClickListener {  show(Fragment3::class.java) }
        val recycler = view.findViewById<RecyclerView>(R.id.recycler)
        recycler.layoutManager = LinearLayoutManager(this.context)
        recycler.adapter = MyAdapter()
        Toast.makeText(context,"${this.arguments?.getString("title")}",Toast.LENGTH_SHORT).show()
    }
}