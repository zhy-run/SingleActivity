package com.example.singleactivity

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.singleactivity.ktx.show
import kotlinx.android.synthetic.main.fragment2.*


class Fragment2: BaseFragment() {

    companion object{
        val fragment2ViewModel = Fragment2ViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //        val bundle = arguments
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.to21).setOnClickListener {  show(Fragment1::class.java){
            putString("title","aaaa")
        } }
        view.findViewById<TextView>(R.id.to22).setOnClickListener {  show(Fragment2::class.java) }
        view.findViewById<TextView>(R.id.to23).setOnClickListener {  show(Fragment3::class.java) }
        fragment2ViewModel.subscribe(this){ data: Fragment2Data ->
            onTextChanged(data)
        }
        editText.addTextChangedListener(mTextWatcher())
    }


    private fun onTextChanged(data: Fragment2Data) {
        show1EditText.text = data.editContent
    }

    class Fragment2ViewModel: ViewModel(){
        var _changeController = MutableLiveData<Fragment2Data>().apply {  }

        init {
//            _changeController.value = Fragment2Data("0")
        }

        fun subscribe(
            lifecycleOwner: LifecycleOwner,
            subscriber: (editContent: Fragment2Data) -> Unit
        ) {
            _changeController.observe(lifecycleOwner, Observer(subscriber))
        }
    }

    inner class mTextWatcher: TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int){
            s?.let { fragment2ViewModel._changeController.value = Fragment2Data(s.toString()) }
        }
        override fun afterTextChanged(s: Editable?){}
    }

    data class Fragment2Data(var editContent: String)
}