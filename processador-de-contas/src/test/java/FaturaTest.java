import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.ufcg.Conta;
import com.ufcg.Fatura;

public class FaturaTest {

  Fatura fatura;

  @Before
  public void beforeEach() {
    var clientName = "João Silva";
    var dataVencimento = LocalDate.of(2024, 06, 24);
    var contas = List.of(new Conta(500), new Conta(1000));

    this.fatura = new Fatura(
        clientName,
        dataVencimento,
        contas);
  }

  @Test
  public void should_return_the_fatura_value() {
    assertEquals(Integer.valueOf(1500), fatura.getValor());
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
