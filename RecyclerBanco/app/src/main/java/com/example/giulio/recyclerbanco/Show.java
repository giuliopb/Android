package com.example.giulio.recyclerbanco;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by giulio on 05/06/2017.
 */

public class Show extends AppCompatActivity implements FragmentoListagem.OnItemSelectedListener {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show);

        FragmentoListagem fragmentoListagem = new FragmentoListagem();

        FragmentTransaction transacao =  getSupportFragmentManager().beginTransaction();
        transacao.replace(R.id.flFragmento1, fragmentoListagem);
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            FragmentoDetalhe fragmentoDetalhe = new FragmentoDetalhe();
            transacao.replace(R.id.flFragmento2, fragmentoDetalhe);
        }
        transacao.commit();
    }

    @Override
    public void onAbastecimentoSelected(Abastecimento a) {

    }
}
