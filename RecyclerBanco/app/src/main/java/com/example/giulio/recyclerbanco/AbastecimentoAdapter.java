package com.example.giulio.recyclerbanco;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by giulio on 22/05/2017.
 */

public class AbastecimentoAdapter extends RecyclerView.Adapter {

    private FragmentoListagem.OnItemSelectedListener tratadorDeClique;

    public AbastecimentoAdapter(FragmentoListagem.OnItemSelectedListener tratadorDeClique){
        this.tratadorDeClique = tratadorDeClique;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View elementoPrincipal = LayoutInflater.from( parent.getContext() ).inflate(R.layout.gaveta_abastecimento, null);
        AbastecimentoHolder gaveta = new AbastecimentoHolder(elementoPrincipal, tratadorDeClique);
        Log.d("RV", "Criando gaveta "+gaveta);
        return gaveta;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        AbastecimentoHolder abastecimentoHolder = (AbastecimentoHolder) holder;
        abastecimentoHolder.atualizarInfoGaveta( Abastecimento.obterListaAbastecimentos().get(position) );
        Log.d("RV", "Atualizou a gaveta "+abastecimentoHolder);
    }
    @Override
    public int getItemCount() {
        return Abastecimento.obterListaAbastecimentos().size();
    }
}