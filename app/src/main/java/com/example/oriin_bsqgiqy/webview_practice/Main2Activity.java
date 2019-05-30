package com.example.oriin_bsqgiqy.webview_practice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        WebView wv1 = findViewById(R.id.wv1);
        wv1.getSettings().setJavaScriptEnabled(true);

        Intent gi = getIntent();
        int a =  gi.getIntExtra("a",1);
        int b =  gi.getIntExtra("b",1);
        int c =  gi.getIntExtra("c",1);

        String url = "https://www.google.co.il/search?ei=DXVCXKS6LbHrsgPV-YGYDw&q="+a+"x%5E2%2B"+b+"x%2B"+c+"&oq";
        wv1.setWebViewClient(new WebViewClient());
        wv1.loadUrl(url);
    }

    public void return1(View view) {
        finish();
    }
}
