package com.example.giulio.recyclerbanco;

import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by giulio on 22/05/2017.
 */

public class Abastecimento_Adapter extends RecyclerView.Adapter<Abastecimento_Adapter.MyViewHolder> {

    private List<Abastecimento> abastecimentoList;

    public Abastecimento_Adapter(List<Abastecimento> abastecimentoList) {
        this.abastecimentoList = abastecimentoList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.abastecimento_lista, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Abastecimento abastecimento =  abastecimentoList.get(position);
        holder.tvData.setText((CharSequence) abastecimento.getData());
        holder.tvKm.setText((int) abastecimento.getQuilometragem());
        holder.tvLitro.setText((int) abastecimento.getLitros());

    }

    @Override
    public int getItemCount() {
        return abastecimentoList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView tvData, tvKm, tvLitro;
        public ImageView ivPosto;


        public MyViewHolder(View itemView) {
            super(itemView);

            tvData = (TextView) itemView.findViewById(R.id.tvData);
            tvKm = (TextView) itemView.findViewById(R.id.tvKm);
            tvLitro = (TextView) itemView.findViewById(R.id.TvLitro);

        }
    }
}
