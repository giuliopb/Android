package com.example.giulio.recyclerbanco.storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by giulio on 05/06/2017.
 */

public class BdHelper extends SQLiteOpenHelper{

    private static final int VERSAO = 1;
    public static final String NOME_BD = "meu_bd";

    public BdHelper(Context context){

        super(context, NOME_BD, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE abastecimentos (" +
                "id integer primary key," +
                "posto text," +
                "kmAtual double," +
                "data text," +
                "litrosAbastecidos double" +
                ");");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
