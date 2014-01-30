package com.android.sp;

import java.util.ArrayList;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends Activity {
	Button btnSearch;
	Button btnList;
	Button btnOpenActivity;
	ScrollView inputControls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btnSearch= (Button)findViewById(R.id.btn_Search);        
        btnOpenActivity= (Button)findViewById(R.id.btn_openactivity);  
        btnList= (Button)findViewById(R.id.btnList);   
        ButtonListener listener = new ButtonListener();
        btnSearch.setOnClickListener(listener);
        btnOpenActivity.setOnClickListener(listener);
       btnList.setOnClickListener(listener);
      /*  Button btnList = new Button(this);
        btnList.setText(getString(R.string.btn_list));
        btnList.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
         */
        LinearLayout mainContent = (LinearLayout)findViewById(R.id.mainContent);
       
       inputControls = (ScrollView)View.inflate(this, R.layout.input_controls_content,null);
       // mainContent.addView(btnList);
        setInputControls();
        mainContent.addView(inputControls);
        
        
    }

    public void setInputControls(){
    	SeekBar seekbar = (SeekBar) inputControls.findViewById(R.id.seekBar1);
    	RatingBar ratingBar = (RatingBar) inputControls.findViewById(R.id.ratingBar1);
    	Spinner spinner = (Spinner) inputControls.findViewById(R.id.spinner1);
    	CheckBox checkbox = (CheckBox)inputControls.findViewById(R.id.checkBox1);
    	RadioGroup radioGroup =(RadioGroup) inputControls.findViewById(R.id.radioGroup1);
    	
    	checkbox.setChecked(true);
    	OnCheckedChangeListener checkedChangeListener = new OnCheckedChangeListener(){

			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				// TODO Auto-generated method stub
				String option = "";
				switch (arg1){
					case R.id.radio0:
						option = "A";
						break;
					case R.id.radio1:
						option = "B";
						break;
					case R.id.radio2:
						option ="C";
						break;
				}
				Log.e("TAG","Seleccionado "+option);
			}
    		
    		
    	};
    	radioGroup.setOnCheckedChangeListener(checkedChangeListener);
    	
    	ratingBar.setRating((float)2.5);
    	ArrayList<String> names = new ArrayList<String>();
    	names.add("hugo");
    	names.add("paco");
    	names.add("luis");
    	ArrayAdapter<String> namesAdapter = new ArrayAdapter<String> (this,android.R.layout.simple_spinner_dropdown_item,names);
    	spinner.setAdapter(namesAdapter);
    	seekbar.setMax(10);
    	seekbar.setProgress(5);
    	seekbar.setOnSeekBarChangeListener(new OnSeekBarChangeListener (){

			@Override
			public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Cambio a "+ arg1, Toast.LENGTH_LONG).show();
				
			}

			@Override
			public void onStartTrackingTouch(SeekBar arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onStopTrackingTouch(SeekBar arg0) {
				// TODO Auto-generated method stub
				
			}
    		
    	});
    	
    	
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
			}else if (vista.getId() == btnList.getId()){
				intent = new Intent(getApplicationContext(),EmailActivity.class);
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

