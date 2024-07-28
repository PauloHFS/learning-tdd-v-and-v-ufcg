import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.ufcg.Ingresso;
import com.ufcg.TipoIngresso;

public class IngressoTest {

    private static Ingresso ingresso;

    @BeforeAll
    public static void inicializaIngresso() {
        int id = 1;

        ingresso = new Ingresso(id, TipoIngresso.NORMAL);
    }

    @Test
    public void testGetTipo() {
        assertEquals(TipoIngresso.NORMAL, ingresso.getTipo());
    }

}
