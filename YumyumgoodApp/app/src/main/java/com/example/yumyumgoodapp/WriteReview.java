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

    int like = 0;
    int dislike = 0;

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
                like ++;
            }
        });

        btnDislike1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnLike1.setSelected(false);
                btnDislike1.setSelected(true);
                dislike ++;
            }
        });
        btnLike2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnLike2.setSelected(true);
                btnDislike2.setSelected(false);
                like ++;
            }
        });

        btnDislike2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnLike2.setSelected(false);
                btnDislike2.setSelected(true);
                dislike ++;
            }
        });
        btnLike3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnLike3.setSelected(true);
                btnDislike3.setSelected(false);
                like ++;
            }
        });

        btnDislike3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnLike3.setSelected(false);
                btnDislike3.setSelected(true);
                dislike ++;
            }
        });


        /**Domain Model ??? Concept : ?????? ????????? ??????*/
        submit_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String input = write_review.getText().toString();
                if (input.length() < 6)                         /**case 2. ?????? 5??? ?????? ???????????? ????????? ??? dialog ??????*/
                    showErrorDialog() ;
                if (like + dislike < 3)                         /**case 1. ?????? ?????? ????????? ??? dialog ??????*/
                    showSelectLike();
                if (input.length() > 5 && like + dislike > 2)   /**?????? ??????????????? ?????? ????????? ????????? ?????? -> ?????? ?????? ??????*/
                    showDialog() ;
            }
        });


        /** ?????? ????????? ?????? ????????? ???????????? ????????? ?????? ??????*/
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
                .setMessage("????????? ?????? ???????????????????                                ????????? ?????? ???????????????.")
                .setPositiveButton("??????", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(WriteReview.this, "????????? ??????????????? ?????????????????????.", Toast.LENGTH_LONG).show();
                        finish();
                    }
                })
                .setNegativeButton("??????", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        AlertDialog msgDlg = msgBuilder.create();
        msgDlg.show();
    }

    void showErrorDialog() {
        AlertDialog.Builder msgBuilder = new AlertDialog.Builder(WriteReview.this)
                .setTitle("")
                .setMessage("?????? 5?????? ?????? ????????? ?????????.")
                .setNegativeButton("??????", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        AlertDialog msgErrDlg = msgBuilder.create();
        msgErrDlg.show();
    }

    void showSelectLike() {
        AlertDialog.Builder msgBuilder = new AlertDialog.Builder(WriteReview.this)
                .setTitle("")
                .setMessage("?????? ????????? ?????? ????????? ???????????? ?????????.")
                .setNegativeButton("??????", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        AlertDialog msgErrDlg = msgBuilder.create();
        msgErrDlg.show();
    }
}