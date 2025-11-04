package conta;

public abstract class ContaBancaria {
    private String senha;

    public ContaBancaria(String senha) {
        this.senha = senha;
    }
    public void alterarSenha(String senha, String novaSenha) {
        if (this.senha == senha) {
            this.senha = novaSenha;
            System.out.println("Senha alterada com sucesso!");
        } else {
            System.out.println("Senha incorreta, não foi possível alterar!");
        }
    }
    public abstract void saca(double valor);

    public abstract void deposita(double valor);

    public abstract void tiraExtrato();

    public abstract String getNumero();
}
