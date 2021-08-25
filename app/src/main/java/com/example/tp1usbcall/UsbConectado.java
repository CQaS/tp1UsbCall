package com.example.tp1usbcall;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class UsbConectado extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent)
    {
        boolean con = intent.getExtras().getBoolean("connected");

        if(con)
        {
            Toast.makeText(context, "USB Conectado", Toast.LENGTH_LONG).show();
            Intent in = new Intent(context, Llamando.class);
            context.startActivity(in);
        }
    }
}
