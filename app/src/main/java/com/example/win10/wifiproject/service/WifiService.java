package com.example.win10.wifiproject.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;

import com.example.win10.wifiproject.R;
import com.example.win10.wifiproject.helper.Common;
import com.example.win10.wifiproject.model.WifiModel;
import com.example.win10.wifiproject.viewModel.WifiViewModel;

import java.util.List;

public class WifiService extends BroadcastReceiver {

    List<ScanResult> results;
    WifiManager wifiManager;


    @Override
    public void onReceive(Context context, Intent intent) {

        wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        results = wifiManager.getScanResults();
        wifiManager.startScan();

        for (ScanResult scanResult : results) {

            int level = scanResult.level;

            if (level <= 0 && level >= -50) {

                //Best signal
                Common.WİFİ_LİST.add(new WifiViewModel(new WifiModel(scanResult.SSID, scanResult.BSSID, R.drawable.excellent)));

            } else if (level < -50 && level >= -70) {

                //Good signal
                Common.WİFİ_LİST.add(new WifiViewModel(new WifiModel(scanResult.SSID, scanResult.BSSID, R.drawable.good)));


            } else if (level < -70 && level >= -80) {

                //Low signal
                Common.WİFİ_LİST.add(new WifiViewModel(new WifiModel(scanResult.SSID, scanResult.BSSID, R.drawable.fair)));

            } else if (level < -80 && level >= -100) {

                //Very weak signal
                Common.WİFİ_LİST.add(new WifiViewModel(new WifiModel(scanResult.SSID, scanResult.BSSID, R.drawable.weak)));

            } else {
                // no signals
            }


            Common.WİFİ_ADAPTER.notifyDataSetChanged();

        }
    }
}
