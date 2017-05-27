package com.example.talenta.delappproject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Talenta on 5/23/2017.
 */

public class ResponseFasilitas {
    private String error;
    @SerializedName("fasilitas")
    @Expose
    private List<ModelFasilitas> hasil;
    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }
    public List<ModelFasilitas> getFasilitas() {
        return hasil;
    }
    public void setHasil(List<ModelFasilitas> hasil) {
        this.hasil = hasil;
    }
}
