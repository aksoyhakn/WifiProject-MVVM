package com.example.win10.wifiproject.model;

import android.widget.ImageView;

public class WifiModel {
    public String macAdress;
    public String connectName;
    public int imageId;


    public WifiModel() {
    }

    public WifiModel(String macAdress, String connectName) {
        this.macAdress = macAdress;
        this.connectName = connectName;
    }


    public WifiModel(String macAdress, String connectName, int imageId) {
        this.macAdress = macAdress;
        this.connectName = connectName;
        this.imageId = imageId;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
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
