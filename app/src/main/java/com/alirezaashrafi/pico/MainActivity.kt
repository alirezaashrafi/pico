package com.alirezaashrafi.pico

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.alirezaashrafi.library.Pico
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_main)

        Pico.with(this)
                .from("")
                .into(img1)


    }

}
