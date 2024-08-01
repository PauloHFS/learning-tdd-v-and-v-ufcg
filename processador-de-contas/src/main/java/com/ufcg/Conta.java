package com.ufcg;

import java.time.LocalDate;
import java.util.UUID;

public class Conta {

  private UUID id;
  private LocalDate dataVencimento;
  private Integer valor;

  public Conta(Integer valor, LocalDate dataVencimento) {
    this.id = UUID.randomUUID();
    this.dataVencimento = dataVencimento;
    this.valor = valor;
  }

  public UUID getId() {
    return id;
  }

  public LocalDate getDataVencimento() {
    return this.dataVencimento;
  }

  public Integer getValor() {
    return this.valor;
  }
}
