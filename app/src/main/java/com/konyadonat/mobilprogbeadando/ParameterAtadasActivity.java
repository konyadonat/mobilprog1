package com.konyadonat.mobilprogbeadando;


import static com.konyadonat.mobilprogbeadando.MainActivity.KEY;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class ParameterAtadasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parameter_atadas);

        Intent intent = getIntent();

        int i = intent.getIntExtra(KEY,-1);
        intent.putExtra(KEY,++i);

        setResult(RESULT_OK,intent);
        finish();
    }
}