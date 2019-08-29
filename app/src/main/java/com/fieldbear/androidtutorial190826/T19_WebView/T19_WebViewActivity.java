package com.fieldbear.androidtutorial190826.T19_WebView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.fieldbear.androidtutorial190826.R;

public class T19_WebViewActivity extends AppCompatActivity {

    WebView mWebView;
    ProgressBar mProgressBar;
    WebChromeClient mWebChromeClient = new WebChromeClient(){
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);

            if(newProgress == 100){
                mProgressBar.setVisibility(View.INVISIBLE);
            }else{
                mProgressBar.setVisibility(View.VISIBLE);
                mProgressBar.setProgress(newProgress);
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t19__web_view);

        mProgressBar = findViewById(R.id.progress_bar);
        mWebView = findViewById(R.id.myWebView);
        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);

        mWebView.setWebViewClient(new WebViewClient());
        mWebView.setWebChromeClient(mWebChromeClient);
        mWebView.loadUrl("http://www.daum.net");
    }

    @Override
    public void onBackPressed() {
        if(mWebView.canGoBack()){
            mWebView.goBack();
        }else {
            super.onBackPressed();
        }
    }
}
