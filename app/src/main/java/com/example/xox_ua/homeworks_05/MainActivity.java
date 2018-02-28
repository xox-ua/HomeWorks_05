package com.example.xox_ua.homeworks_05;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    String[] countryNames = {
            "0. Andorra",
            "1. Austria",
            "2. Belgium",
            "3. Cyprus",
            "4. Denmark",
            "5. Estonia",
            "6. Finland",
            "7. France",
            "8. Germany",
            "9. Spain" };

    int[] countryFlags = {
            R.drawable.zz_flg_and,
            R.drawable.zz_flg_aut,
            R.drawable.zz_flg_bel,
            R.drawable.zz_flg_cyp,
            R.drawable.zz_flg_dnk,
            R.drawable.zz_flg_est,
            R.drawable.zz_flg_fin,
            R.drawable.zz_flg_fra,
            R.drawable.zz_flg_deu,
            R.drawable.zz_flg_esp };
    ListView lv;
    Button btnAddItem;
    Button btnRemoveItem;
    CustomListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        lv = (ListView) findViewById(R.id.lv);
        btnAddItem = (Button) findViewById(R.id.btnAdd);
        btnRemoveItem = (Button) findViewById(R.id.btnRemove);

        adapter=new CustomListAdapter(this, countryNames, countryFlags);
        lv=(ListView)findViewById(R.id.lv);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String mess = "Выбрана позиция: " + position;
                Toast.makeText(getApplicationContext(), mess, Toast.LENGTH_LONG).show();
            }
        });

        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    adapter.add("New country", R.drawable.zz_flg_eu);
                    adapter.notifyDataSetChanged();

            }
        });


    }
}
