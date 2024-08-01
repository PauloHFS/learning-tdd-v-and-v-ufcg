import org.junit.jupiter.api.Test;

import com.ufcg.Ingresso;
import com.ufcg.LoteIngressos;
import com.ufcg.Show;
import com.ufcg.TipoIngresso;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;

public class ShowTest {

    private static Show show;

    @Test
    public void testAddition() {
        int result = 2 + 3;
        assertEquals(5, result);
    }

    @BeforeAll
    public static void inicializaShow() {
        String data = "06/05/2025";
        String artista = "Céline Dion";
        float cache = 300000;
        float totalDespesasInfraestrutura = 600000;
        boolean diaEspecial = false;

        show = new Show(data, artista, cache, totalDespesasInfraestrutura, diaEspecial);

    }

    @Test
    public void testGetDataShow() {
        assertEquals("06/05/2025", show.getData());

    }

    @Test
    public void testGetArtista() {
        assertEquals("Céline Dion", show.getArtista());

    }

    @Test
    public void testCache() {
        assertEquals(300000, show.getCache());

    }

    @Test
    public void testGetDespesas() {
        assertEquals(600000, show.getTotalDespesasInfraEstrutura());

    }

    @Test
    public void testGetDiaEspecial() {
        assertFalse(show.isDiaEspecial());

    }

    @Test
    public void testAssociaShowALote() {
        LoteIngressos lote = new LoteIngressos(321, 200, 0.23, 0.0, 20);
        show.addLote(lote);
        
        List<LoteIngressos> collection_lotes = new ArrayList<>(Arrays.asList(lote));
        assertEquals(collection_lotes, show.getLotesIngressos());
    }

    @Test
    public void testGetRelatorio() {
        String relatorio = "Número de Ingressos VIP Vendidos: 2 | Número de Ingressos NORMAL Vendidos: 1 | Número de Ingressos MEIA_ENTRADA Vendidos: 0 | Receita: -899.000 | Status: PREJUÍZO";

        LoteIngressos loteIngressos = new LoteIngressos(2, 100, 0.2, 0, 200);
        List<Ingresso> vips = loteIngressos.getIngressos(TipoIngresso.VIP);
        List<Ingresso> normais = loteIngressos.getIngressos(TipoIngresso.NORMAL);

        show.addLote(loteIngressos);

        int idIngresso1 = vips.get(0).getID();

        int idIngresso2 = vips.get(1).getID();

        int idIngresso3 = normais.get(0).getID();

        show.venderIngresso(loteIngressos.getID(), idIngresso1);
        show.venderIngresso(loteIngressos.getID(), idIngresso2);
        show.venderIngresso(loteIngressos.getID(), idIngresso3);
        
        //assertEquals(1, loteIngressos.getQuantidadeVendidos(TipoIngresso.VIP));


        assertEquals(relatorio, show.getRelatorio());
    }



}
