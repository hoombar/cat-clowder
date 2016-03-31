package net.rdyonline.catclowder.module;

import net.rdyonline.catclowder.networking.NetworkProvider;
import net.rdyonline.catclowder.networking.RetrofitNetworkProvider;

public class NetworkModule {

    public static NetworkProvider retrofitNetworkProvider() {
        return new RetrofitNetworkProvider();
    }

}
