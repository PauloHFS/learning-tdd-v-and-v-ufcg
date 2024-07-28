package com.ufcg;

import java.time.LocalDate;
import java.util.List;

public class Fatura {

  private String name;
  private LocalDate date;
  private List<Conta> contas;
  private FaturaStatus status;

  public Fatura() {
    super();
  }

  public Fatura(String name, LocalDate date, List<Conta> contas) {
    super();
    this.name = name;
    this.date = date;
    this.contas = contas;

    // TODO: Implementar a lógica para definir o status da fatura
    this.status = FaturaStatus.PAGA;
  }

  public Integer getValor() {
    return this.contas.stream().mapToInt(Conta::getValor).sum();
  }

  public String getNomeCliente() {
    return this.name;
  }

  public LocalDate getData() {
    return this.date;
  }

  public Boolean isPaga() {
    return this.status == FaturaStatus.PAGA;
  }

  public Object isPendente() {
    return this.status == FaturaStatus.PENDENTE;
  }

}
