package com.example.yumyumgoodapp;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class WriteReview extends AppCompatActivity {

    EditText write_review;
    TextView count_letter;
    Button submit_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.write_review);

        write_review = (EditText) findViewById(R.id.writer);
        count_letter = (TextView) findViewById(R.id.counter);
        submit_button= (Button) findViewById(R.id.submit_review);


        submit_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(write_review.getWindowToken(),0);
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

}