package com.android.sp;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;


public class MainActivity extends Activity {
	Button btnSearch;
	Button btnOpenActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btnSearch= (Button)findViewById(R.id.btn_Search);        
        btnOpenActivity= (Button)findViewById(R.id.btn_openactivity);  
        ButtonListener listener = new ButtonListener();
        btnSearch.setOnClickListener(listener);
        btnOpenActivity.setOnClickListener(listener);
        
        Button btnList = new Button(this);
        btnList.setText(getString(R.string.btn_list));
        btnList.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
        LinearLayout mainContent = (LinearLayout)findViewById(R.id.mainContent);
        
        LinearLayout inputControls = (LinearLayout)View.inflate(this, R.layout.input_controls_content,null);
        mainContent.addView(inputControls);
        mainContent.addView(btnList);
        
    }

    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    class ButtonListener implements OnClickListener {

		@Override
		public void onClick(View vista) {
			EditText searchquery = (EditText) findViewById(R.id.editText1);
			String texto= searchquery.getText().toString();
			String url = "https://www.google.com/?q="+ texto +"#q="+texto;
			Intent intent= null;
			if(vista.getId() == btnOpenActivity.getId()){
				//Toast.makeText(getApplicationContext(), "hizo click",Toast.LENGTH_SHORT).show();
				intent = new Intent(getApplicationContext(),ShowSearchQuery.class);
				intent.putExtra(ShowSearchQuery.query,texto);
				startActivity(intent);
			}else if (vista.getId() == btnSearch.getId()){
				Toast.makeText(getApplicationContext(), "hizo click",Toast.LENGTH_SHORT).show();
				intent = new Intent(Intent.ACTION_VIEW);
				intent.setData(Uri.parse(url));
				startActivity(intent);
				
			}
			
		}

		;
    	
    }
    
    
}

