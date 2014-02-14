package com.example.demofragmentos1.data;

import com.example.demofragmentos1.R;
import com.example.demofragmentos1.fragments.FlagFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class FlagPagerAdapter extends FragmentPagerAdapter {

	public FlagPagerAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		int[] arrayFlags = new int[]{R.drawable.argentina,
				R.drawable.chile,R.drawable.colombia,
				R.drawable.cuba,R.drawable.ecuador,
				R.drawable.guatemala,R.drawable.mexico,
				R.drawable.peru,R.drawable.venezuela};
		Fragment fragment = new FlagFragment();
		Bundle args = new Bundle();
		args.putInt(FlagFragment.RESOURCE,arrayFlags[arg0]);
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 9;
	}

}
