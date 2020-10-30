package com.example.singleactivity.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.example.singleactivity.Adapter.viewPagerAdapter
import com.example.singleactivity.R
import com.example.singleactivity.ktx.show
import kotlinx.android.synthetic.main.fragment4.*

class Fragment4: BaseFragment() {

    private val mOnPageChangeCallback = object : ViewPager2.OnPageChangeCallback() {

        override fun onPageSelected(position: Int) {
            Toast.makeText(context,"show fragment ${position+5}",Toast.LENGTH_SHORT).show()
        }
    }

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
        viewpager2.adapter = viewPagerAdapter(childFragmentManager,lifecycle)
        viewpager2.registerOnPageChangeCallback(mOnPageChangeCallback)
    }

}

