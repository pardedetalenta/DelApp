package com.example.talenta.delappproject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Talenta on 5/13/2017.
 */
public interface APIDelApp {
    /*URL Web service: /hasil */
    @GET("/del/kegiatan")
    Call<ResponseKegiatan> getKegiatan();
    @GET("/del/fasilitas")
    Call<ResponseFasilitas> getFasilitas();

}