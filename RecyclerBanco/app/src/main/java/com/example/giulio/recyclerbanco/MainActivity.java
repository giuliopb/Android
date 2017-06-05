package com.example.giulio.recyclerbanco;


import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btAdd;
    private TextView tvMedia; // *** precisa calcular a media

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMedia= (TextView) findViewById(R.id.tvMedia);
       // tvMedia.setText(String.valueOf(calculMedia()));         problema ao recuperar os dados
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
    private Double calculMedia(){
        AdicionarAbastecimento abastecimentos = new AdicionarAbastecimento();
        Abastecimento.listaAbastecimentos = abastecimentos.recueperarTudo();
        int contador = 0;
        double litros=0;
        double kmIni=Abastecimento.obterListaAbastecimentos().get(contador).getQuilometragem();
        double kmFinal = Abastecimento.obterListaAbastecimentos().get(Abastecimento.obterListaAbastecimentos().size()-1).getQuilometragem();
        do {
            litros = litros + Abastecimento.obterListaAbastecimentos().get(contador).getLitros();
        }while(Abastecimento.listaAbastecimentos.size() > contador);

        return (kmFinal-kmIni)/litros;
    }
}
