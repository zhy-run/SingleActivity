package com.example.singleactivity.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.singleactivity.*
import com.example.singleactivity.Adapter.MyAdapter
import com.example.singleactivity.ktx.show
import kotlinx.android.synthetic.main.fragment1.*


class Fragment1: BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //        val bundle = arguments
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        to11.setOnClickListener {  show(Fragment1::class.java) }
        to12.setOnClickListener { show(Fragment2::class.java) }
        to13.setOnClickListener {  show(Fragment3::class.java) }
        val recycler = view.findViewById<RecyclerView>(R.id.recycler)
        recycler.layoutManager = LinearLayoutManager(this.context)
        recycler.adapter = MyAdapter()
        Toast.makeText(context, "${this.arguments?.getString("title")}", Toast.LENGTH_SHORT).show()
        Fragment2.fragment2ViewModel.subscribe(this){ data: Fragment2.Fragment2Data ->
            onTextChanged(data)
        }
    }

    private fun onTextChanged(data: Fragment2.Fragment2Data) {
        textshow2.text = data.editContent
    }

}