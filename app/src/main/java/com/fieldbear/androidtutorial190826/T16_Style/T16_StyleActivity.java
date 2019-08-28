package com.fieldbear.androidtutorial190826.T16_Style;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.fieldbear.androidtutorial190826.R;

public class T16_StyleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t16__style);

        final TextView selectedTextView = findViewById(R.id.selectedTextView);
        final TextView workingTextView = findViewById(R.id.workingTextView);

        View.OnClickListener numberClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button) v;
                String working = workingTextView.getText().toString();
                String text = button.getText().toString();
                if(working.equals("0")){
                    workingTextView.setText(text);
                }else{
                    workingTextView.setText(working+text);
                }
            }
        };

//        Button zeroButton = findViewById(R.id.btnZero);
//        zeroButton.setOnClickListener(numberClickListener);
//        Button oneButton = findViewById(R.id.btnOne);
//        oneButton.setOnClickListener(numberClickListener);
//
//        Button enterButton = findViewById(R.id.btnEnter);
//        enterButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String working = workingTextView.getText().toString();
//                selectedTextView.setText(working);
//                workingTextView.setText("0");
//            }
//        });




    }
}
