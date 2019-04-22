package com.doozycod.edutek;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        webView = findViewById(R.id.webview);

        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        String url = bundle.getString("url", "");
        Log.e("URL ---->", url);
        webView.setVerticalScrollBarEnabled(true);
        webView.setHorizontalScrollBarEnabled(false);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        webView.loadUrl(url);
        webView.setWebViewClient(new WebViewClient(){
            public void onPageFinished(WebView view, String url) {


                view.evaluateJavascript(url, new ValueCallback<String>() {
                    @Override
                    public void onReceiveValue(String value) {


                    }
                });


            }

        });

    }
}
