package com.example.giulio.recyclerbanco;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
/**
 * Created by giulio on 05/06/2017.
 */

public class FragmentoListagem extends Fragment {
    private OnItemSelectedListener listener;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.interface_listagem, container, false);
        RecyclerView rvLista = (RecyclerView) v.findViewById(R.id.rvLista);

        Abastecimento.listaAbastecimentos = new ArrayList<>();
        Abastecimento.listaAbastecimentos.add(new Abastecimento("oi", "oi", 16, 15));
        Abastecimento.listaAbastecimentos.add(new Abastecimento("Batman", "ke", 14, 13));

        AbastecimentoAdapter adaptadorDeAbastecimento = new AbastecimentoAdapter(listener);

        rvLista.setLayoutManager(new LinearLayoutManager(this.getContext()));
        rvLista.setAdapter(adaptadorDeAbastecimento);

        return v;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof OnItemSelectedListener){
            this.listener = (OnItemSelectedListener) context;
            //conseguiríamos, caso desejássemos, fazer o cast para MainActicity
        } else {
            //a activity que adicionou o fragment não implementa a interface
        }
    }

    public interface OnItemSelectedListener {
        void onAbastecimentoSelected(Abastecimento a);
    }
}
