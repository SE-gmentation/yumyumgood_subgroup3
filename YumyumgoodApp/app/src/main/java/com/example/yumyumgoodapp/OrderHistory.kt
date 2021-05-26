package com.example.yumyumgoodapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.order_history.*

class OrderHistory : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.order_history)

        btnWriteReview.setOnClickListener{

            val intent = Intent(this, WriteReview::class.java)
            startActivity(intent)

        }
    }
}