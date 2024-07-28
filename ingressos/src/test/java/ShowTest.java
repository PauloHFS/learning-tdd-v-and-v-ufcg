import org.junit.jupiter.api.Test;

import com.ufcg.Show;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;

public class ShowTest {

    Show show;

    @Test
    public void testAddition() {
        int result = 2 + 3;
        assertEquals(5, result);
    }

    @Test
    public void inicializaShow() {
        String data = "06/05/2025";
        String artista = "Céline Dion";
        float cache = 300000;
        float totalDespesasInfraestrutura = 600000;
        boolean diaEspecial = false;

        this.show = new Show(data, artista, cache, totalDespesasInfraestrutura, diaEspecial);

    }

    

}
