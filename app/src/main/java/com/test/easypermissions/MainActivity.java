package com.test.easypermissions;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import pub.devrel.easypermissions.EasyPermissions;

public class MainActivity extends AppCompatActivity {

    public static final String[] BLUETOOTH_PERMISSIONS_S = {
            Manifest.permission.BLUETOOTH_SCAN
            , Manifest.permission.BLUETOOTH_CONNECT
            , Manifest.permission.BLUETOOTH_ADVERTISE} ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            if (!EasyPermissions.hasPermissions(this, BLUETOOTH_PERMISSIONS_S)) {
                EasyPermissions.requestPermissions(this, "message", PackageManager.PERMISSION_GRANTED,BLUETOOTH_PERMISSIONS_S);
            }
        }
    }
}