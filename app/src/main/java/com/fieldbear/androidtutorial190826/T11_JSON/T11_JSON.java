package com.fieldbear.androidtutorial190826.T11_JSON;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.fieldbear.androidtutorial190826.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class T11_JSON extends AppCompatActivity {

    String str = "[{'name':'kim', 'tel':'010-1234-1234', 'age': 11}," +
            "{'name':'park', 'tel':'010-1111-2222', 'age':22}," +
            "{'name':'lee', 'tel':'010-0000-0000', 'age':33}]";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t11__json);
    }

    private void jsonParsing() throws JSONException {
        ArrayList<MyUser> myUserArrayList = new ArrayList<>();
        JSONArray array = new JSONArray(str);
        for(int i=0; i<array.length(); i++){
            JSONObject object = array.getJSONObject(i);
            String name = object.getString("name");
            String tel = object.getString("tel");
            int age = object.getInt("age");

            MyUser user = new MyUser(name, tel, age);
            myUserArrayList.add(user);
        }
    }
}
