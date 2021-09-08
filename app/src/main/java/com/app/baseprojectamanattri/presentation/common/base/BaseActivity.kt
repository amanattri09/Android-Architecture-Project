package com.app.baseprojectamanattri.presentation.common.base

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract open class BaseActivity<Binding:ViewBinding> : AppCompatActivity() {

    lateinit var binding: Binding

    fun setContentView(binding:Binding){
        this.binding=binding
        setContentView(binding.root)
    }

    fun showToast(msg: String? ="Something went wrong !!"){
        Toast.makeText(this,msg?:"Showed null value !!",Toast.LENGTH_SHORT).show()
    }

}