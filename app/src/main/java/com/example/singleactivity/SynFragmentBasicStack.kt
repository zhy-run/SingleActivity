package com.example.singleactivity

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import java.util.concurrent.LinkedBlockingDeque


open class SynFragmentBasicStack(private val activity: SingleActivity):IFragmentStack {
    val fragmentBackStack = LinkedBlockingDeque<Fragment>()
    private val fragmentManager = activity.supportFragmentManager
    private val mainFragmentID = activity.mainFragmentID

    companion object{
        private const val TAG = "FragmentBasicStack"
    }

    /** 入栈 */
    override fun <FragmentContainer:Fragment> push(fragmentClass: Class<FragmentContainer>, bundle: (Bundle.() -> Unit)?) {
        Log.d(TAG, "myf:superpush")
        val fragment = fragmentClass.newInstance()
        bundle?.let { fragment.arguments = Bundle().apply(it) }
        fragmentBackStack.addLast(fragment)
        replaceFragment(fragment)
    }

    /** 返回栈顶元素 */
    override fun peek():Fragment? {
        return fragmentBackStack.peekLast()
    }

    /** 移出栈顶元素 */
    override fun poll():Fragment? {
        if (stackSize() == 1) {
            activity.finish()
        }
        val result = fragmentBackStack.pollLast()
        fragmentBackStack.peekLast()?.let { replaceFragment(it) }
        Log.d(TAG, "myf:${stackSize()}")
        return result
    }

    /** 栈是否为空 */
    override fun empty():Boolean {
        return fragmentBackStack.isEmpty()
    }

    /** 返回栈的大小 */
    override fun stackSize():Int{
        return fragmentBackStack.size
    }

    /** 清空栈 */
    override fun clear() {
        if(!empty()){
            fragmentBackStack.clear()
        }
    }

    fun replaceFragment(fragment: Fragment){
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(mainFragmentID,fragment)
        transaction.commit()
    }

    fun <FragmentContainer : Fragment>containsClass(fragmentClass: Class<FragmentContainer>):Boolean{
        if(fragmentBackStack.isEmpty()) return false
        val iterator = fragmentBackStack.iterator()
        while (iterator.hasNext()){
            if(iterator.next()::class.java == fragmentClass){
                return true
            }
        }
        return false
    }

/*    fun removeFragment(fragment: Fragment) {
        val transaction = fragmentManager.beginTransaction()
        transaction.remove(fragment)
        transaction.commit()
    }

    fun addFragment(fragment: Fragment) {
        Log.d(TAG, "myf:superadd")
        val transaction = fragmentManager.beginTransaction()
        transaction.add(activity.mainFragmentID,fragment)
        transaction.commit()
    }

    fun hideFragment(fragment: Fragment) {
        val transaction = fragmentManager.beginTransaction()
        transaction.hide(fragment)
        transaction.commit()
    }

    fun showFragment(fragment: Fragment) {
        val transaction = fragmentManager.beginTransaction()
        transaction.show(fragment)
        transaction.commit()
    }*/
}
