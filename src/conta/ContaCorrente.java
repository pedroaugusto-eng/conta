package conta;

public class ContaCorrente extends ContaBancaria {
    private String numero;
    private double saldo;
    private int qtdDeTransacoes;

    public ContaCorrente(String senha, String numero, double saldo) {
        super(senha);
        this.numero = numero;
        this.saldo = saldo;
        this.qtdDeTransacoes = 0;
    }

    public void saca(double valor) {
        if (valor <= 0) {
            System.out.println("O valor do saque deve ser positivo.");
            return;
        }

        if (this.saldo >= valor) {
            this.saldo -= valor;
            this.qtdDeTransacoes++;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente para saque.");
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
        System.out.println("--- Extrato Conta Corrente ---");
        System.out.println("Número da Conta: " + this.getNumero());
        System.out.println("Saldo disponível: R$ " + this.saldo);
        System.out.println("Transações realizadas: " + this.qtdDeTransacoes);
        System.out.println("---------------------------------");
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

}
