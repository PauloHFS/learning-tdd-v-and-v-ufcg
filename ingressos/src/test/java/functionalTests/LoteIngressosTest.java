package functionalTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.ufcg.LoteIngressos;
import com.ufcg.TipoIngresso;

public class LoteIngressosTest {

    private static LoteIngressos lote;

    @Test
    public void testDescontoZero() {
        int id = 321;
        int quantidadeIngressos = 500;
        double porcentagem_vip = 0.2;
        double desconto = 0.0;
        double precoNormal = 500;

        lote = new LoteIngressos(id, quantidadeIngressos, porcentagem_vip, desconto, precoNormal);

        assertEquals(500, lote.getPrecoIngresso(TipoIngresso.NORMAL));

    }

    @Test
    public void testDesconto1() {
        int id = 321;
        int quantidadeIngressos = 500;
        double porcentagem_vip = 0.2;
        double desconto = 0.01;
        double precoNormal = 500;

        lote = new LoteIngressos(id, quantidadeIngressos, porcentagem_vip, desconto, precoNormal);

        assertEquals(495, lote.getPrecoIngresso(TipoIngresso.NORMAL));

    }

    @Test
    public void testDesconto10() {
        int id = 321;
        int quantidadeIngressos = 500;
        double porcentagem_vip = 0.2;
        double desconto = 0.10;
        double precoNormal = 500;

        lote = new LoteIngressos(id, quantidadeIngressos, porcentagem_vip, desconto, precoNormal);

        assertEquals(450, lote.getPrecoIngresso(TipoIngresso.NORMAL));

    }

    @Test
    public void testDesconto24() {
        int id = 321;
        int quantidadeIngressos = 500;
        double porcentagem_vip = 0.2;
        double desconto = 0.24;
        double precoNormal = 500;

        lote = new LoteIngressos(id, quantidadeIngressos, porcentagem_vip, desconto, precoNormal);

        assertEquals(380, lote.getPrecoIngresso(TipoIngresso.NORMAL));

    }

    @Test
    public void testDesconto25() {
        int id = 321;
        int quantidadeIngressos = 500;
        double porcentagem_vip = 0.2;
        double desconto = 0.25;
        double precoNormal = 500;

        lote = new LoteIngressos(id, quantidadeIngressos, porcentagem_vip, desconto, precoNormal);

        assertEquals(375, lote.getPrecoIngresso(TipoIngresso.NORMAL));

    }

    @Test
    public void testPrecoNORMAL() {
        int id = 321;
        int quantidadeIngressos = 500;
        double porcentagem_vip = 0.2;
        double desconto = 0.0;
        double precoNormal = 500;

        lote = new LoteIngressos(id, quantidadeIngressos, porcentagem_vip, desconto, precoNormal);

        assertEquals(500, lote.getPrecoIngresso(TipoIngresso.NORMAL));

    }

    @Test
    public void testPrecoMEIA() {
        int id = 321;
        int quantidadeIngressos = 500;
        double porcentagem_vip = 0.2;
        double desconto = 0.0;
        double precoNormal = 500;

        lote = new LoteIngressos(id, quantidadeIngressos, porcentagem_vip, desconto, precoNormal);

        assertEquals(250, lote.getPrecoIngresso(TipoIngresso.MEIA_ENTRADA));

    }

    @Test
    public void testPrecoVIP() {
        int id = 321;
        int quantidadeIngressos = 500;
        double porcentagem_vip = 0.2;
        double desconto = 0.0;
        double precoNormal = 500;

        lote = new LoteIngressos(id, quantidadeIngressos, porcentagem_vip, desconto, precoNormal);

        assertEquals(1000, lote.getPrecoIngresso(TipoIngresso.VIP));

    }


}

    