package com.example.giulio.recyclerbanco;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by giulio on 05/06/2017.
 */

public class FragmentoDetalhe extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.interface_detalhe, container, false);
        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        if(getArguments()==null){
            return;
        }
        TextView tvData = (TextView) view.findViewById(R.id.tvData);
        TextView tvKm = (TextView) view.findViewById(R.id.tvKm);
        TextView tvLitro = (TextView) view.findViewById(R.id.TvLitro);
        Abastecimento f = (Abastecimento) getArguments().getSerializable("abastecimento");
        tvData.setText(String.valueOf(f.getData()));
        tvKm.setText(String.valueOf(f.getQuilometragem()));
        tvLitro.setText(String.valueOf(f.getLitros()));

    }
}