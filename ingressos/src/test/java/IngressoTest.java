import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.ufcg.Ingresso;
import com.ufcg.TipoIngresso;

public class IngressoTest {

    private static Ingresso ingresso;

    @BeforeAll
    public static void inicializaIngresso() {
        int id = 1239;

        ingresso = new Ingresso(id, TipoIngresso.NORMAL);
    }

    @Test
    public void testGetID() {
        assertEquals(1239, ingresso.getID());
    }

    @Test
    public void testGetTipo() {
        assertEquals(TipoIngresso.NORMAL, ingresso.getTipo());
    }

    @Test
    public void testIsVendido() {
        Ingresso ingresso2 = new Ingresso(1212, TipoIngresso.NORMAL);
        assertFalse(ingresso2.isVendido());
    }

    @Test
    public void testVenderIngresso() {
        assertFalse(ingresso.isVendido());
        ingresso.setVendido();
        assertTrue(ingresso.isVendido());
    }

}
