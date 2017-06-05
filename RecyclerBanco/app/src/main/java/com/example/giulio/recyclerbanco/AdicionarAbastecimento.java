package com.example.giulio.recyclerbanco;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.giulio.recyclerbanco.storage.BdHelper;

/**
 * Created by giulio on 22/05/2017.
 */

public class AdicionarAbastecimento extends AppCompatActivity {

    private EditText etKm;
    private EditText etLitros;
    private Spinner spPosto;
    private TextView tvData;
    private Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adicionar_abastecimento);

        etKm = (EditText) findViewById(R.id.etKm);
        etLitros = (EditText) findViewById(R.id.etLitros);
        spPosto = (Spinner) findViewById(R.id.spPosto);
        tvData = (TextView) findViewById(R.id.tvData);
        btnSalvar = (Button) findViewById(R.id.btnSalvar);
    }

    public void salvar(View v) {

        BdHelper bdHelper = new BdHelper(AdicionarAbastecimento.this);
        SQLiteDatabase bd = bdHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        if (valida()) {
            ContentValues values = new ContentValues();
            values.put("kmAtual", Double.parseDouble(etKm.getText().toString()));
            values.put("litrosAbastecidos", Double.parseDouble(etLitros.getText().toString()));
            values.put("posto", spPosto.getSelectedItem().toString());
            values.put("data", (String) tvData.getText());

            long newRowId = bd.insert("abastecimentos", null, values);
            Toast.makeText(this, "Salvo com id: " + newRowId, Toast.LENGTH_LONG).show();
        }
    }

    private boolean valida() {
        if (etKm.getText().toString().trim().length() <= 0) {
            etKm.setError("o campo nao foi preenchido");
            return false;
        }
        if (etLitros.getText().toString().trim().length() <= 0) {
            etLitros.setError("o campo nao foi preenchido");
            return false;
        }
        if(recuperar("maior") >= Double.parseDouble(etKm.getText().toString())){
            etKm.setError("essa quilometragem é menor que a ultima digitada");
            return false;
        }
            return true;
    }

    private double recuperar(String qual) {// a string qual é o que voce quer recuperar pela quilometragem, OPÇOES: menor, maior e tudo.
        BdHelper bdHelper = new BdHelper(this);
        SQLiteDatabase db = bdHelper.getReadableDatabase();
        String[] projecao = {
                "kmAtual",
                "litrosAbastecidos",
                "posto",
                "data"};

     String orderBy = "";
     if(qual.equals("menor")){
         orderBy = "kmAtual ASC";
     }else{
         orderBy = "kmAtual DESC";
     }


        Cursor c = db.query(
                "abastecimentos",                         // Tabela
                projecao,                               // Colunas para seleção
                null,                                  // colunas WHERE
                null,                           // valores WHERE
                null,                                   // GROUP BY
                null,                                   // FILTER BY
                orderBy                                 // ORDER BY
        );

        if(qual.equals("maior") || qual.equals("menor")){
            String resultado = "";
            if (c.moveToFirst()) {
                resultado = c.getString(0);
            }
            return Double.parseDouble(resultado);
        }
        //implementar pra retornar todos


        return 0;
    }
}