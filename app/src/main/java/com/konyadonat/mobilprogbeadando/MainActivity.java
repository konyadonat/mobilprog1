package com.konyadonat.mobilprogbeadando;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private final String url = "https://github.com/konyadonat";
    public static final String  KEY = "ertek";
    public static final int alapertek = 50;

    RepulogepUzemmodBroadCastReceiver repulogepUzemmodBroadCastReceiver = new RepulogepUzemmodBroadCastReceiver();

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter filter = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        registerReceiver(repulogepUzemmodBroadCastReceiver,filter);

    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(repulogepUzemmodBroadCastReceiver);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Sentry.captureMessage("Sentry inicializas tesztelése");

        // Implicit intent inditas
        Button weblapbutton = findViewById(R.id.weblapbutton);


        Intent openweblap = new Intent(Intent.ACTION_VIEW,Uri.parse(url));

        weblapbutton.setOnClickListener(view -> startActivity(openweblap));

        //Explicit intent inditas
        Button gotoListViewActivity = findViewById(R.id.buttongotoListViewActivity);
        Intent openListViewActivity = new Intent(MainActivity.this, ListViewActivity.class);
        gotoListViewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(openListViewActivity);
            }
        });


        //Fragment Screen megnyitas
        Button openFragmentActivity = findViewById(R.id.fragmentScreenButton);
        Intent openFragmentAcvitityIntent = new Intent(MainActivity.this,FragmentActivity.class);
        openFragmentActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(openFragmentAcvitityIntent);
            }
        });

        //Paraméter átadása másik activityre, majd feldolgozás

        Button ertekAtadasButton = findViewById(R.id.ertekatadasButton);
        Intent parameterAtadas = new Intent(MainActivity.this,ParameterAtadasActivity.class);
        TextView kapottertek = findViewById(R.id.kapottertek);
        TextView parameterErtekTextView = findViewById(R.id.paramterErtekTextView);
        parameterErtekTextView.setText(parameterErtekTextView.getText() + String.valueOf(alapertek));
        parameterAtadas.putExtra(KEY,alapertek);
        ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode() == RESULT_OK){
                            Intent data = result.getData();
                            int i = data.getIntExtra(KEY,100);
                            kapottertek.setText(String.valueOf(i));
                        }
                    }
                }
        );
        ertekAtadasButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activityResultLauncher.launch(parameterAtadas);
            }
        });

        //SharedPreferences
        Button sharedPreferencesKiirButton = findViewById(R.id.sharedPreferencesErtekKiirButton);
        sharedPreferencesKiirButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
                String nev = sharedPreferences.getString("nev","nev");
                String email = sharedPreferences.getString("email","email");

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("nev","Kónya Donát");
                editor.putString("email","konya.donat@gmail.com");
                editor.commit();

                nev = sharedPreferences.getString("nev","nev");
                email = sharedPreferences.getString("email","email");
                Toast.makeText(getApplicationContext(),nev,Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(),email,Toast.LENGTH_SHORT).show();

            }
        });

    }



    /*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==24){
            if(requestCode==RESULT_OK){
                int adat = data.getIntExtra(KEY,-1);
            }
        }
    }
    */
}