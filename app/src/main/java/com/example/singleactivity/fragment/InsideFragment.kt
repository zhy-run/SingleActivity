package com.example.singleactivity.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.singleactivity.R


class insideFragment: Fragment() {

    private val mbtInside by lazy {
        view?.findViewById<TextView>(R.id.insideButton)
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        //        val bundle = arguments
        return inflater.inflate(R.layout.inside_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mbtInside?.setOnClickListener {
            activity?.supportFragmentManager?.let { it1 -> MyDialogFragment().show(it1,"") }
//            Log.d("123", "myf $activity")
        }
    }
}