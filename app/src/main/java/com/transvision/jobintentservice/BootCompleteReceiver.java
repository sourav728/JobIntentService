package com.transvision.jobintentservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootCompleteReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)) {
            Intent mIntent = new Intent(context, MyJobIntentService.class);
            mIntent.putExtra("maxCountValue", 1000);
            MyJobIntentService.enqueueWork(context, mIntent);
        }
    }
}
