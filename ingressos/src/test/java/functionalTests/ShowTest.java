package functionalTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.ufcg.Ingresso;
import com.ufcg.LoteIngressos;
import com.ufcg.Show;
import com.ufcg.TipoIngresso;

public class ShowTest {

    private static Show show;

    @BeforeAll
    public static void inicializaShow() {
        String data = "06/05/2025";
        String artista = "Céline Dion";
        float cache = 3000;
        float totalDespesasInfraestrutura = 6000;
        boolean diaEspecial = false;

        show = new Show(data, artista, cache, totalDespesasInfraestrutura, diaEspecial);

    }

    @Test
    public void testStatusPREJUIZO() {

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

        assertEquals("PREJUÍZO", show.getStatus());
    }

    @Test
    public void testStatusESTAVEL() {

        String data = "06/05/2025";
        String artista = "Céline Dion";
        float cache = 3000;
        float totalDespesasInfraestrutura = 6000;
        boolean diaEspecial = false;

        Show showNovo = new Show(data, artista, cache, totalDespesasInfraestrutura, diaEspecial);


        LoteIngressos loteIngressos = new LoteIngressos(2, 100, 0.2, 0, 200);
        List<Ingresso> normais = loteIngressos.getIngressos(TipoIngresso.NORMAL);

        showNovo.addLote(loteIngressos);

        for (int i = 0; i < 45; i++) {
            int idIngresso = normais.get(i).getID();
            showNovo.venderIngresso(loteIngressos.getID(), idIngresso);
        }

        System.out.println(showNovo.getRelatorio());
        assertEquals("ESTÁVEL", showNovo.getStatus());
    }

    @Test
    public void testStatusLUCRO() {

        String data = "06/05/2025";
        String artista = "Céline Dion";
        float cache = 3000;
        float totalDespesasInfraestrutura = 6000;
        boolean diaEspecial = false;

        Show showNovo = new Show(data, artista, cache, totalDespesasInfraestrutura, diaEspecial);


        LoteIngressos loteIngressos = new LoteIngressos(2, 100, 0.2, 0, 200);
        List<Ingresso> normais = loteIngressos.getIngressos(TipoIngresso.NORMAL);

        showNovo.addLote(loteIngressos);

        for (int i = 0; i < 70; i++) {
            int idIngresso = normais.get(i).getID();
            showNovo.venderIngresso(loteIngressos.getID(), idIngresso);
        }

        System.out.println(showNovo.getRelatorio());
        assertEquals("LUCRO", showNovo.getStatus());
    }

    @Test
    public void testDespesasDataEspecialFalse() {

        String data = "06/05/2025";
        String artista = "Céline Dion";
        float cache = 3000;
        float totalDespesasInfraestrutura = 6000;
        boolean diaEspecial = false;

        Show showNovo = new Show(data, artista, cache, totalDespesasInfraestrutura, diaEspecial);

        assertEquals(6000, showNovo.getTotalDespesasInfraEstrutura());
    }

    @Test
    public void testDespesasDataEspecialTrue() {

        String data = "06/05/2025";
        String artista = "Céline Dion";
        float cache = 3000;
        float totalDespesasInfraestrutura = 6000;
        boolean diaEspecial = true;

        Show showNovo = new Show(data, artista, cache, totalDespesasInfraestrutura, diaEspecial);

        assertEquals(6900, showNovo.getTotalDespesasInfraEstrutura());
    }

}
