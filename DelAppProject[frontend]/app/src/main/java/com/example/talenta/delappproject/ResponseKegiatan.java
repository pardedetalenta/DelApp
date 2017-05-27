package com.example.talenta.delappproject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Talenta on 5/21/2017.
 */

public class ResponseKegiatan {
    private String error;
    @SerializedName("kegiatan")
    @Expose
    private List<ModelKegiatan> hasil;
    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }
    public List<ModelKegiatan> getHasil() {
        return hasil;
    }
    public void setHasil(List<ModelKegiatan> hasil) {
        this.hasil = hasil;
    }
}
