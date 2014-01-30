package com.android.sp;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.util.Linkify;
import android.view.Menu;
import android.widget.TextView;

public class ShowSearchQuery extends Activity {
	public static final String query ="query";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_search_query);
		
		Intent intent= getIntent();
	
		String query_text= intent.getStringExtra(query);
		if(query_text != null){
			TextView txtmsg = (TextView)findViewById(R.id.txtmsg);
			txtmsg.setText(query_text);
			Linkify.addLinks(txtmsg, Linkify.ALL);
			
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.show_search_query, menu);
		return true;
	}

}
