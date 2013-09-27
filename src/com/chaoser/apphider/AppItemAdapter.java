package com.chaoser.apphider;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class AppItemAdapter extends ArrayAdapter<AppInfo> {
	private int resourceId;
	
	public AppItemAdapter(Context context, int textViewResourceId,
			List<AppInfo> objects) {
		super(context, textViewResourceId, objects);
		// TODO Auto-generated constructor stub
		
		resourceId = textViewResourceId;
	}

    @Override  
    public View getView(int position, View convertView, ViewGroup parent){  
    	AppInfo appinfo = getItem(position);
        LinearLayout appListItem = new LinearLayout(getContext());
        String inflater = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater vi = (LayoutInflater)getContext().getSystemService(inflater);
        vi.inflate(resourceId, appListItem, true);
        
        TextView appInfoName = (TextView)appListItem.findViewById(R.id.appinfo_name);
        ImageView appInfoIcon = (ImageView)appListItem.findViewById(R.id.appinfo_icon);
        appInfoName.setText(appinfo.appName);
        appInfoIcon.setImageDrawable(appinfo.appIcon);
        
        return appListItem; 
    } 
}
