package com.alirezaashrafi.pico

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.alirezaashrafi.library.Pico
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    var imgLink1 = "https://raw.githubusercontent.com/alirezaashrafi/pico/master/images/img1.png"
    var imgLink2 = "https://raw.githubusercontent.com/alirezaashrafi/pico/master/images/img2.png"
    var imgLink3 = "https://raw.githubusercontent.com/alirezaashrafi/pico/master/images/img3.png"
    var imgLink4 = "https://raw.githubusercontent.com/alirezaashrafi/pico/master/images/img4.png"
    var imgLink5 = "https://raw.githubusercontent.com/alirezaashrafi/pico/master/images/img5.png"
    var imgLink6 = "https://raw.githubusercontent.com/alirezaashrafi/pico/master/images/img6.png"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Pico.with(this)
                .from(imgLink1)
                .into(img1)


    }

}
