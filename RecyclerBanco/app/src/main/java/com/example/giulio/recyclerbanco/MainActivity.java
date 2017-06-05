package com.example.giulio.recyclerbanco;


import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private Button btAdd;
    private TextView tvMedia; // *** precisa calcular a media

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        btAdd = (Button) findViewById(R.id.btAdd);
    }
    public void adicionarAbastecimento(View v){
        Intent intent = new Intent(MainActivity.this, AdicionarAbastecimento.class);
        startActivity(intent);
    }
    public void actShow(View v){
        Intent intent = new Intent(MainActivity.this, Show.class);
        startActivity(intent);
    }
}
