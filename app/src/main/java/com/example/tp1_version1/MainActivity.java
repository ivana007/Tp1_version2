package com.example.tp1_version1;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
private MensajeUsb msjUsb;
private IntentFilter estadoIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //estadoIntent=new IntentFilter();
        //estadoIntent.addAction(Intent.ACTION_POWER_CONNECTED);
        //estadoIntent.addAction(Intent.ACTION_POWER_DISCONNECTED);
       // if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
       // {
           // requestPermissions(new String[] {Manifest.permission.CALL_PHONE}, 1000);
        //}

    }
    @Override
    protected void onResume() {
        super.onResume();
        msjUsb=new MensajeUsb(this);
        //registerReceiver(msjUsb,estadoIntent);
        registerReceiver(msjUsb,new IntentFilter("android.hardware.usb.action.USB_STATE"));
    }
    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(msjUsb);
    }
}
