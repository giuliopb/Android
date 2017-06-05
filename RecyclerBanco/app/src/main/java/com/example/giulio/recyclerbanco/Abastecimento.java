package com.example.giulio.recyclerbanco;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by giulio on 22/05/2017.
 */

public class Abastecimento implements Serializable {

    public static ArrayList<Abastecimento> listaAbastecimentos;

    public static ArrayList<Abastecimento> obterListaAbastecimentos(){
        return Abastecimento.listaAbastecimentos;
    }

    private String nome;
    private String data;
    private double litros;
    private double quilometragem;

    public Abastecimento() {
    }

    public Abastecimento(String nome, String data, double litros, double quilometragem) {
        this.nome = nome;
        this.data = data;
        this.litros = litros;
        this.quilometragem = quilometragem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getLitros() {
        return litros;
    }

    public void setLitros(double litros) {
        this.litros = litros;
    }

    public double getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(double quilometragem) {
        this.quilometragem = quilometragem;
    }
}
