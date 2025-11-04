package conta;

import java.util.Scanner;

public class AppConta {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quantas contas deseja criar?");
        int numeroContasCriadas = scanner.nextInt();
        ContaBancaria[] contas = new ContaBancaria[numeroContasCriadas];

        for (int i = 0; i < numeroContasCriadas; i++) {
            System.out.println("\n--- Criando Conta " + (i + 1) + " ---");
            int tipoConta = 0;

            do {
                System.out.print("Tipo da conta (1-Corrente, 2-Especial): ");
                tipoConta = scanner.nextInt();
                scanner.nextLine();
            } while (tipoConta != 1 && tipoConta != 2);

            System.out.print("Digite a senha: ");
            String senha = scanner.nextLine();
            System.out.print("Digite o número da conta: ");
            String numero = scanner.nextLine();
            System.out.print("Digite o saldo inicial: R$ ");
            double saldo = scanner.nextDouble();
            scanner.nextLine();

            if (tipoConta == 1) {
                contas[i] = new ContaCorrente(senha, numero, saldo);
            } else {
                System.out.print("Digite o limite do cheque especial: R$ ");
                double limite = scanner.nextDouble();
                scanner.nextLine();
                contas[i] = new ContaEspecial(senha, numero, saldo, limite);
            }
            System.out.println("Conta " + numero + " criada com sucesso!");
        }

        System.out.println("\n*** Contas cadastradas com sucesso. ***");

        int opcode = -1;
        while (opcode != 0) {
            System.out.print("Digite o número da conta que deseja acessar: ");
            String num = scanner.nextLine();
            int x = 0;
            boolean controle = false;
            for (int i = 0; i < numeroContasCriadas; i++) {
                if (contas[i].getNumero().equals(num)) {
                    x = i;
                    controle = true;
                }
            }

            if (!controle) {
                System.out.println("Número de conta inválido!");
            } else {

                System.out.println("\n====== MENU DO BANCO ======");
                System.out.println("1. Depositar");
                System.out.println("2. Sacar");
                System.out.println("3. Tirar Extrato (de uma conta)");
                System.out.println("4. Alterar Senha");
                System.out.println("5. Ver Extrato de TODAS as contas");
                System.out.println("0. Sair");
                System.out.print("Escolha uma opção: ");
                opcode = scanner.nextInt();
                scanner.nextLine();

                switch (opcode) {
                    case 1:
                        System.out.println("-- Depósito --");
                        System.out.println("Digite o valor do deposito: ");
                        double dep = scanner.nextDouble();
                        contas[x].deposita(dep);
                        break;
                    case 2:
                        System.out.println("-- Saque --");
                        System.out.println("Digite o valor do saque: ");
                        double saq = scanner.nextDouble();
                        contas[x].saca(saq);
                        break;
                    case 3:
                        contas[x].tiraExtrato();
                        break;
                    case 4:
                        System.out.println("-- Alterar senha --");
                        System.out.println("Digite a senha atual: ");
                        String atual = scanner.nextLine();
                        System.out.print("Digite a NOVA senha: ");
                        String nova = scanner.nextLine();
                        contas[x].alterarSenha(atual, nova);
                        break;
                    case 5:
                        System.out.println("\n--- EXTRATO GERAL DE TODAS AS CONTAS ---");
                        for (int i = 0; i <= contas.length; i++) {
                            contas[i].tiraExtrato();
                        }
                        break;
                    case 0:
                        System.out.println("Encerrando o sistema. Obrigado!");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        scanner.nextLine();
                }

            }
        }
    }
}

