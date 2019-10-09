package com.transvision.jobintentservice;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.JobIntentService;

public class MyJobIntentService extends JobIntentService {
    final Handler mHandler =    new Handler();
    private static final String TAG = "IntentService";
    private static final int JOB_ID = 2;

    public static void enqueueWork(Context context, Intent intent){
        enqueueWork(context,MyJobIntentService.class, JOB_ID, intent);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        showToast("Job Execution Started");
    }

    @Override
    protected void onHandleWork(@NonNull Intent intent) {
        int max_count = intent.getIntExtra("maxCountValue",-1);
        for (int i=0; i<max_count; i++){
           // Log.d("debug","The Number Is " + i);
            showToast(i+"");
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        showToast("Job Execution Finished");
    }

    void showToast(final CharSequence text){
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MyJobIntentService.this, text, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
