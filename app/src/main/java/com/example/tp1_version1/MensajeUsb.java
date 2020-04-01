package com.example.tp1_version1;

import android.Manifest;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;

public class MensajeUsb extends BroadcastReceiver {
    private MainActivity ma;

    public MensajeUsb(MainActivity ma) {
        this.ma = ma;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        //aca va la accion si se conecto el usb debo hacer la llamada al 911
        // String accion = intent.getAction();
        // boolean estado = accion.equals(Intent.ACTION_POWER_CONNECTED);
        //if (estado)
        if (intent.getExtras().getBoolean("connected")) {
            //aca debemos realizar la llamada
            Toast.makeText(context, "LLAMADA en curso ", Toast.LENGTH_LONG).show();
            // String number = "2664031920";
            Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:911"));
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && ActivityCompat.checkSelfPermission(context,Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
             ActivityCompat.requestPermissions(ma,new String[] {Manifest.permission.CALL_PHONE}, 1000);
            }
            //if(ActivityCompat.checkSelfPermission(context , Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED)
            /*if (ActivityCompat.checkSelfPermission(context.getApplicationContext(), Manifest.permission.CALL_PHONE)
                    != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            */
            context.startActivity(i);
       }else{
           //sidesconecta el usb saca el mensaje
           Toast.makeText(context,"el USB ha sido desconectado",Toast.LENGTH_LONG).show();
       }

    }

}
