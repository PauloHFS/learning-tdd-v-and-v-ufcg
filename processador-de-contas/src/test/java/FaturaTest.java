import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import com.ufcg.Fatura;

public class FaturaTest {

  Fatura fatura;

  @Before
  public void beforeEach() {
    this.fatura = new Fatura();
  }

  @Test
  public void should_return_the_fatura_value() {
    assertEquals(1500, fatura.getValor());
  }

  @Test
  public void should_return_the_fatura_client() {
    assertEquals("João Silva", fatura.getNomeCliente());
  }

  @Test
  public void should_return_the_fatura_data() {
    assertEquals(LocalDate.of(2024, 06, 24), fatura.getData());
  }

  @Test
  public void should_be_a_fatura_PAGA() {
    assertEquals(true, fatura.isPaga());
    assertEquals(false, fatura.isPendente());

  }

  @Test
  public void should_be_a_fatura_PENDENTE() {
    assertEquals(true, fatura.isPendente());
    assertEquals(false, fatura.isPaga());
  }

}
