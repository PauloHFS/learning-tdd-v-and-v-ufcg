package com.ufcg;


public class Ingresso {

    int id;
    TipoIngresso tipo;
    boolean vendido;

    public Ingresso(int id, TipoIngresso tipo) {
        this.id = id;
        this.tipo = tipo;
        this.vendido = false;
    }

    public TipoIngresso getTipo() {
        return this.tipo;
    }

    public boolean isVendido() {
        return this.vendido;
    }

    public void setVendido() {
        this.vendido = true;
    }

}
