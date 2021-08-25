package com.example.tp1usbcall;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import static android.Manifest.permission.CALL_PHONE;

import androidx.appcompat.app.AppCompatActivity;

public class Llamando extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        verifyPermission();

        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel: " +"911"));
        startActivity(intent);

    }

    private boolean verifyPermission()
    {
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M
                && checkSelfPermission(Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED)
        {
            requiresPermits();
        }

        return false;
    }

    private void requiresPermits()
    {
        final CharSequence[] elegir = {"Si","No"};
        final AlertDialog.Builder alertE = new AlertDialog.Builder(this);

        alertE.setTitle("Otorgar Permisos?");
        alertE.setItems(elegir, new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                if (elegir[i].equals("Si"))
                {
                    requestPermissions(new String[]{ Manifest.permission.CALL_PHONE },1000);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Permisos no aceptados",Toast.LENGTH_LONG).show();
                    dialogInterface.dismiss();
                }
            }
        });
        alertE.show();
    }

}
