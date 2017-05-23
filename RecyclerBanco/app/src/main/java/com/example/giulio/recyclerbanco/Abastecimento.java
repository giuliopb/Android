package com.example.giulio.recyclerbanco;

import java.util.Date;

/**
 * Created by giulio on 22/05/2017.
 */

public class Abastecimento {
    private String nome;
    private Date data;
    private float litros;
    private float quilometragem;

    public Abastecimento() {
    }

    public Abastecimento(String nome, Date data, float litros, float quilometragem) {
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public float getLitros() {
        return litros;
    }

    public void setLitros(float litros) {
        this.litros = litros;
    }

    public float getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(float quilometragem) {
        this.quilometragem = quilometragem;
    }
}
