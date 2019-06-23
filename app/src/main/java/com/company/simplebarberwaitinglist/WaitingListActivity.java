package com.company.simplebarberwaitinglist;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class WaitingListActivity extends AppCompatActivity {
    ListView lv_list;
    ArrayList<String> maliste;
    Button bt_clear;
    ArrayAdapter adapterWaitingList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv_list = findViewById(R.id.lv_liste);
        bt_clear = findViewById(R.id.bt_clear);

        maliste = new ArrayList<>();

        adapterWaitingList = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, maliste);

        lv_list.setAdapter(adapterWaitingList);

        bt_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapterWaitingList.clear();
            }
        });

        lv_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                adapterWaitingList.remove(adapterWaitingList.getItem(position));
            }
        });

    }

    public void ajouter(View view) {
        Intent i_DetailClient = new Intent(getApplicationContext(), DetailClientActivity.class);
        startActivityForResult(i_DetailClient, 101);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101) {
            if (resultCode == RESULT_OK) {
                String msg_back = data.getExtras().getString("client_details");
                adapterWaitingList.add(msg_back);
            } else if (resultCode == RESULT_CANCELED) {
            }
        }

    }
}
