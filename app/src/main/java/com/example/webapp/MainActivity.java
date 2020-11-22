package com.example.webapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    WebView webVieww;
    EditText webURLL;
    Button btnSearchh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webVieww = findViewById(R.id.webView);
        webURLL = findViewById(R.id.webURL);
        btnSearchh = findViewById(R.id.btnSearch);


        btnSearchh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = webURLL.getText().toString();
                webVieww.getSettings().setLoadsImagesAutomatically(true);
                webVieww.getSettings().setJavaScriptEnabled(true);
                webVieww.setWebViewClient( new myWebViewClient());
                webVieww.loadUrl(url);
            }
        });
    }
    private class myWebViewClient extends WebViewClient {


        public boolean shouldOverrideUrlLoading (WebView view, String url){
            webVieww.loadUrl(url);
            return true;
        }


    }
}