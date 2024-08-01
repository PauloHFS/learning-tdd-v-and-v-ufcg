import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Optional;

import org.junit.Test;

import com.ufcg.Conta;
import com.ufcg.Fatura;
import com.ufcg.MetodosPagamento;
import com.ufcg.pagamento.Pagamento;

public class FaturaTest {

  @Test
  public void should_be_paga_exemplo_1() {
    /*
     * Exemplo 1: Fatura de 1.500,00 (20/02/2023) com 3 contas no valor de 500,00,
     * 400,00 e 600,00. As três contas foram pagas por boleto no dia 20/02/2023
     * (todas em dia), assim a fatura é marcada como PAGA.
     */
    var contaPagamentoMap = new HashMap<Conta, Optional<Pagamento>>();

    var conta = new Conta(50000, LocalDate.of(2023, 02, 20));
    contaPagamentoMap.put(conta,
        Optional.of(new Pagamento(1000, MetodosPagamento.BOLETO, LocalDate.of(2023, 02, 20), conta)));

    conta = new Conta(40000, LocalDate.of(2023, 02, 20));
    contaPagamentoMap.put(conta,
        Optional.of(new Pagamento(800, MetodosPagamento.BOLETO, LocalDate.of(2023, 02, 20), conta)));

    conta = new Conta(60000, LocalDate.of(2023, 02, 20));
    contaPagamentoMap.put(conta,
        Optional.of(new Pagamento(1200, MetodosPagamento.BOLETO, LocalDate.of(2023, 02, 20), conta)));

    var fatura = new Fatura("Cliente", LocalDate.of(2023, 02, 20), contaPagamentoMap);

    var result = fatura.isPaga();

    assertTrue("isPaga deveria retornar true", result);
  }

  @Test
  public void should_be_paga_exemplo_2() {
    /*
     * Exemplo 2: Fatura de 1.500,00 (20/02/2023) com uma conta no valor 700,00 e
     * outra conta de 800,00. A primeira conta foi paga por cartão de crédito
     * (05/02/2023), enquanto que a segunda conta foi paga por transferência
     * (17/02/2023). Assim, a fatura é marcada como PAGA.
     */

    var contaPagamentoMap = new HashMap<Conta, Optional<Pagamento>>();

    var conta = new Conta(70000, LocalDate.of(2023, 02, 20));
    contaPagamentoMap.put(conta,
        Optional.of(new Pagamento(700, MetodosPagamento.CARTAO_CREDITO, LocalDate.of(2023, 02, 05), conta)));

    conta = new Conta(80000, LocalDate.of(2023, 02, 20));

    contaPagamentoMap.put(conta,
        Optional.of(new Pagamento(800, MetodosPagamento.TRANSFERENCIA_BANCARIA, LocalDate.of(2023, 02, 17), conta)));

    var fatura = new Fatura("Cliente", LocalDate.of(2023, 02, 20), contaPagamentoMap);

    var result = fatura.isPaga();

    assertTrue("isPaga deveria retornar true", result);
  }

  @Test
  public void should_be_pendente_exemplo_3() {
    /*
     * Exemplo 3: Fatura de 1.500,00 (20/02/2023) com uma conta no valor 700,00 e
     * outra conta de 800,00. A primeira conta foi paga por cartão de crédito
     * (06/02/2023), enquanto que a segunda conta foi paga por transferência
     * (17/02/2023). Assim, a fatura é marcada como PENDENTE.
     */

    var contaPagamentoMap = new HashMap<Conta, Optional<Pagamento>>();

    var conta = new Conta(70000, LocalDate.of(2023, 02, 20));
    contaPagamentoMap.put(conta,
        Optional.of(new Pagamento(70000, MetodosPagamento.CARTAO_CREDITO, LocalDate.of(2023, 02, 06), conta)));

    conta = new Conta(80000, LocalDate.of(2023, 02, 20));

    contaPagamentoMap.put(conta,
        Optional.of(new Pagamento(80000, MetodosPagamento.TRANSFERENCIA_BANCARIA, LocalDate.of(2023, 02, 17), conta)));

    var fatura = new Fatura("Cliente", LocalDate.of(2023, 02, 20), contaPagamentoMap);

    var result = fatura.isPaga();

    assertFalse("isPaga deveria retornar false", result);
  }
}
