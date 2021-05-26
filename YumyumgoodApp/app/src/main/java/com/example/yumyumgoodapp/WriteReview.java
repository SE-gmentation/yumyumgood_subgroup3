package com.example.yumyumgoodapp;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


public class WriteReview extends AppCompatActivity {

    EditText write_review;
    TextView count_letter;
    Button submit_button;
    ImageButton btnLike1;
    ImageButton btnDislike1;
    ImageButton btnLike2;
    ImageButton btnDislike2;
    ImageButton btnLike3;
    ImageButton btnDislike3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.write_review);

        write_review = (EditText) findViewById(R.id.writer);
        count_letter = (TextView) findViewById(R.id.counter);
        submit_button= (Button) findViewById(R.id.submit_review);

        btnLike1 = (ImageButton) findViewById(R.id.like1);
        btnDislike1 = (ImageButton) findViewById(R.id.dislike1);
        btnLike2 = (ImageButton) findViewById(R.id.like2);
        btnDislike2 = (ImageButton) findViewById(R.id.dislike2);
        btnLike3 = (ImageButton) findViewById(R.id.like3);
        btnDislike3 = (ImageButton) findViewById(R.id.dislike3);

        btnLike1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnLike1.setSelected(true);
                btnDislike1.setSelected(false);
            }
        });

        btnDislike1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnLike1.setSelected(false);
                btnDislike1.setSelected(true);
            }
        });
        btnLike2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnLike2.setSelected(true);
                btnDislike2.setSelected(false);
            }
        });

        btnDislike2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnLike2.setSelected(false);
                btnDislike2.setSelected(true);
            }
        });
        btnLike3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnLike3.setSelected(true);
                btnDislike3.setSelected(false);
            }
        });

        btnDislike3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnLike3.setSelected(false);
                btnDislike3.setSelected(true);
            }
        });




        submit_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                showDialog() ;
                //InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                //imm.hideSoftInputFromWindow(write_review.getWindowToken(),0);
            }
        });


        write_review.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String input = write_review.getText().toString();
                count_letter.setText(input.length()+" / 300 ");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }


    void showDialog() {
        AlertDialog.Builder msgBuilder = new AlertDialog.Builder(WriteReview.this)
                .setTitle("리뷰를 제출 하시겠습니까?")
                .setMessage("소중한 의견 감사합니다.")
                .setPositiveButton("제출", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(WriteReview.this, "리뷰가 성공적으로 제출되었습니다.", Toast.LENGTH_LONG).show();
                        finish();
                    }
                })
                .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        
                    }
                });
        AlertDialog msgDlg = msgBuilder.create();
        msgDlg.show();
    }
}