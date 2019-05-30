package com.example.win10.wifiproject.view.uı;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.win10.wifiproject.R;
import com.example.win10.wifiproject.databinding.ActivityMainBinding;
import com.example.win10.wifiproject.viewModel.WifiListViewModel;

public class MainActivity extends AppCompatActivity {

    private WifiListViewModel viewModel;

    @Override
    protected void onStart() {
        viewModel.register();
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        Activity activity = this;

        viewModel = new WifiListViewModel(activity);
        activityMainBinding.setViewModel(viewModel);
    }

    @Override
    protected void onResume() {
        viewModel.resume();
        super.onResume();
    }
}
