package com.tarea.mall_dex;


import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.util.Linkify;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Display_Store extends Activity {
	public static final String NAME = "nombre";
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display__store);
		
		Intent intent= getIntent();
		
		final String elegido = intent.getStringExtra(NAME);
		
		//Definir TextViews
		
				TextView StoreName = (TextView)findViewById(R.id.text_StoreName);
				TextView Address = (TextView)findViewById(R.id.text_Address);
				final TextView Phone = (TextView)findViewById(R.id.text_phone);
				TextView Sched = (TextView) findViewById(R.id.text_sched);
				TextView Email = (TextView) findViewById(R.id.text_email);
				TextView Website = (TextView) findViewById(R.id.text_website);
				StoreName.setText(elegido);
		
		//Boton llamar
		Button btn_call = (Button) findViewById(R.id.btn_Call);
		
		btn_call.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent_call = new Intent(Intent.ACTION_DIAL);
			    intent_call.setData(Uri.parse("tel:"+Phone.getText().toString()));
			    startActivity(intent_call);
			}});
		
		//
		
		if(elegido.equals("Siman")){
			Address.setText("Diagonal 6, 13-01 zona 10, 01010 - Guatemala");
			Phone.setText("Tel:" +"\n2327-0000");
			Sched.setText("Lunes - Viernes: 10:00 am - 8:00 pm  Sabado-Domingo: 10:00 am - 9:00 pm");
			Email.setText("contacto@siman.com");
			Website.setText("www.siman.com/guatemala/");
			
		}else if(elegido.equals("Diesel")){
			Address.setText("9ª. Av. 14-22 zona 1 9A Avenida, Guatemala City, Guatemala");
			Phone.setText("2336-6680");
			Sched.setText("Lunes - Domingo: 10:00 am - 11:00 pm ");
			Email.setText("contacto@diesel.com");
			Website.setText("www.diesel.com");
		}else if(elegido.equals("StarBucks")){
			Address.setText("14 Calle 0-20, Guatemala City, Guatemala");
			Phone.setText("4210-6014");
			Sched.setText("Lunes - Domingo: 7:00 am - 12:00 pm ");
			Email.setText("contacto@starbucks.com");
			Website.setText("www.starbucks.com");
		}
		Linkify.addLinks(Address, Linkify.ALL);
		Linkify.addLinks(Phone, Linkify.ALL);
		Linkify.addLinks(Website, Linkify.ALL);
		Linkify.addLinks(Email, Linkify.ALL);
		
		//image button
		
		ImageButton btn_imagen = (ImageButton)findViewById(R.id.btn_imagen);
		btn_imagen.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(),ImagenActivity.class);
				intent.putExtra(ImagenActivity.NAME, elegido);
				startActivity(intent);
			}});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display__store, menu);
		return true;
	}

}
