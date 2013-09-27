package com.chaoser.apphider;

import android.graphics.drawable.Drawable;
import android.util.Log;

public class AppInfo {
	
	private static final String LOGTAG = "AppInfo";
	
    public String appName="";
    public String packageName="";
    public String versionName="";
    public int versionCode=0;
    public Drawable appIcon=null;
    public void print()
    {
        Log.v(LOGTAG, "Name:"+appName+" Package:"+packageName + " versionName:"+versionName +" versionCode:"+versionCode);
    }
}
