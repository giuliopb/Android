package com.example.giulio.recyclerbanco;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by giulio on 05/06/2017.
 */

public class AbastecimentoHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView tvData;
    private TextView tvKm;
    private TextView tvLitro;

    private FragmentoListagem.OnItemSelectedListener tratadorDeClique;
    private Abastecimento abastecimentoDaGaveta;

    public AbastecimentoHolder(View itemView, FragmentoListagem.OnItemSelectedListener tratadorDeClique) {
        super(itemView);
        tvData = (TextView) itemView.findViewById(R.id.tvData);
        tvKm= (TextView) itemView.findViewById(R.id.tvKm);
        tvLitro = (TextView) itemView.findViewById(R.id.TvLitro);
        itemView.setOnClickListener(this);
        this.tratadorDeClique = tratadorDeClique;
    }
    public void atualizarInfoGaveta(Abastecimento abastecimentoParaGaveta){
        tvData.setText( String.valueOf( abastecimentoParaGaveta.getData() ) );
        tvKm.setText(String.valueOf(abastecimentoParaGaveta.getQuilometragem()));
        tvLitro.setText(String.valueOf(abastecimentoParaGaveta.getLitros()));
        abastecimentoDaGaveta = abastecimentoParaGaveta;

    }
    @Override
    public void onClick(View v) {

        tratadorDeClique.onAbastecimentoSelected(abastecimentoDaGaveta);
    }
}
