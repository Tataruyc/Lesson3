package ru.mirea.seyfetdinov.r.n.mireaproject;

import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MyWedViewClient extends WebViewClient {

    @SuppressWarnings("deprecation")
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }

}
