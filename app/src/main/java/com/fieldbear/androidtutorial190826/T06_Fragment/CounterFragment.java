package com.fieldbear.androidtutorial190826.T06_Fragment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.fieldbear.androidtutorial190826.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CounterFragment extends Fragment {


    public CounterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_counter, container, false);
        final TextView textViewCounter = v.findViewById(R.id.textViewCounter);
        Button btnIncrease = v.findViewById(R.id.btnIncrease);
        btnIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = textViewCounter.getText().toString();
                int value = Integer.parseInt(str);
                value += 1;
                textViewCounter.setText(value+"");
            }
        });
        return v;
    }
}
