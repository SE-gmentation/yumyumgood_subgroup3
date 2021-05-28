package com.example.yumyumgoodapp

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.order_history.*

class OrderHistory : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.order_history)

        val ddays : TextView = findViewById(R.id.days)
        val ddays2 : TextView = findViewById(R.id.days2)
        val ddays3 : TextView = findViewById(R.id.days3)
        val ddays4 : TextView = findViewById(R.id.days4)

        val passDays1 = ddays.text.toString().toInt()
        val passDays2 = ddays2.text.toString().toInt()
        val passDays3 = ddays3.text.toString().toInt()
        val passDays4 = ddays4.text.toString().toInt()

        btnWriteReview.setOnClickListener{
            val intent = Intent(this, WriteReview::class.java)
            startActivity(intent)
        }

        if (passDays1 > 3){
            msg_pass.text = "리뷰 작성 가능 기간이 지났습니다."
            btnWriteReview.isEnabled = false
        }
        else
            btnWriteReview.isEnabled = true

        if (passDays2 > 3){
            msg_pass2.text = "리뷰 작성 가능 기간이 지났습니다."
            btnWriteReview2.isEnabled = false
        }
        else
            btnWriteReview2.isEnabled = true

        if (passDays3 > 3){
            msg_pass3.text = "리뷰 작성 가능 기간이 지났습니다."
            btnWriteReview3.isEnabled = false
        }
        else
            btnWriteReview3.isEnabled = true

        if (passDays4 > 3){
            msg_pass4.text = "리뷰 작성 가능 기간이 지났습니다."
            btnWriteReview4.isEnabled = false
        }
        else
            btnWriteReview4.isEnabled = true

        btnViewBuilding.setOnClickListener{
            val intent = Intent(this, ViewBuilding::class.java)
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