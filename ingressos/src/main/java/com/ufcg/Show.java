package com.ufcg;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class Show {

    private String data;
    private String artista;
    private double cache;
    private double totalDespesasInfraEstrutura;
    private boolean diaEspecial;
    private List<LoteIngressos> loteIngressos;


    public Show(String data, String artista, double cache, double totalDespesasInfraestrutura, boolean diaEspecial) {
        this.data = data;
        this.artista = artista;
        this.cache = cache;
        this.diaEspecial = diaEspecial;
        this.totalDespesasInfraEstrutura = totalDespesasInfraestrutura;
        this.loteIngressos = new ArrayList<>();

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


    public double getCache() {
        return cache;
    }


    public void setCache(float cache) {
        this.cache = cache;
    }


    public double getTotalDespesasInfraEstrutura() {
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


    public void addLote(LoteIngressos lote) {
        loteIngressos.add(lote);
    }


    public List<LoteIngressos> getLotesIngressos() {
        return loteIngressos;
    }


    public String getRelatorio() {
        int vendidosVip = 0;
        int vendidosMeia = 0;
        int vendidosNormal = 0;
        double receitaLiquida;
        String status;

        double receita = 0;
        double custos = (diaEspecial) ? (totalDespesasInfraEstrutura * 1.15) + cache: totalDespesasInfraEstrutura + cache;
        double precoVip;
        double precoNormal;
        double precoMeia;
        for (LoteIngressos lote : loteIngressos) {
            vendidosVip += lote.getQuantidadeVendidos(TipoIngresso.VIP);
            precoVip = lote.getPrecoIngresso(TipoIngresso.VIP);
            receita += vendidosVip * precoVip;

            vendidosMeia += lote.getQuantidadeVendidos(TipoIngresso.MEIA_ENTRADA);
            precoMeia = lote.getPrecoIngresso(TipoIngresso.MEIA_ENTRADA);
            receita += vendidosMeia * precoMeia;
            
            vendidosNormal += lote.getQuantidadeVendidos(TipoIngresso.NORMAL);
            precoNormal = lote.getPrecoIngresso(TipoIngresso.NORMAL);
            receita += vendidosNormal * precoNormal;
        }

        receitaLiquida = receita - custos;
        status = (receitaLiquida > 0) ? "LUCRO" : (receitaLiquida == 0) ? "ESTÁVEL" : "PREJUÍZO";
        String retorno = MessageFormat.format("Número de Ingressos VIP Vendidos: {0} | Número de Ingressos NORMAL Vendidos: {1} | Número de Ingressos MEIA_ENTRADA Vendidos: {2} | Receita: {3} | Status: {4}", 
                                                vendidosVip, vendidosNormal, vendidosMeia, receitaLiquida, status);
        
        return retorno;
    }


    public void venderIngresso(int idLote, int idIngresso) {
        for (LoteIngressos loteIngresso : loteIngressos) {
            if (loteIngresso.getID() == idLote) {
                loteIngresso.vender(idIngresso);
                break;
            }
        }
    }



}
