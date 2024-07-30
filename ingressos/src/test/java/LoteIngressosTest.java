import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.ufcg.LoteIngressos;
import com.ufcg.TipoIngresso;

public class LoteIngressosTest {

    private static LoteIngressos lote;

    @BeforeAll
    public static void inicializaLote() {
        int id = 321;
        int quantidadeIngressos = 500;
        double porcentagem_vip = 0.2;
        double desconto = 0.15;
        double precoNormal = 10;

        lote = new LoteIngressos(id, quantidadeIngressos, porcentagem_vip, desconto, precoNormal);
    }

    @Test
    public void testLoteQuantidadeVIPMenorQueNecessario() {
        int id = 321;
        int quantidadeIngressos = 500;
        double porcentagem_vip = 0.1;
        double desconto = 0.15;
        double precoNormal = 10;

        assertThrows(RuntimeException.class, () -> { new LoteIngressos(id, quantidadeIngressos, porcentagem_vip, desconto, precoNormal); });
        
    }

    @Test
    public void testLoteQuantidadeVIPMaiorQuePermitido() {
        int id = 321;
        int quantidadeIngressos = 500;
        double porcentagem_vip = 0.5;
        double desconto = 0.15;
        double precoNormal = 10;

        assertThrows(RuntimeException.class, () -> { new LoteIngressos(id, quantidadeIngressos, porcentagem_vip, desconto, precoNormal); });
        
    }

    @Test
    public void getPrecoIngressoNormal() {
        assertEquals(8.5, lote.getPrecoIngresso(TipoIngresso.NORMAL));
    }

    @Test
    public void getPrecoIngressoVIP() {
        assertEquals(17, lote.getPrecoIngresso(TipoIngresso.VIP));
    }

    @Test
    public void getPrecoIngressoMeia() {
        assertEquals(5, lote.getPrecoIngresso(TipoIngresso.MEIA_ENTRADA));
    }

    

}
