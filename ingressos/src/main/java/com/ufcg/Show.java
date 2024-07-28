package com.ufcg;

public class Show {

    private String data;
    private String artista;
    private float cache;
    private float totalDespesasInfraEstrutura;
    private boolean diaEspecial;


    public Show(String data, String artista, float cache, float totalDespesasInfraestrutura, boolean diaEspecial) {
        this.data = data;
        this.artista = artista;
        this.cache = cache;
        this.totalDespesasInfraEstrutura = totalDespesasInfraestrutura;
        this.diaEspecial = diaEspecial;

    }


    public Object getData() {
        return data;
    }
    
    public void setData(String data) {
        this.data = data;
    }


    public String getArtista() {
        return artista;
    }


    public void setArtista(String artista) {
        this.artista = artista;
    }


    public float getCache() {
        return cache;
    }


    public void setCache(float cache) {
        this.cache = cache;
    }


    public float getTotalDespesasInfraEstrutura() {
        return totalDespesasInfraEstrutura;
    }


    public void setTotalDespesasInfraEstrutura(float totalDespesasInfraEstrutura) {
        this.totalDespesasInfraEstrutura = totalDespesasInfraEstrutura;
    }


    public boolean isDiaEspecial() {
        return diaEspecial;
    }


    public void setDiaEspecial(boolean diaEspecial) {
        this.diaEspecial = diaEspecial;
    }



}
