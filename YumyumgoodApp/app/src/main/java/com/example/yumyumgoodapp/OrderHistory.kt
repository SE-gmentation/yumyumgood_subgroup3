package com.example.yumyumgoodapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
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

        btnWriteReview2.setOnClickListener {
            Toast.makeText(this@OrderHistory, "주문 후 3일 이내만 리뷰를 작성할 수 있습니다.", Toast.LENGTH_LONG).show()
        }
        btnWriteReview3.setOnClickListener {
            Toast.makeText(this@OrderHistory, "주문 후 3일 이내만 리뷰를 작성할 수 있습니다.", Toast.LENGTH_LONG).show()
        }
        btnWriteReview4.setOnClickListener {
            Toast.makeText(this@OrderHistory, "주문 후 3일 이내만 리뷰를 작성할 수 있습니다.", Toast.LENGTH_LONG).show()
        }
    }
}