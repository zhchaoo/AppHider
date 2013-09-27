package com.chaoser.apphider;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.pm.PackageInfo;
import android.view.Menu;
import android.widget.GridView;

public class AppHiderActivity extends Activity {
	//private static final String LOGTAG = "AppHiderActivity";
	private GridView mAppContainer;
	private AppItemAdapter mAppItemAdapter;
	
	private void initialize() {
		mAppContainer = (GridView)findViewById(R.id.app_container);
		
	}
	
	private void readApp() {
		ArrayList<AppInfo> appList = new ArrayList<AppInfo>();
		List<PackageInfo> packages = getPackageManager().getInstalledPackages(0);
        
        for(int i=0;i<packages.size();i++) { 
	        PackageInfo packageInfo = packages.get(i); 
	        AppInfo tmpInfo = new AppInfo(); 
	        tmpInfo.appName = packageInfo.applicationInfo.loadLabel(getPackageManager()).toString(); 
	        tmpInfo.packageName = packageInfo.packageName; 
	        tmpInfo.versionName = packageInfo.versionName; 
	        tmpInfo.versionCode = packageInfo.versionCode; 
	        tmpInfo.appIcon = packageInfo.applicationInfo.loadIcon(getPackageManager());
	        appList.add(tmpInfo);
        
	        tmpInfo.print();
       }
        
        mAppItemAdapter = new AppItemAdapter(this, R.layout.app_item, appList);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_app_hider);
		
		initialize();
		readApp();
		
		mAppContainer.setAdapter(mAppItemAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.app_hider, menu);
		return true;
	}

}
