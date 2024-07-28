package com.ufcg;

public class Ingresso {

    int id;
    TipoIngresso tipo;

    public Ingresso(int id, TipoIngresso tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public TipoIngresso getTipo() {
        return this.tipo;
    }

}
