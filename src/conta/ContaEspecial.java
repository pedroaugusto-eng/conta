package conta;

public class ContaEspecial extends ContaBancaria{
    private String numero;
    private double saldo;
    private int qtdDeTransacoes;
    private double limite;

    public ContaEspecial(String senha, String numero, double saldo, double limite) {
        super(senha);
        this.numero = numero;
        this.saldo = saldo;
        this.qtdDeTransacoes = 0;
        this.limite = limite;
    }

    public void saca(double valor) {
        if (valor <= 0) {
            System.out.println("O valor do saque deve ser positivo.");
            return;
        }

        double saldoDisponivelTotal = this.saldo + this.limite;

        if (saldoDisponivelTotal >= valor) {
            this.saldo -= valor;
            this.qtdDeTransacoes++;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso (Conta Especial).");
        } else {
            System.out.println("Limite insuficiente para este saque.");
        }
    }

    public void deposita(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            this.qtdDeTransacoes++;
            System.out.println("Depósito de R$ " + valor + " realizado com sucesso.");
        } else {
            System.out.println("O valor do depósito deve ser positivo.");
        }
    }

    public void tiraExtrato() {
        double totalDisponivel = this.saldo + this.limite;

        System.out.println("--- Extrato Conta Especial ---");
        System.out.println("Número da Conta: " + this.getNumero());
        System.out.println("Saldo atual: R$ " + this.saldo);
        System.out.println("Limite de Cheque Especial: R$ " + this.limite);
        System.out.println("Total disponível para saque: R$ " + totalDisponivel);
        System.out.println("Transações realizadas: " + this.qtdDeTransacoes);
        System.out.println("-----------------------------------");
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getQtdDeTransacoes() {
        return this.qtdDeTransacoes;
    }

    public double getLimite() {
        return this.limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
}


