package com.konyadonat.mobilprogbeadando;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        Button buttonvisszaListview = findViewById(R.id.buttonvisszaListView);

        buttonvisszaListview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        String [] jatekok = new String[]{"World of Warcraft","League of Legends","Minecraft","Apex Legends"};

        JatekAdapter jatekAdapter = new JatekAdapter(jatekok,ListViewActivity.this);

        ListView listView = findViewById(R.id.listview);
        listView.setAdapter(jatekAdapter);


        ListView listView1 = findViewById(R.id.listview1);
        String [] kaja = new String[]{"Hambi","Buri"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,kaja);
        listView1.setAdapter(adapter);
    }
}