package com.example.win10.wifiproject.viewModel;

import android.databinding.BindingAdapter;
import android.provider.ContactsContract;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;

import com.example.win10.wifiproject.R;
import com.example.win10.wifiproject.model.WifiModel;

public class WifiViewModel {

    public String macAdress;
    public String connectName;
    public int imageId;


    public WifiViewModel() {
    }


    public WifiViewModel(WifiModel wifiModel) {
        this.macAdress = wifiModel.macAdress;
        this.connectName = wifiModel.connectName;
        this.imageId=wifiModel.imageId;

    }

    @BindingAdapter("android:imageUrl")
    public static void loadImage(View view,int imageId){

        ImageView ivProfileImage=(ImageView) view;
        ivProfileImage.setImageDrawable(ContextCompat.getDrawable(view.getContext(),imageId));

    }

    public String getMacAdress() {
        return macAdress;
    }

    public void setMacAdress(String macAdress) {
        this.macAdress = macAdress;
    }

    public String getConnectName() {
        return connectName;
    }

    public void setConnectName(String connectName) {
        this.connectName = connectName;
    }


}
