package com.example.amadoucamara.payment.models;

import com.example.amadoucamara.payment.R;

import java.util.ArrayList;
import java.util.List;

public class Services {
    private String name;
    private int image;

    public Services(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public static List<Services> getTypes(){
        List<Services> services = new ArrayList<>();
        services.add(new Services("Peer to Peer", R.mipmap.ic_p2p));
        services.add(new Services("Send Money", R.mipmap.ic_moneysend));
        services.add(new Services("Foreign Exchange", R.mipmap.ic_fx));
        services.add(new Services("Settings", R.mipmap.ic_settings));

        return services;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
