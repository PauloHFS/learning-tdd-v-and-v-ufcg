package com.ufcg;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;

import com.ufcg.pagamento.Pagamento;

public class Fatura {

  private String name;
  private LocalDate date;
  private Map<Conta, Optional<Pagamento>> contaPagamentoMap;

  public Fatura(String name, LocalDate date, Map<Conta, Optional<Pagamento>> contaPagamentoMap) {
    this.name = name;
    this.date = date;
    this.contaPagamentoMap = contaPagamentoMap;
  }

  public String getNomeCliente() {
    return this.name;
  }

  public LocalDate getData() {
    return this.date;
  }

  public boolean isPaga() {
    if (!this.contaPagamentoMap.values().stream().allMatch(Optional::isPresent)) {
      return false;
    }

    return this.contaPagamentoMap.values().stream().map(Optional::get).filter(Pagamento::isPaga)
        .count() == this.contaPagamentoMap.size();
  }
}
