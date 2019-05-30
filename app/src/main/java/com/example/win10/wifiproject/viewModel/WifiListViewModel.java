package com.example.win10.wifiproject.viewModel;

import android.content.Context;
import android.content.IntentFilter;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.net.wifi.WifiManager;
import android.widget.Toast;

import com.example.win10.wifiproject.service.WifiService;
import com.example.win10.wifiproject.view.adapter.WifiAdapter;


public class WifiListViewModel  extends BaseObservable {
    private Context context;
    private WifiManager wifiManager;
    private WifiService wifiService;
    private WifiAdapter adapter;

    public WifiListViewModel(Context context) {
        this.context = context;

        wifiService = new WifiService();
        wifiManager = (WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);

        //Wifi status control
        if (!wifiManager.isWifiEnabled()) {
            wifiManager.setWifiEnabled(true);
            showWifiList();
        } else {
            showWifiList();
        }
    }

    private void showWifiList() {
        adapter = new WifiAdapter(wifiService.getWifiList());
        wifiService.setAdapter(adapter);
    }

    @Bindable
    public WifiAdapter getAdapter() {
        return adapter;
    }

    public void register(){
        context.registerReceiver(wifiService, new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
    }

    public void resume(){
        wifiManager.startScan();
        register();
    }
}

