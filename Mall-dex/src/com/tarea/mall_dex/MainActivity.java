package com.tarea.mall_dex;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final String[] stores = new String []{"Siman","Diesel","StarBucks"};
		//final String[] direcciones = new String[] {"Diagonal 6, 13-01 zona 10, 01010 - Guatemala","Diagonal 6, 13-01 zona 10, 01010 - Guatemala","Diagonal 6, 13-01 zona 10, 01010 - Guatemala"};
		//final String[] telefonos= new String[]{" 2375-3200"," 2375-3200"," 2375-3200"};
		//final String [] horarios = new String[]{"Lunes - Viernes: 10:00 am - 8:00 pm  Sabado-Domingo: 10:00 am - 9:00 pm","Lunes - Domingo: 10:00 am - 9:00 pm","Lunes - Domingo: 9:00 am - 11:00 pm"};
		 final ListView listview = (ListView)findViewById(R.id.st_list);
		ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,android.R.id.text1, stores);
		listview.setAdapter(adapter);

		listview.setOnItemClickListener(new OnItemClickListener (){

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Intent intent = new Intent (getApplicationContext(),Display_Store.class);
				 String elegido = (String) listview.getItemAtPosition(arg2);
				intent.putExtra(Display_Store.NAME,elegido);
				//intent.putExtra(Display_Store.PHONE,telefonos[arg2]);
				//intent.putExtra(Display_Store.SCHED,horarios[arg2]);
				//intent.putExtra(Display_Store.pos,arg2);
				//int numero = arg2;
				Toast.makeText(getApplicationContext(),elegido, Toast.LENGTH_LONG).show();
				startActivity(intent);
			}
			
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
