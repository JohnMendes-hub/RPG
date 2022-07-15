package johnmendes.com.example.magiclifecounter.activitys;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import johnmendes.com.example.magiclifecounter.R;

public class ClasseSelecionadaActivity extends AppCompatActivity {

    private WebView webView;
    Uri pdf = Uri.parse("https://drive.google.com/file/d/1tnURucdtFIgb5OdDQKLUlihks6KUWnla/view?usp=sharing");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classe_selecionada);

        final ProgressBar progressBar = findViewById(R.id.progress);
        progressBar.setVisibility(View.INVISIBLE);

        webView = findViewById(R.id.webview);
        webView.loadUrl("https://drive.google.com/file/d/1tnURucdtFIgb5OdDQKLUlihks6KUWnla/view?usp=sharing");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setSupportZoom(true);
        webView.setWebViewClient(new WebViewClient());

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressBar.setVisibility(View.VISIBLE); // mostra a progress
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBar.setVisibility(View.INVISIBLE); // esconde a progress
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }

}