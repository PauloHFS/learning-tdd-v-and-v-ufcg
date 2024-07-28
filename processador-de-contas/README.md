# Processador de Contas

## Especificação

Deve-se implementar um processador de contas. O objetivo desse processador é verificar todas as contas e, caso o valor da soma de todas as contas seja maior ou igual ao valor da fatura, então essa fatura deverá ser considerada como paga, caso contrário será pendente.

Uma fatura contém data, valor total e nome do cliente. Uma conta contém o código da conta, data, e valor pago.

O processador de contas, ao receber uma lista de contas, deve então, para cada conta, criar um "pagamento" associado a essa fatura. Esse pagamento contém o valor pago, a data, e o tipo do pagamento efetuado. Há três tipos de pagamento: boleto ("BOLETO"), cartão de crédito ("CARTAO_CREDITO") e transferência bancária ("TRANSFERENCIA_BANCARIA"). Pagamentos por boleto não podem ter valor inferior a R$ 0,01 nem superior a R$ 5.000,00. Além disso, se a data de pagamento de um boleto for posterior à data da conta respectiva, então o boleto foi pago com atraso e deve ser acrescido 10% no valor do pagamento.

Como dito anteriormente, caso a soma de todos os pagamentos seja igual ou ultrapasse o valor da fatura, a mesma deve ser marcada como "PAGA", caso contrário será marcada como “PENDENTE”. Pagamentos do tipo cartão de crédito só podem ser incluídos na soma caso a data da conta seja de pelo menos 15 dias anteriores à data da fatura. Os outros tipos devem ser incluídos desde que a data da conta seja igual ou anterior à data da fatura. Em ambos os casos considerar apenas data, mês e ano.

Exemplo 1: Fatura de 1.500,00 (20/02/2023) com 3 contas no valor de 500,00, 400,00 e 600,00. As três contas foram pagas por boleto no dia 20/02/2023 (todas em dia), assim a fatura é marcada como PAGA.

Exemplo 2: Fatura de 1.500,00 (20/02/2023) com uma conta no valor 700,00 e outra conta de 800,00. A primeira conta foi paga por cartão de crédito (05/02/2023), enquanto que a segunda conta foi paga por transferência (17/02/2023). Assim, a fatura é marcada como PAGA.

Exemplo 3: Fatura de 1.500,00 (20/02/2023) com uma conta no valor 700,00 e outra conta de 800,00. A primeira conta foi paga por cartão de crédito (06/02/2023), enquanto que a segunda conta foi paga por transferência (17/02/2023). Assim, a fatura é marcada como PENDENTE.

