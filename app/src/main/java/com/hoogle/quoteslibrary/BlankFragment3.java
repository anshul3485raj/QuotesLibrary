package com.hoogle.quoteslibrary;


import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment3 extends Fragment {
    Bundle webViewBundle;
    public Handler h;
    ProgressBar progressBar;
    public AdView adView;
    public WebView mWebView;
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mWebView.saveState(outState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mWebView.restoreState(savedInstanceState);
    }
    public BlankFragment3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view
                = inflater.inflate(R.layout.fragment_blank_fragment3, container, false);
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        progressBar.setMax(100);
        progressBar.setProgress(1);




        mWebView = (WebView) view.findViewById(R.id.hu);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setSupportZoom(true);
        mWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        mWebView.getSettings().setBuiltInZoomControls(true);
        mWebView.getSettings().setDisplayZoomControls(true);
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.getSettings().setAllowFileAccess(true);
        mWebView.setVerticalScrollBarEnabled(true);
        mWebView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);

        mWebView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        mWebView.setHorizontalScrollBarEnabled(true);
        this.mWebView.getSettings().setDomStorageEnabled(true);

        mWebView.loadUrl("https://www.brainyquote.com/topics/cute_quotes");

        AdRequest adRequest = new AdRequest.Builder().build();
        adView = (AdView) view.findViewById(R.id.ad9View);
        adView.loadAd(adRequest);
        adView = (AdView) view.findViewById(R.id.ad10View);
        adView.loadAd(adRequest);
        adView = (AdView) view.findViewById(R.id.ad11View);
        adView.loadAd(adRequest);
        adView = (AdView) view.findViewById(R.id.ad12View);

        adView = (AdView) view.findViewById(R.id.ad13View);
        adView.loadAd(adRequest);
        adView = (AdView) view.findViewById(R.id.ad14View);
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
        mWebView.setOnKeyListener(new View.OnKeyListener(){

            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK
                        && event.getAction() == MotionEvent.ACTION_UP
                        && mWebView.canGoBack())
                {
                    mWebView.goBack();
                    return true;
                }
                return false;

            }

        });    mWebView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                progressBar.setProgress(progress);
            }
        });
        mWebView.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {

                mWebView.loadUrl("file:///android_asset/error.html");

            }
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressBar.setVisibility(View.VISIBLE);


            }



            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {


                boolean overrideUrlLoading = true;
                if (url != null && url.startsWith("whatsapp://send")) {

                    Intent shareIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));


                    startActivity(shareIntent);
                    Intent text = new Intent();
                    text.setAction("android.inte-nt.action.SEND");
                    text.setType("text/plain");
                    text.putExtra("android.intent.extra.TEXT", " Hi, I am using the NEWS app to get updated with news every day. I like this app  and want you to check it out. click on this to download hindi version ------> https://play.google.com/store/apps/details?id=com.hoogle.news  click on this link to download English version ---------->https://play.google.com/store/apps/details?id=com.hoogle.news2");

                    startActivity(Intent.createChooser(text, "Share are app with other and help us to grow "));

                    startActivity(shareIntent);


                } else if (url != null && url.startsWith("https://www.facebook.com/")) {
                    final Snackbar snackbar = Snackbar.make(view, "Sorry but share through whats'app is only available.This feature will be added soon ", Snackbar.LENGTH_LONG);
                    // Get the Snackbar's layout view
                    Snackbar.SnackbarLayout layout = (Snackbar.SnackbarLayout) snackbar.getView();
                    // Hide the text
                    TextView textView = (TextView) layout.findViewById(android.support.design.R.id.snackbar_text);
                    textView.setVisibility(View.INVISIBLE);

                    // Inflate our custom view
                    View snackView = getLayoutInflater().inflate(R.layout.snackbar_layout, null);
                    // Configure the view
                    ImageView cancelIcon = (ImageView) snackView.findViewById(R.id.cancelIcon);
                    // Attach click listner on cancel icon
                    cancelIcon.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Snackbar.make(view, "cancel clicked", Toast.LENGTH_SHORT).show();
                            snackbar.dismiss();
                        }
                    });
                    TextView tvText = (TextView) snackView.findViewById(R.id.tvText);
                    tvText.setText("Sorry but share through whats'app is only available.This feature will be added soon");
                    // Add the view to the Snackbar's layout
                    //If the view is not covering the whole snackbar layout, add this line
                    layout.setPadding(0, 0, 0, 0);
                    layout.addView(snackView, 0);
                    // Show the Snackbar
                    snackbar.show();
                } else if (url != null && url.startsWith("https://twitter.com/")) {
                    final Snackbar snackbar = Snackbar.make(view, "Sorry but share through whats'app is only available.This feature will be added soon ", Snackbar.LENGTH_LONG);
                    // Get the Snackbar's layout view
                    Snackbar.SnackbarLayout layout = (Snackbar.SnackbarLayout) snackbar.getView();
                    // Hide the text
                    TextView textView = (TextView) layout.findViewById(android.support.design.R.id.snackbar_text);
                    textView.setVisibility(View.INVISIBLE);

                    // Inflate our custom view
                    View snackView = getLayoutInflater().inflate(R.layout.snackbar_layout, null);
                    // Configure the view
                    ImageView cancelIcon = (ImageView) snackView.findViewById(R.id.cancelIcon);
                    // Attach click listner on cancel icon
                    cancelIcon.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Snackbar.make(view, "cancel clicked", Toast.LENGTH_SHORT).show();
                            snackbar.dismiss();
                        }
                    });
                    TextView tvText = (TextView) snackView.findViewById(R.id.tvText);
                    tvText.setText("Sorry but share through whats'app is only available.This feature will be added soon");
                    // Add the view to the Snackbar's layout
                    //If the view is not covering the whole snackbar layout, add this line
                    layout.setPadding(0, 0, 0, 0);
                    layout.addView(snackView, 0);
                    // Show the Snackbar
                    snackbar.show();
                } else if (url != null && url.startsWith("https://www.linkedin.com")) {
                    final Snackbar snackbar = Snackbar.make(view, "Sorry but share through whats'app is only available.This feature will be added soon ", Snackbar.LENGTH_LONG);
                    // Get the Snackbar's layout view
                    Snackbar.SnackbarLayout layout = (Snackbar.SnackbarLayout) snackbar.getView();
                    // Hide the text
                    TextView textView = (TextView) layout.findViewById(android.support.design.R.id.snackbar_text);
                    textView.setVisibility(View.INVISIBLE);

                    // Inflate our custom view
                    View snackView = getLayoutInflater().inflate(R.layout.snackbar_layout, null);
                    // Configure the view
                    ImageView cancelIcon = (ImageView) snackView.findViewById(R.id.cancelIcon);
                    // Attach click listner on cancel icon
                    cancelIcon.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Snackbar.make(view, "cancel clicked", Toast.LENGTH_SHORT).show();
                            snackbar.dismiss();
                        }
                    });
                    TextView tvText = (TextView) snackView.findViewById(R.id.tvText);
                    tvText.setText("Sorry but share through whats'app is only available.This feature will be added soon");
                    // Add the view to the Snackbar's layout
                    //If the view is not covering the whole snackbar layout, add this line
                    layout.setPadding(0, 0, 0, 0);
                    layout.addView(snackView, 0);
                    // Show the Snackbar
                    snackbar.show();
                } else if (url != null && url.startsWith("https://www.pinterest.com")) {
                    final Snackbar snackbar = Snackbar.make(view, "Sorry but share through whats'app is only available.This feature will be added soon ", Snackbar.LENGTH_LONG);
                    // Get the Snackbar's layout view
                    Snackbar.SnackbarLayout layout = (Snackbar.SnackbarLayout) snackbar.getView();
                    // Hide the text
                    TextView textView = (TextView) layout.findViewById(android.support.design.R.id.snackbar_text);
                    textView.setVisibility(View.INVISIBLE);

                    // Inflate our custom view
                    View snackView = getLayoutInflater().inflate(R.layout.snackbar_layout, null);
                    // Configure the view
                    ImageView cancelIcon = (ImageView) snackView.findViewById(R.id.cancelIcon);
                    // Attach click listner on cancel icon
                    cancelIcon.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Snackbar.make(view, "cancel clicked", Toast.LENGTH_SHORT).show();
                            snackbar.dismiss();
                        }
                    });
                    TextView tvText = (TextView) snackView.findViewById(R.id.tvText);
                    tvText.setText("Sorry but share through whats'app is only available.This feature will be added soon");
                    // Add the view to the Snackbar's layout
                    //If the view is not covering the whole snackbar layout, add this line
                    layout.setPadding(0, 0, 0, 0);
                    layout.addView(snackView, 0);
                    // Show the Snackbar
                    snackbar.show();
                }
                else if (url != null && url.startsWith("https://www.instagram.com/")) {
                    final Snackbar snackbar = Snackbar.make(view, "Sorry but share through whats'app is only available.This feature will be added soon ", Snackbar.LENGTH_LONG);
                    // Get the Snackbar's layout view
                    Snackbar.SnackbarLayout layout = (Snackbar.SnackbarLayout) snackbar.getView();
                    // Hide the text
                    TextView textView = (TextView) layout.findViewById(android.support.design.R.id.snackbar_text);
                    textView.setVisibility(View.INVISIBLE);

                    // Inflate our custom view
                    View snackView = getLayoutInflater().inflate(R.layout.snackbar_layout, null);
                    // Configure the view
                    ImageView cancelIcon = (ImageView) snackView.findViewById(R.id.cancelIcon);
                    // Attach click listner on cancel icon
                    cancelIcon.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Snackbar.make(view, "cancel clicked", Toast.LENGTH_SHORT).show();
                            snackbar.dismiss();
                        }
                    });
                    TextView tvText = (TextView) snackView.findViewById(R.id.tvText);
                    tvText.setText("Sorry but share through whats'app is only available.This feature will be added soon");
                    // Add the view to the Snackbar's layout
                    //If the view is not covering the whole snackbar layout, add this line
                    layout.setPadding(0, 0, 0, 0);
                    layout.addView(snackView, 0);
                    // Show the Snackbar
                    snackbar.show();
                }
                else if (url != null && url.startsWith("https://www.tumblr.com")) {
                    final Snackbar snackbar = Snackbar.make(view, "Sorry but share through whats'app is only available.This feature will be added soon ", Snackbar.LENGTH_LONG);
                    // Get the Snackbar's layout view
                    Snackbar.SnackbarLayout layout = (Snackbar.SnackbarLayout) snackbar.getView();
                    // Hide the text
                    TextView textView = (TextView) layout.findViewById(android.support.design.R.id.snackbar_text);
                    textView.setVisibility(View.INVISIBLE);

                    // Inflate our custom view
                    View snackView = getLayoutInflater().inflate(R.layout.snackbar_layout, null);
                    // Configure the view
                    ImageView cancelIcon = (ImageView) snackView.findViewById(R.id.cancelIcon);
                    // Attach click listner on cancel icon
                    cancelIcon.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Snackbar.make(view, "cancel clicked", Toast.LENGTH_SHORT).show();
                            snackbar.dismiss();
                        }
                    });
                    TextView tvText = (TextView) snackView.findViewById(R.id.tvText);
                    tvText.setText("Sorry but share through whats'app is only available.This feature will be added soon");
                    // Add the view to the Snackbar's layout
                    //If the view is not covering the whole snackbar layout, add this line
                    layout.setPadding(0, 0, 0, 0);
                    layout.addView(snackView, 0);
                    // Show the Snackbar
                    snackbar.show();
                }
                else if (url != null && url.startsWith("https://www.youtube.com/")) {
                    final Snackbar snackbar = Snackbar.make(view, "Sorry but share through whats'app is only available.This feature will be added soon ", Snackbar.LENGTH_LONG);
                    // Get the Snackbar's layout view
                    Snackbar.SnackbarLayout layout = (Snackbar.SnackbarLayout) snackbar.getView();
                    // Hide the text
                    TextView textView = (TextView) layout.findViewById(android.support.design.R.id.snackbar_text);
                    textView.setVisibility(View.INVISIBLE);

                    // Inflate our custom view
                    View snackView = getLayoutInflater().inflate(R.layout.snackbar_layout, null);
                    // Configure the view
                    ImageView cancelIcon = (ImageView) snackView.findViewById(R.id.cancelIcon);
                    // Attach click listner on cancel icon
                    cancelIcon.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Snackbar.make(view, "cancel clicked", Toast.LENGTH_SHORT).show();
                            snackbar.dismiss();
                        }
                    });
                    TextView tvText = (TextView) snackView.findViewById(R.id.tvText);
                    tvText.setText("Sorry but share through whats'app is only available.This feature will be added soon");
                    // Add the view to the Snackbar's layout
                    //If the view is not covering the whole snackbar layout, add this line
                    layout.setPadding(0, 0, 0, 0);
                    layout.addView(snackView, 0);
                    // Show the Snackbar
                    snackbar.show();
                }
                else if (url != null && url.startsWith("https://play.google.com/")) {
                    final Snackbar snackbar = Snackbar.make(view, "navigation to this page is not allowed", Snackbar.LENGTH_LONG);
                    // Get the Snackbar's layout view
                    Snackbar.SnackbarLayout layout = (Snackbar.SnackbarLayout) snackbar.getView();
                    // Hide the text
                    TextView textView = (TextView) layout.findViewById(android.support.design.R.id.snackbar_text);
                    textView.setVisibility(View.INVISIBLE);

                    // Inflate our custom view
                    View snackView = getLayoutInflater().inflate(R.layout.snackbar_layout, null);
                    // Configure the view
                    ImageView cancelIcon = (ImageView) snackView.findViewById(R.id.cancelIcon);
                    // Attach click listner on cancel icon
                    cancelIcon.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Snackbar.make(view, "cancel clicked", Toast.LENGTH_SHORT).show();
                            snackbar.dismiss();
                        }
                    });
                    TextView tvText = (TextView) snackView.findViewById(R.id.tvText);
                    tvText.setText("navigation to this page is not allowed");
                    // Add the view to the Snackbar's layout
                    //If the view is not covering the whole snackbar layout, add this line
                    layout.setPadding(0, 0, 0, 0);
                    layout.addView(snackView, 0);
                    // Show the Snackbar
                    snackbar.show();
                }
                else if (url != null && url.startsWith("https://apps.apple.com/")) {
                    final Snackbar snackbar = Snackbar.make(view, "navigation to this page is not allowed", Snackbar.LENGTH_LONG);
                    // Get the Snackbar's layout view
                    Snackbar.SnackbarLayout layout = (Snackbar.SnackbarLayout) snackbar.getView();
                    // Hide the text
                    TextView textView = (TextView) layout.findViewById(android.support.design.R.id.snackbar_text);
                    textView.setVisibility(View.INVISIBLE);

                    // Inflate our custom view
                    View snackView = getLayoutInflater().inflate(R.layout.snackbar_layout, null);
                    // Configure the view
                    ImageView cancelIcon = (ImageView) snackView.findViewById(R.id.cancelIcon);
                    // Attach click listner on cancel icon
                    cancelIcon.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Snackbar.make(view, "cancel clicked", Toast.LENGTH_SHORT).show();
                            snackbar.dismiss();
                        }
                    });
                    TextView tvText = (TextView) snackView.findViewById(R.id.tvText);
                    tvText.setText("navigation to this page is not allowed");
                    // Add the view to the Snackbar's layout
                    //If the view is not covering the whole snackbar layout, add this line
                    layout.setPadding(0, 0, 0, 0);
                    layout.addView(snackView, 0);
                    // Show the Snackbar
                    snackbar.show();
                }

                else if (url != null && url.startsWith("https://f87kg.app.goo.gl/")) {
                    final Snackbar snackbar = Snackbar.make(view, "navigation to this page is not allowed", Snackbar.LENGTH_LONG);
                    // Get the Snackbar's layout view
                    Snackbar.SnackbarLayout layout = (Snackbar.SnackbarLayout) snackbar.getView();
                    // Hide the text
                    TextView textView = (TextView) layout.findViewById(android.support.design.R.id.snackbar_text);
                    textView.setVisibility(View.INVISIBLE);

                    // Inflate our custom view
                    View snackView = getLayoutInflater().inflate(R.layout.snackbar_layout, null);
                    // Configure the view
                    ImageView cancelIcon = (ImageView) snackView.findViewById(R.id.cancelIcon);
                    // Attach click listner on cancel icon
                    cancelIcon.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Snackbar.make(view, "cancel clicked", Toast.LENGTH_SHORT).show();
                            snackbar.dismiss();
                        }
                    });
                    TextView tvText = (TextView) snackView.findViewById(R.id.tvText);
                    tvText.setText("navigation to this page is not allowed");
                    // Add the view to the Snackbar's layout
                    //If the view is not covering the whole snackbar layout, add this line
                    layout.setPadding(0, 0, 0, 0);
                    layout.addView(snackView, 0);
                    // Show the Snackbar
                    snackbar.show();
                }





                else {

                    view.loadUrl(url);

                }

                return overrideUrlLoading;

            }

            @Override
            public void onPageFinished(WebView view, String url) {

                progressBar.setVisibility(View.GONE);
            }
        });
        return view;    }
    @Override
    public void onPause() {
        super.onPause();

        webViewBundle = new Bundle();
        mWebView.saveState(webViewBundle);
    }

}






