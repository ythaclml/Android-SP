package com.example.demofragmentos1.fragments;

import java.util.ArrayList;
import java.util.Arrays;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.demofragmentos1.R;
import com.example.demofragmentos1.activities.CountryDetailActivity;


public class CountriesListFragment extends Fragment implements
		OnItemClickListener {
	
	String country ="";
	ListView list;
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);	
		String [] arrayCountries = new String[]{"Brasil","Mexico","Colombia","Argentina","Peru","Venezuela","Chile","Ecuador","Guatemala"};
		ArrayList  <String> countries = new ArrayList<String>(Arrays.asList(arrayCountries));
		ArrayAdapter<String> adapter = new ArrayAdapter<String> (getActivity(),android.R.layout.simple_list_item_1,countries);
		
		
		list.setAdapter(adapter);
		list.setOnItemClickListener(this);
		registerForContextMenu(list);
		
		
		
		
		
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_countries_list,container,false);
		list = (ListView)view.findViewById(R.id.listView1);
		return view;
	}

	@Override
	public void onCreateOptionsMenu(Menu menu,MenuInflater inflater) {
		// Inflate the menu; this adds items to the action bar if it is present.
		inflater.inflate(R.menu.main, menu);
		
	}

	@Override
	public void onPrepareOptionsMenu(Menu menu) {

		boolean landscape = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
		MenuItem share = menu.getItem(menu.size()-1);
		share.setVisible(landscape);
		
		
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
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		return onOptionsItemSelected(item);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
		AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
		country = ((TextView)info.targetView).getText().toString();
		
		getActivity().getMenuInflater().inflate(R.menu.main, menu);
	}

	@Override
	public void onItemClick(AdapterView<?> adapterView, View view, int position, long arg3) {
		// TODO Auto-generated method stub
		 country = adapterView.getItemAtPosition(position).toString();
		if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
			FragmentManager manager = getActivity().getSupportFragmentManager();
			CountryInfoFragment fragment = (CountryInfoFragment)manager.findFragmentById(R.id.fragmentCountryInfo);
			fragment.loadWebViewContent(country);
		}else{
		Intent intent = new Intent(getActivity(),CountryDetailActivity.class);
		intent.putExtra(CountryDetailActivity.COUNTRY,country);
		startActivity(intent);
		}
		
	}

	

}
