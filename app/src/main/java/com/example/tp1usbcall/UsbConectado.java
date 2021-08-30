package com.example.tp1usbcall;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class UsbConectado extends BroadcastReceiver
{
    private int bandera = 0;

    @Override
    public void onReceive(Context context, Intent intent)
    {

        boolean con = intent.getExtras().getBoolean("connected");

        if(con  && bandera == 0)
        {
            Toast.makeText(context, "USB Conectado", Toast.LENGTH_LONG).show();
            bandera = 1;
            Intent in =new Intent(Intent.ACTION_CALL);
            in.setData(Uri.parse("tel: "+"911"));
            context.startActivity(in);
        }
        else
        {
            bandera = 0;
            Toast.makeText(context, "USB Desconectado", Toast.LENGTH_LONG).show();
        }
    }
}
