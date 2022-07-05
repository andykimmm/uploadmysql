package org.techtown.example_gps;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

//public class AlarmReceiver extends BroadcastReceiver {
//    @Override    public void onReceive(Context context, Intent intent) {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            Intent in = new Intent(context, LocationService.class);
//            context.startForegroundService(in);
//        } else {
//            Intent in = new Intent(context, LocationService.class);
//            context.startService(in);        }    }}



//public class AlarmReceiver extends BroadcastReceiver{
//    @Override
//    public void onReceive(Context context, Intent intent) {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            Intent in = new Intent(context, RestartService.class);
//            context.startForegroundService(in);        } else {
//            Intent in = new Intent(context, LocationService.class);
//            context.startService(in);        }    }}
//


//public class AlarmReceiver extends BroadcastReceiver{
//    @Override
//    public void onReceive(Context context, Intent intent) {
//        if ("android.intent.action.BOOT_COMPLETED".equals(intent.getAction())) {
//            Intent LocationService = new Intent(context, LocationService.class);
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//                context.startForegroundService(LocationService);
//
//            }  else  {
//                context.startService(LocationService);
//            }
//        }
//    }
//}



//

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

public class AlarmReceiver extends BroadcastReceiver {
    private static final String TAG = "Portfolio2";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "MyReceiver:onReceive()");
        if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)) {    // 인텐트 수신
            Intent myIntent = new Intent(context, LocationService.class);       // 서비스 구동
            myIntent.putExtra("command", "start");
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) { // 휴대폰 버전에 따라 다른 처리
                context.startForegroundService(myIntent);
            } else {
                context.startService(myIntent);
            }
        }
    }
}
