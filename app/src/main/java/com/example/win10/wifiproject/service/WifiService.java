package com.example.win10.wifiproject.service;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;

import com.example.win10.wifiproject.R;
import com.example.win10.wifiproject.model.WifiModel;
import com.example.win10.wifiproject.view.adapter.WifiAdapter;
import com.example.win10.wifiproject.viewModel.WifiViewModel;

import java.util.ArrayList;
import java.util.List;

public class WifiService extends BroadcastReceiver {

    private WifiAdapter adapter;
    private List<WifiViewModel> wifiViewModels = new ArrayList<>();
    private List<ScanResult> results;

    public void setAdapter(WifiAdapter adapter) {
        this.adapter = adapter;
    }

    public List<WifiViewModel> getWifiList() {
        return wifiViewModels;
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        results = wifiManager.getScanResults();

        wifiViewModels.clear();

        if (!results.equals(wifiManager.startScan())) {
            displayWifiList();
        }

    }

    private void displayWifiList() {

        for (ScanResult scanResult : results) {

            int level = scanResult.level;

            if (level <= 0 && level >= -50) {

                //Best signal
                wifiViewModels.add(new WifiViewModel(new WifiModel(scanResult.SSID, scanResult.BSSID, R.drawable.excellent)));

            } else if (level < -50 && level >= -70) {

                //Good signal
                wifiViewModels.add(new WifiViewModel(new WifiModel(scanResult.SSID, scanResult.BSSID, R.drawable.good)));


            } else if (level < -70 && level >= -80) {

                //Low signal
                wifiViewModels.add(new WifiViewModel(new WifiModel(scanResult.SSID, scanResult.BSSID, R.drawable.fair)));

            } else if (level < -80 && level >= -100) {

                //Very weak signal
                wifiViewModels.add(new WifiViewModel(new WifiModel(scanResult.SSID, scanResult.BSSID, R.drawable.weak)));

            }

            adapter.notifyDataSetChanged();
        }
    }
}
