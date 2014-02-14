package com.example.demofragmentos1.fragments;


import com.example.demofragmentos1.R;
import com.example.demofragmentos1.data.FlagPagerAdapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CountriesFlagFragment extends Fragment {
	ViewPager viewPager;
	@Override
	
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
		
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_countries_flags, container,false);
		viewPager = (ViewPager) view.findViewById(R.id.pager);
		// TODO Auto-generated method stub
		return view;
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		FlagPagerAdapter adapter = new FlagPagerAdapter(getChildFragmentManager());
		viewPager.setAdapter(adapter);
	}

}
