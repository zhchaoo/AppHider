package com.chaoser.apphider;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class SecretReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
        String host = intent.getData() != null ? intent.getData().getHost() : null;

            Intent i = new Intent(Intent.ACTION_MAIN);
            if ("1111".equals(host)) {
                i.setClass(context, AppHiderActivity.class);            
            }
            
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
	}

}
