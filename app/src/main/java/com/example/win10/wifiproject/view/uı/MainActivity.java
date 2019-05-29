package com.example.win10.wifiproject.view.uı;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.databinding.DataBindingUtil;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.win10.wifiproject.R;
import com.example.win10.wifiproject.databinding.ActivityMainBinding;
import com.example.win10.wifiproject.helper.Common;
import com.example.win10.wifiproject.service.WifiService;
import com.example.win10.wifiproject.view.adapter.WifiAdapter;

public class MainActivity extends AppCompatActivity {


    private WifiManager wifiManager;
    private WifiService wifiService;
    private ActivityMainBinding activityMainBinding;



    @Override
    protected void onStart() {
        /*IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction(Intent.ACTION_TIME_TICK);
        intentFilter.addAction(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION);*/
       registerReceiver(wifiService, new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));

        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        wifiService = new WifiService();
        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);


        //Wifi status control
        if (!wifiManager.isWifiEnabled()) {
            Toast.makeText(this, "Wifi açık değil.", Toast.LENGTH_SHORT).show();
        } else {
            showWifiList();
        }


    }

    private void showWifiList() {

        activityMainBinding.recycle.setLayoutManager(new LinearLayoutManager(this));
        Common.WİFİ_ADAPTER = new WifiAdapter(Common.WİFİ_LİST);
        activityMainBinding.recycle.setAdapter(Common.WİFİ_ADAPTER);
    }

    @Override
    protected void onResume() {

        Toast.makeText(this, "Geldi", Toast.LENGTH_SHORT).show();

        Common.WİFİ_LİST.clear();
        wifiManager.startScan();
        registerReceiver(wifiService, new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
        super.onResume();
    }

}
