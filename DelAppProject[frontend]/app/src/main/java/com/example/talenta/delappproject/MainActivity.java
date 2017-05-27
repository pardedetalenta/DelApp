package com.example.talenta.delappproject;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static java.net.Authenticator.RequestorType.SERVER;

public class MainActivity extends ListActivity {

    String[] menu = {"Deskripsi IT DEL", "Kegiatan IT Del", "Fasilitas IT Del"};

    @Override

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);

        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menu));

    }

    public void onListItemClick(ListView parent, View v, int urutan, long id) {

        Object detail = this.getListAdapter().getItem(urutan);

        String tampil = detail.toString();

        Intent i = null;

        if (tampil == "Deskripsi IT DEL") {

            i = new Intent(MainActivity.this, DeskripsiActivity.class);

            startActivity(i);

        } else if (tampil == "Kegiatan IT Del") {

            i = new Intent(MainActivity.this, KegiatanActivity.class);

            startActivity(i);

        }
        else if (tampil == "Fasilitas IT Del") {

            i = new Intent(MainActivity.this, FasilitasActivity.class);

            startActivity(i);
        }

    }

}
