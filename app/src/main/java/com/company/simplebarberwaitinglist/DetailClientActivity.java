package com.company.simplebarberwaitinglist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DetailClientActivity extends AppCompatActivity {

    EditText et_firstname, et_haircut;
    Button bt_cancel,bt_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_client);

        et_firstname = findViewById(R.id.et_firstname);
        et_haircut = findViewById(R.id.et_haircut);

        bt_cancel = findViewById(R.id.bt_cancel);
        bt_submit = findViewById(R.id.bt_submit);

        bt_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i_back = new Intent();
                String clientTxt = et_firstname.getText().toString()+", "
                        + et_haircut.getText().toString();
                i_back.putExtra("client_details", clientTxt);
                setResult(RESULT_OK, i_back);
                finish();
            }
        });

        bt_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i_back = new Intent();
                setResult(RESULT_CANCELED, i_back);
                finish();
            }
        });

    }
}
