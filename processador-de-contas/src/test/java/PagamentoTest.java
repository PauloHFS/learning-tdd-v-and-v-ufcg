
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Test;

import com.ufcg.Conta;
import com.ufcg.MetodosPagamento;
import com.ufcg.pagamento.Pagamento;

public class PagamentoTest {

  @Test
  public void should_be_boleto_paga() {
    var conta = new Conta(50000, LocalDate.of(2023, 02, 20));
    var pagamento = new Pagamento(1000, MetodosPagamento.BOLETO, LocalDate.of(2023, 02, 20), conta);

    var result = pagamento.isPaga();

    assertTrue("isPaga deveria restornar true", result);
  }

}
