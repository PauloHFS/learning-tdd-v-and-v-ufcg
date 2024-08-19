
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Test;

import com.ufcg.Conta;
import com.ufcg.MetodosPagamento;
import com.ufcg.pagamento.Pagamento;

public class PagamentoTest {

  // 1. Análise de Valores Limite

  @Test
  public void should_be_boleto_paga() {
    var conta = new Conta(50000, LocalDate.of(2023, 02, 20));
    var pagamento = new Pagamento(1000, MetodosPagamento.BOLETO, LocalDate.of(2023, 02, 20), conta);

    var result = pagamento.isPaga();

    assertTrue("isPaga deveria restornar true", result);
  }

  @Test(expected = IllegalArgumentException.class)
  public void pagamento_value_below_zero() {
    var conta = new Conta(50000, LocalDate.of(2023, 02, 20));
    var pagamento = new Pagamento(-100, MetodosPagamento.BOLETO, LocalDate.of(2024, 10, 06), conta);
  }

  @Test(expected = IllegalArgumentException.class)
  public void pagamento_value_above_500000() {
    var conta = new Conta(50000, LocalDate.of(2023, 02, 20));
    var pagamento = new Pagamento(500001, MetodosPagamento.BOLETO, LocalDate.of(2024, 10, 06), conta);
  }

  // 2. Análise de Classes de Equivalência

  @Test
  public void should_be_boleto_paga_after_vencimento() {
    var conta = new Conta(50000, LocalDate.of(2023, 02, 20));
    var pagamento = new Pagamento(1000, MetodosPagamento.BOLETO, LocalDate.of(2023, 02, 21), conta);

    var result = pagamento.isPaga();

    assertTrue("isPaga deveria restornar true", result);
  }

  @Test
  public void should_be_boleto_nao_paga_before_vencimento() {
    var conta = new Conta(50000, LocalDate.of(2023, 02, 20));
    var pagamento = new Pagamento(1000, MetodosPagamento.BOLETO, LocalDate.of(2023, 02, 19), conta);

    var result = pagamento.isPaga();

    assertTrue("isPaga deveria restornar false", !result);
  }

  @Test
  public void should_be_cartao_nao_paga_before_vencimento() {
    var conta = new Conta(50000, LocalDate.of(2023, 02, 20));
    var pagamento = new Pagamento(1000, MetodosPagamento.CARTAO_CREDITO, LocalDate.of(2023, 02, 19), conta);

    var result = pagamento.isPaga();

    assertTrue("isPaga deveria restornar false", !result);
  }

  @Test
  public void should_be_cartao_nao_paga_after_vencimento() {
    var conta = new Conta(50000, LocalDate.of(2023, 02, 20));
    var pagamento = new Pagamento(1000, MetodosPagamento.CARTAO_CREDITO, LocalDate.of(2023, 02, 21), conta);

    var result = pagamento.isPaga();

    assertTrue("isPaga deveria restornar false", !result);
  }

  @Test
  public void should_be_cartao_paga_after_15_days() {
    var conta = new Conta(50000, LocalDate.of(2023, 02, 20));
    var pagamento = new Pagamento(1000, MetodosPagamento.CARTAO_CREDITO, LocalDate.of(2023, 03, 07), conta);

    var result = pagamento.isPaga();

    assertTrue("isPaga deveria restornar true", result);
  }

  @Test
  public void should_be_cartao_nao_paga_before_15_days() {
    var conta = new Conta(50000, LocalDate.of(2023, 02, 20));
    var pagamento = new Pagamento(1000, MetodosPagamento.CARTAO_CREDITO, LocalDate.of(2023, 03, 06), conta);

    var result = pagamento.isPaga();

    assertTrue("isPaga deveria restornar false", !result);
  }

  @Test
  public void should_be_cartao_paga_on_15_days() {
    var conta = new Conta(50000, LocalDate.of(2023, 02, 20));
    var pagamento = new Pagamento(1000, MetodosPagamento.CARTAO_CREDITO, LocalDate.of(2023, 03, 06), conta);

    var result = pagamento.isPaga();

    assertTrue("isPaga deveria restornar true", result);
  }

}
