package com.ufcg.pagamento;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import com.ufcg.Conta;
import com.ufcg.MetodosPagamento;

public class Pagamento {

  private Integer valor;
  private MetodosPagamento metodo;
  private LocalDate pagoEm;
  private Conta conta;

  public Pagamento(Integer valor, MetodosPagamento metodo, LocalDate pagoEm, Conta conta) {
    var valorFinal = valor;
    if (metodo.equals(MetodosPagamento.BOLETO)) {
      if (valor < 1 || valor > 500000) {
        throw new IllegalArgumentException(
            "Valor inválido para boleto, o valor tem que ser entre 1 (R$ 0,01) e 500000 (R$ 5000,00)");
      }

      if (pagoEm.isAfter(conta.getDataVencimento())) {
        valorFinal = valor * 110 / 100;
      }
    }

    this.metodo = metodo;
    this.pagoEm = pagoEm;
    this.valor = valorFinal;
    this.conta = conta;
  }

  public MetodosPagamento getMetodo() {
    return metodo;
  }

  public Integer getValor() {
    return valor;
  }

  public LocalDate getPagoEm() {
    return pagoEm;
  }

  public Conta getConta() {
    return conta;
  }

  public boolean isPaga() {
    if (this.metodo.equals(MetodosPagamento.CARTAO_CREDITO)) {
      long diasDiferenca = Math.abs(ChronoUnit.DAYS.between(this.conta.getDataVencimento(), this.pagoEm));
      if (diasDiferenca < 15) {
        return false;
      }
    }

    if (this.pagoEm.isBefore(this.conta.getDataVencimento()) || this.pagoEm.isEqual(this.conta.getDataVencimento())) {
      return true;
    }

    return false;
  }

}
