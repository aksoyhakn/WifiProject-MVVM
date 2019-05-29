package com.example.win10.wifiproject.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.win10.wifiproject.R;
import com.example.win10.wifiproject.databinding.WifiBinding;
import com.example.win10.wifiproject.viewModel.WifiViewModel;

import java.util.List;

public class WifiAdapter extends RecyclerView.Adapter<WifiAdapter.CustomView> {


    List<WifiViewModel> mWifis;
    private LayoutInflater layoutInflater;

    public WifiAdapter(List<WifiViewModel> mWifis) {
        this.mWifis = mWifis;
    }

    public class CustomView extends RecyclerView.ViewHolder {

        private WifiBinding wifiBinding;

        public CustomView(@NonNull WifiBinding wifiBinding) {
            super(wifiBinding.getRoot());
            this.wifiBinding = wifiBinding;
        }

        public void bind(WifiViewModel wifiViewModel) {
            this.wifiBinding.setWifiView(wifiViewModel);
        }

    }


    @NonNull
    @Override
    public WifiAdapter.CustomView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(viewGroup.getContext());
        }

        WifiBinding wifiBinding = WifiBinding.inflate(layoutInflater, viewGroup, false);
        return new CustomView(wifiBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull WifiAdapter.CustomView customView, int i) {

        WifiViewModel wifiViewModel = mWifis.get(i);
        customView.bind(wifiViewModel);


    }

    @Override
    public int getItemCount() {
        return mWifis.size();
    }
}
