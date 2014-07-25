package com.example.withkenta;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.Button;

public class MainActivity extends ActionBarActivity implements OnClickListener {
    private EditText mEditText;
    private WebView mWebView;
    private Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        getSupportActionBar().setHomeButtonEnabled(true);
        
        mEditText = (EditText) findViewById(R.id.edit);
        findViewById(R.id.btn).setOnClickListener(this);
        mButton = (Button) findViewById(R.id.btn);
        mButton.setText("検索");
        mWebView = (WebView) findViewById(R.id.webview);
        mWebView.setWebViewClient(new WebViewClient());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        
        if (id == android.R.id.home) {
            mWebView.setVisibility(View.GONE);
            return true;
        }
        
        return super.onOptionsItemSelected(item);
    }
    
    @Override
    protected void onDestroy() {
        mWebView.destroy();
        super.onDestroy();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn) {
            String content = mEditText.getText().toString();
            
            String query = "https://www.google.co.jp/search?q="+content+"+原健太";
            
            mWebView.loadUrl(query);
            mWebView.setVisibility(View.VISIBLE);
        }
    }
}
