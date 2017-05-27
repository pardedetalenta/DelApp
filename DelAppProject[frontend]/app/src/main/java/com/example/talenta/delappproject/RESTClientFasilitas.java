package com.example.talenta.delappproject;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Talenta on 5/23/2017.
 */

public class RESTClientFasilitas {
    private static APIDelApp REST_CLIENT;
    static { //dieksekusi sebelum constructor, tapi hanya sekali untuk semua instans
        setupRestClient();
    }
    private RESTClientFasilitas() {}
    public static APIDelApp get() {
        return REST_CLIENT;
    }

    private static void setupRestClient() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.56.1/").addConverterFactory(GsonConverterFactory.create()).build();
        REST_CLIENT = retrofit.create(APIDelApp.class);
    }
}
