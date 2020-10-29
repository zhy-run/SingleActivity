package com.example.singleactivity

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.singleactivity.ktx.show
import kotlinx.android.synthetic.main.fragment1.*
import kotlinx.android.synthetic.main.fragment2.*


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
        Fragment2.fragment2ViewModel.subscribe(this){data: Fragment2.Fragment2Data ->
            onTextChanged(data)
        }
    }

    private fun onTextChanged(data: Fragment2.Fragment2Data) {
        textshow2.text = data.editContent
    }

}