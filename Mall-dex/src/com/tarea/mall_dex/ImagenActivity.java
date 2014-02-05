package com.tarea.mall_dex;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

public class ImagenActivity extends Activity {
	public static final String NAME = "nombre";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_imagen);
		
		Intent intent= getIntent();
		final String elegido = intent.getStringExtra(NAME);
		ImageView image = (ImageView) findViewById(R.id.View_pic);
		TextView texto = (TextView) findViewById(R.id.text_descrip);
		if(elegido.equals("Siman")){
			image.setImageResource(R.drawable.siman);
			texto.setText("Almacén por departamentos más grande de la región centroamericana, fundada el 8 de diciembre de 1921 en San Salvador por José J. Simán.");
		}else if (elegido.equals("StarBucks")){
			image.setImageResource(R.drawable.starbucks);
			texto.setText("Inspirar y nutrir el espíritu humano: una persona, una taza de café y una comunidad a la vez.");
		}else if (elegido.equals("Diesel")){
			image.setImageResource(R.drawable.diesel);
			texto.setText("Be Stupid");
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.imagen, menu);
		return true;
	}

}
