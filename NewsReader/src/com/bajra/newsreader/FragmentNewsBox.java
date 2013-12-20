package com.bajra.newsreader;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class FragmentNewsBox extends Fragment{
	WebView wvNews;
	Bundle bundle;
	String url;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
		View view = inflater.inflate(R.layout.newsbox, container, false);
		bundle = this.getArguments();
		url = bundle.getString("url");
		
		wvNews  = (WebView) view.findViewById(R.id.wvNewsBox);
		wvNews.getSettings().setJavaScriptEnabled(true);
//		wvNews.getSettings().setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);
//		wvNews.setHorizontalScrollBarEnabled(false);
//		wvNews.setVerticalScrollbarOverlay(true);
		wvNews.setWebViewClient(new WebViewClient());
		wvNews.setWebChromeClient(new WebChromeClient(){
			final Activity activity= getActivity();
			public void onProgressChanged(WebView view, int progress) {
				activity.setTitle("Loading... ");
				activity.setProgress(progress*100);
				if(progress == 100)
					activity.setTitle(url);
			}
		});

		//wvNews.loadUrl("http://www.google.com");
		wvNews.loadUrl(url);
		return view;
	}
}
