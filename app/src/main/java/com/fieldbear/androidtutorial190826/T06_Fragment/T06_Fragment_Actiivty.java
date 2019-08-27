package com.fieldbear.androidtutorial190826.T06_Fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.fieldbear.androidtutorial190826.R;

public class T06_Fragment_Actiivty extends AppCompatActivity
                                implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t06__fragment__actiivty);

        findViewById(R.id.btnAdd).setOnClickListener(this);
        findViewById(R.id.btnRemove).setOnClickListener(this);
        findViewById(R.id.btnReplace).setOnClickListener(this);
        findViewById(R.id.btnHide).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.frame);

        switch (v.getId()){
            case R.id.btnAdd:
                if(fragment == null){
                   fragment = new CounterFragment();
                   FragmentTransaction transaction = fm.beginTransaction();
                   transaction.add(R.id.frame, fragment,"counter");
                   transaction.commit();
                }
                break;
            case R.id.btnRemove:
                if(fragment != null){
                    FragmentTransaction transaction = fm.beginTransaction();
                    transaction.remove(fragment);
                    transaction.commit();
                }
                break;
            case R.id.btnReplace:
                if(fragment != null){
                    FragmentTransaction transaction = fm.beginTransaction();
                    if(fragment.getTag().equals("counter")){
                        BlankFragment newFragment = new BlankFragment();
                        transaction.replace(R.id.frame, newFragment, "blank");
                    }else{
                        CounterFragment newFragment = new CounterFragment();
                        transaction.replace(R.id.frame, newFragment, "counter");
                    }
                    transaction.commit();
                }
                break;
            case R.id.btnHide:
                if(fragment != null) {
                    FragmentTransaction transaction = fm.beginTransaction();
                    if (fragment.isHidden())
                        transaction.show(fragment);
                    else
                        transaction.hide(fragment);

                    transaction.commit();
                }
                break;
        }
    }
}
