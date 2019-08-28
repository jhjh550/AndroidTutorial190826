package com.fieldbear.androidtutorial190826.T16_Style;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
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

        int number = 1;
        LinearLayout rootLayout = findViewById(R.id.rootLayout);
        for(int i=2; i<rootLayout.getChildCount()-1; i++){
            LinearLayout rowLayout = (LinearLayout) rootLayout.getChildAt(i);
            for(int k=0; k<rowLayout.getChildCount(); k++){
                Button button = (Button) rowLayout.getChildAt(k);
                button.setText(number+"");
                number++;
                button.setOnClickListener(numberClickListener);
            }
        }

        LinearLayout bottomRow = (LinearLayout)
        rootLayout.getChildAt( rootLayout.getChildCount() -1);
        Button zeroButton = (Button) bottomRow.getChildAt(1);
        zeroButton.setOnClickListener(numberClickListener);
        zeroButton.setText("0");

        Button enterButton = (Button) bottomRow.getChildAt(2);
        enterButton.setText("enter");
        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String working = workingTextView.getText().toString();
                selectedTextView.setText(working);
                workingTextView.setText("0");
            }
        });

        Button deleteButton = (Button) bottomRow.getChildAt(0);
        deleteButton.setText("Delete");
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workingTextView.setText("0");
            }
        });



    }
}
