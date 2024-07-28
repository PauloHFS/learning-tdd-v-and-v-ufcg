import org.junit.jupiter.api.Test;

import com.ufcg.Show;

import static org.junit.jupiter.api.Assertions.*;

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



}
