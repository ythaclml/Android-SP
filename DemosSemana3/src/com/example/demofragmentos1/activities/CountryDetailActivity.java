package com.example.demofragmentos1.activities;

import com.example.demofragmentos1.R;
import android.os.Bundle;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;

public class CountryDetailActivity extends FragmentActivity {
	public static final String COUNTRY = "country";
	private String country = "";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_country_detail);
		Intent intent = getIntent();
		country = intent.getStringExtra(COUNTRY);
		
	}

	public String getCountry() {
		return country;
		
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
		 case R.id.action_share:
			 if(!country.equals("")){
					String url ="http://es.m.wikipedia.org/wiki/"+country;
					String msg= getString(R.string.msg_share,country,url);
					Intent intent = new Intent();
					intent.setAction(Intent.ACTION_SEND);
					intent.putExtra(Intent.EXTRA_TEXT, msg);
					intent.setType("text/plain");
					startActivity(Intent.createChooser(intent, getString(R.string.action_share)));
					
			 }
			 return true;
		default:
				return super.onOptionsItemSelected(item);
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		
		return true;
	}

}
