package com.example.demofragmentos1.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.demofragmentos1.R;
import com.example.demofragmentos1.activities.CountryDetailActivity;

public class CountryInfoFragment extends Fragment {
		private WebView webView;

		@Override
		public void onActivityCreated(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onActivityCreated(savedInstanceState);
			Activity activity = getActivity();
			if(activity instanceof CountryDetailActivity ){
				String country = ((CountryDetailActivity)getActivity()).getCountry();
				loadWebViewContent(country);
			}
			
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			View view = inflater.inflate(R.layout.fragment_countryinfo, container,false);
			webView = (WebView)view.findViewById(R.id.webView);
			return view;
		}
		
		public void loadWebViewContent(String country){
			
			webView.loadUrl("http://es.m.wikipedia.org/wiki/"+country);
			webView.setWebViewClient(new WebViewClient (){
				
				@Override
				public boolean shouldOverrideUrlLoading(WebView view,String url){
					view.loadUrl(url);
					return true;
					
				}
			});	
			
			
		}
		
}
