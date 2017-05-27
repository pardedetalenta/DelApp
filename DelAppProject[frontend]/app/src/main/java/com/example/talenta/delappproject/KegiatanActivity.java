package com.example.talenta.delappproject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by Talenta on 5/22/2017.
 */

public class KegiatanActivity extends Activity {
    Context myContext;
    ProgressDialog progress;
    APIDelApp APIDelApp;
    ListView grdData;

    private static final class Holder {
        public ImageView gbr;
        public TextView nama;
        public TextView keterangan;
    }

    public KegiatanActivity() {
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kegiatan);

        myContext = getApplicationContext();
        progress = ProgressDialog.show(KegiatanActivity.this, "Inisialisasi Data","Sedang Mengunduh Data Untuk Aplikasi" , true);

        Callback<ResponseKegiatan> kegiatan1 = new Callback<ResponseKegiatan>() {
            @Override
            public void onResponse(Call<ResponseKegiatan> call, Response<ResponseKegiatan> response) {
                System.out.println(response.code());
                if (response.isSuccessful()) {

                    List<ModelKegiatan> kegiatan = response.body().getHasil();
                    int jumlahData = response.body().getHasil().size();
                    if(jumlahData>0){
                        ControllerKegiatan chb = new ControllerKegiatan(myContext);
                        chb.open();
                        chb.deleteData();
                        for(int y=0; y<jumlahData;y++){
                            ModelKegiatan tmpHasil = kegiatan.get(y);
                            chb.insertData(
                                    tmpHasil.getId(),tmpHasil.getNama_kegiatan(),tmpHasil.getGambar_kegiatan(),tmpHasil.getKeterangan());
                        }
                        chb.close();
                    }else{
                        Toast.makeText(getApplicationContext(),"DATA SEDANG TIDAK TERSEDIA", Toast.LENGTH_LONG).show();
                    }
                    progress.dismiss();
                } else {
                    Log.e("onResponse failure", "Code: " + response.code() + " , Message: " + response.message());
                }
            }
            @Override
            public void onFailure(Call<ResponseKegiatan> call, Throwable t)
            {
// TODO Auto-generated method stub
                progress.dismiss();
                Toast.makeText(getApplicationContext(), "AKSES KE SERVER GAGAL"+t.getMessage(), Toast.LENGTH_LONG).show();
            }
        };
        //consuming web service here
        APIDelApp = RESTClientKegiatan.get();
        Call<ResponseKegiatan> callKegiatan = APIDelApp.getKegiatan();
        callKegiatan.enqueue(kegiatan1);

        grdData = (ListView) findViewById(R.id.grdData);
        ControllerKegiatan myData = new ControllerKegiatan( this);
        myData.open();
        myData.getData();
        KegiatanAdapter adapter = new KegiatanAdapter(this,android.R.layout.simple_list_item_1, myData.getData());
        grdData.setAdapter(adapter);
        myData.close();
    }

    private class KegiatanAdapter extends ArrayAdapter<ModelKegiatan> {
        private LayoutInflater mInflater;
        public KegiatanAdapter(Context context, int textViewResourceId,
                                List<ModelKegiatan> objects) {
            super(context, textViewResourceId, objects);
            // TODO Auto-generated constructor stub
            mInflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            View view = convertView;
            Holder holder;
            if (view == null) {
                // View doesn't exist so create it and create the holder
                view = mInflater.inflate(R.layout.custom_kegiatan, parent,false);
                holder = new Holder();
                holder.gbr = (ImageView) view.findViewById(R.id.gbr);
                holder.keterangan = (TextView) view.findViewById(R.id.keterangan);
                holder.nama = (TextView) view.findViewById(R.id.nama
                );
                view.setTag( holder);
            } else {
// Just get our existing holder
                holder = (Holder) view.getTag();
            }
// Populate via the holder for speed
            ModelKegiatan stream = getItem( position);
// Populate the item contents

            holder.gbr.setImageResource(R.drawable.foto1);
            holder.keterangan.setText(stream.getKeterangan());
            holder.nama.setText(stream.getNama_kegiatan());
            return view;
        }
    }
}
