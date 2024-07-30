package com.ufcg;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LoteIngressos {

    private int id;
    private List<Ingresso> ingressos;
    private double desconto;
    private double precoNormal;

    public LoteIngressos(int id, int quantidade_ingressos, double porcentagem_vip, double desconto, double precoNormal) {
        if (porcentagem_vip > 0.3 || porcentagem_vip < 0.2) throw new RuntimeException("Quantidade de VIPs deve ser entre 10% e 20%");
        if (desconto > 0.25) throw new RuntimeException("Desconto não deve exceder 25%");
        
        this.id = id;
        this.desconto = desconto;
        this.precoNormal = precoNormal;
        this.ingressos = new ArrayList<Ingresso>();

        Random random = new Random();

        int quantidade_vip = (int) Math.floor(quantidade_ingressos * porcentagem_vip);
        int quantidade_meia = (int) Math.floor(quantidade_ingressos * 0.1);
        int quantidade_normal = quantidade_ingressos - quantidade_meia - quantidade_vip;

        
        for (int i = 0; i < quantidade_normal; i++) {
            int id_ingresso = random.nextInt(1000);
            Ingresso novoIngresso = new Ingresso(id_ingresso, TipoIngresso.NORMAL);
            ingressos.add(novoIngresso);
        }

        for (int i = 0; i < quantidade_meia; i++) {
            int id_ingresso = random.nextInt(1000);
            Ingresso novoIngresso = new Ingresso(id_ingresso, TipoIngresso.MEIA_ENTRADA);
            ingressos.add(novoIngresso);
        }

        for (int i = 0; i < quantidade_vip; i++) {
            int id_ingresso = random.nextInt(1000);
            Ingresso novoIngresso = new Ingresso(id_ingresso, TipoIngresso.VIP);
            ingressos.add(novoIngresso);
        }

    }

    public double getPrecoIngresso(TipoIngresso tipoIngresso) {
        if (tipoIngresso == TipoIngresso.NORMAL)
            return precoNormal * (1 - desconto);
        else if (tipoIngresso == TipoIngresso.VIP)
            return precoNormal * 2 * (1 - desconto);
        else
            return precoNormal / 2;
    }

}
