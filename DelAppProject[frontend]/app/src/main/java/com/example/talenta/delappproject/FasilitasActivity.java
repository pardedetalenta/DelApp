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
 * Created by Talenta on 5/23/2017.
 */

public class FasilitasActivity extends Activity{

    Context myContext;
    ProgressDialog progress;
    APIDelApp APIDelApp;
    ListView grdData;


    // Holder class used to efficiently recycle view positions
    private static final class Holder {
        public ImageView gbr;
        public TextView nama;
        public TextView keterangan;
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fasilitas);

        myContext = getApplicationContext();
        progress = ProgressDialog.show(FasilitasActivity.this, "Inisialisasi Data","Sedang Mengunduh Data Untuk Aplikasi" , true);

        Callback<ResponseFasilitas> fasilitas1 = new Callback<ResponseFasilitas>() {
            @Override
            public void onResponse(Call<ResponseFasilitas> call, Response<ResponseFasilitas> response) {
                if (response.isSuccessful()) {
                    System.out.println("Hello");
                    List<ModelFasilitas> fasilitas = response.body().getFasilitas();
                    int jumlahData = response.body().getFasilitas().size();
                    if(jumlahData>0){
                        ControllerFasilitas chb = new ControllerFasilitas(myContext);
                        chb.open();
                        chb.deleteData();
                        for(int y=0; y<jumlahData;y++){
                            ModelFasilitas tmpHasil = fasilitas.get(y);
                            chb.insertData(
                                    tmpHasil.getId(),tmpHasil.getNama_fasilitas(),tmpHasil.getGambar_fasilitas(),tmpHasil.getKeterangan());
                            System.out.println("Hello");
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
            public void onFailure(Call<ResponseFasilitas> call, Throwable t)
            {
// TODO Auto-generated method stub
                progress.dismiss();
                Toast.makeText(getApplicationContext(), "AKSES KE SERVER GAGAL"+t.getMessage(), Toast.LENGTH_LONG).show();
            }
        };
        //consuming web service here
        APIDelApp = RESTClientFasilitas.get();
        Call<ResponseFasilitas> callFasilitas = APIDelApp.getFasilitas();
        callFasilitas.enqueue(fasilitas1);

        grdData = (ListView) findViewById(R.id.grdData);
        ControllerFasilitas myData = new ControllerFasilitas( this);
        myData.open();
        myData.getData();
        FasilitasAdapter adapter = new FasilitasAdapter(this,android.R.layout.simple_list_item_1, myData.getData());
        grdData.setAdapter(adapter);
        myData.close();
    }

    private class FasilitasAdapter extends ArrayAdapter<ModelFasilitas> {
        private LayoutInflater mInflater;
        public FasilitasAdapter(Context context, int textViewResourceId,
                                List<ModelFasilitas> objects) {
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
                view = mInflater.inflate(R.layout.custom_fasilitas, parent,false);
                holder = new Holder();
                holder.gbr= (ImageView) view.findViewById(R.id.gbr);
                holder.nama = (TextView) view.findViewById(R.id.nama);
                holder.keterangan= (TextView) view.findViewById(R.id.keterangan);
                view.setTag( holder);
            } else {
// Just get our existing holder
                holder = (Holder) view.getTag();
            }
// Populate via the holder for speed
            ModelFasilitas stream = getItem( position);
// Populate the item contents
            holder.gbr.setImageResource(R.drawable.foto1);
            holder.keterangan.setText(stream.getKeterangan());
            holder.nama.setText(stream.getNama_fasilitas());
            return view;
        }
    }

}
