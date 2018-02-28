package com.example.xox_ua.homeworks_05;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String[] countryNames = { "Andorra", "Austria", "Belgium", "Cyprus", "Denmark", "Estonia", "Finland", "France", "Germany", "Spain" };
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

    // имена атрибутов для Map
    final String COUNTRY_NAME = "name";
    final String COUNTRY_FLAG = "flag";
    ListView listView;
    SimpleAdapter sAdapter;
    ArrayList<Map<String, Object>> data;
    Map<String, Object> m;
    Button btnAdd;
    Button btnDel;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // фиксируем экран (запрет поворота)
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnDel = (Button) findViewById(R.id.btnDel);

        // упаковываем данные в понятную для адаптера структуру
        data = new ArrayList<Map<String, Object>>(countryNames.length);
        for (int i = 1; i < countryNames.length; i++) {
            m = new HashMap<String, Object>();
            m.put(COUNTRY_NAME, countryNames[i]);
            m.put(COUNTRY_FLAG, countryFlags[i]);
            data.add(m);
        }

        // массив имен атрибутов, из которых будут читаться данные
        String[] from = { COUNTRY_NAME, COUNTRY_FLAG };
        // массив ID View-компонентов, в которые будут вставлять данные
        int[] to = { R.id.textView, R.id.imageView };

        // создаем адаптер
        sAdapter = new SimpleAdapter(this, data, R.layout.item_list, from, to);

        // определяем список и присваиваем ему адаптер
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(sAdapter);

        // обрабатываем нажатие на строку
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String mess = "Выбрана позиция: " + position;
                Toast.makeText(getApplicationContext(), mess, Toast.LENGTH_SHORT).show();
            }
        });

        // добавляем новую строку в list
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // случайное название страны из нашего массива
                int idX = new Random().nextInt(countryNames.length);
                String randomName = (countryNames[idX]);
                // флаг соответствующий выбранной стране
                int flg = countryFlags[idX];
                // создаем новый Map
                m = new HashMap<String, Object>();
                m.put(COUNTRY_NAME, randomName + " - NEW!");
                m.put(COUNTRY_FLAG, flg);
                // добавляем его в коллекцию
                data.add(m);
                // уведомляем, что данные изменились
                sAdapter.notifyDataSetChanged();
            }
        });

        // удаляем строку из list
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // получаем случайное число в диапазоне строк в списке
                int count = listView.getCount();
                if (count == 0) {
                    Toast.makeText(getApplicationContext(),"No item for deleting", Toast.LENGTH_LONG).show();
                } else {
                    Random random = new Random();
                    int pos = random.nextInt(count);
                    // удаляем позицию равную числу выше
                    data.remove(pos);
                    // уведомляем, что данные изменились
                    sAdapter.notifyDataSetChanged();
                }
            }
        });
    }
}