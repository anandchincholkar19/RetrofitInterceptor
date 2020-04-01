package com.example.retrofitinterceptor.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.retrofitinterceptor.R
import com.example.retrofitinterceptor.viewmodel.DemoViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        private val TAG = MainActivity.javaClass.simpleName
    }

    private var demoViewModel: DemoViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        demoViewModel = ViewModelProviders.of(this).get(DemoViewModel::class.java)

        button.setOnClickListener {
            demoViewModel?.getTodoListFromRepository()
        }

        demoViewModel?.todoLiveData?.observe(this, Observer { it ->
            //textView.text = it.toString()
            Log.e("Main Activity :" , it.toString())
        })
//
//        demoViewModel?.progressLiveData?.observe(this, Observer {
//            if (it) {
//                textView.setText("loading.............")
//            } else {
//                textView.setText("")
//            }
//        })


    }
}
