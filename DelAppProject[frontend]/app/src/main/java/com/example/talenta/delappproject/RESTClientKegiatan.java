package com.example.talenta.delappproject;

/**
 * Created by Talenta on 5/13/2017.
 */

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RESTClientKegiatan {
    private static APIDelApp REST_CLIENT;
    static { //dieksekusi sebelum constructor, tapi hanya sekali untuk semua instans
        setupRestClient();
    }
    private RESTClientKegiatan() {}
    public static APIDelApp get() {
        return REST_CLIENT;
    }

    private static void setupRestClient() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.56.1/").addConverterFactory(GsonConverterFactory.create()).build();
        REST_CLIENT = retrofit.create(APIDelApp.class);
    }

}
