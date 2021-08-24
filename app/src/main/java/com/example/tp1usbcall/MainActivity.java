package com.example.tp1usbcall;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.hardware.usb.UsbDeviceConnection;
import android.os.Build;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity
{
    private UsbDeviceConnection USBcon;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M
                && checkSelfPermission(Manifest.permission.READ_CALL_LOG)
                != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.CALL_PHONE},1000);
        }
    }
}