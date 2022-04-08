package com.hoogle.quoteslibrary;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment5 extends Fragment {
    public WebView mWebView;
    public AdView adView;
    Bundle webViewBundle;
    public BlankFragment5() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view
                = inflater.inflate(R.layout.fragment_blank_fragment5, container, false);
        mWebView = (WebView) view.findViewById(R.id.hy);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setSupportZoom(true);
        mWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        mWebView.getSettings().setAllowFileAccess(true);
        mWebView.getSettings().setBuiltInZoomControls(true);
        mWebView.getSettings().setDisplayZoomControls(true);
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);

        mWebView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        mWebView.setVerticalScrollBarEnabled(true);
        mWebView.setHorizontalScrollBarEnabled(true);

        this.mWebView.getSettings().setDomStorageEnabled(true);
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl("file:///android_asset/index.html");

        AdRequest adRequest = new AdRequest.Builder().build();
        adView = (AdView) view.findViewById(R.id.ad9View);
        adView.loadAd(adRequest);
        adView = (AdView) view.findViewById(R.id.ad13View);
        adView.loadAd(adRequest);
        adView = (AdView) view.findViewById(R.id.ad14View);
        adView.loadAd(adRequest);
        adView = (AdView) view.findViewById(R.id.ad10View);
        adView.loadAd(adRequest);
        adView = (AdView) view.findViewById(R.id.ad11View);
        adView.loadAd(adRequest);
        adView = (AdView) view.findViewById(R.id.ad12View);
        adView.loadAd(adRequest);
        adView = (AdView) view.findViewById(R.id.earn1);
        adView.loadAd(adRequest);
        adView = (AdView) view.findViewById(R.id.earn2);
        adView.loadAd(adRequest);
        adView = (AdView) view.findViewById(R.id.earn3);
        adView.loadAd(adRequest);
        adView = (AdView) view.findViewById(R.id.earn4);
        adView.loadAd(adRequest);
        adView = (AdView) view.findViewById(R.id.earn5);
        adView.loadAd(adRequest);

        return view;
    }

}
