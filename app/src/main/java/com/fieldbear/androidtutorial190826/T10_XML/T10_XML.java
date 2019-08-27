package com.fieldbear.androidtutorial190826.T10_XML;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Xml;
import android.widget.TextView;

import com.fieldbear.androidtutorial190826.R;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.net.MalformedURLException;
import java.net.URL;

public class T10_XML extends AppCompatActivity {


    TextView textViewWeather;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t10__xml);
        textViewWeather = findViewById(R.id.textViewWeather);

        String url = "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1159068000";
        new MyXmlTask().execute(url);
    }

    class MyXmlTask extends AsyncTask<String, Void, String>{
        @Override
        protected String doInBackground(String... strings) {
            String res = "";

            try {
                URL url = new URL(strings[0]);
                XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                XmlPullParser xpp = factory.newPullParser();
                xpp.setInput(url.openStream(), "utf-8");

                boolean bRead = false;
                int event = xpp.getEventType();
                while (event != XmlPullParser.END_DOCUMENT){
                    if(event == XmlPullParser.START_TAG){
                        String tagName = xpp.getName();
                        if(tagName.equals("hour") || tagName.equals("day")
                        || tagName.equals("temp") || tagName.equals("wfKor")){
                            bRead = true;
                        }
                    }else if(event == XmlPullParser.TEXT){
                        if(bRead == true) {
                            res += xpp.getText() + " ";
                            bRead = false;
                        }
                    }
                    event = xpp.next();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }


            return res;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            textViewWeather.setText(s);
        }
    }
}
