package com.fieldbear.androidtutorial190826.T07_ViewPager;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fieldbear.androidtutorial190826.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyBlankFragment1 extends Fragment {


    public MyBlankFragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_blank_fragment1, container, false);
    }

}
