
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Conta> contas = new ArrayList<Conta>();

        while(true) {
            System.out.println("===== MENU =====");
            System.out.println("1 - Criar Conta");
            System.out.println("2 - Saque");
            System.out.println("3 - Deposito");
            System.out.println("4 - Transferência");
            System.out.println("5 - Extrato");
            System.out.println("0 - Sair");
            int opcao = scan.nextInt();
            scan.nextLine();

            if (opcao == 0) break;
            else if (opcao == 1) {//Criar a conta.
                //Buscar pessoa (titular)
                System.out.println("Digite o nome do titular: ");
                String nome = scan.nextLine();
                System.out.println("Digite o cpf do titular: ");
                String cpf = scan.nextLine();

                //Criar objeto Pessoa = Titular
                PessoaFisica titular = new PessoaFisica(nome, cpf);

                //Buscar informações conta
                System.out.println("Digite o nome do banco: ");
                String nomeBanco = scan.nextLine();
                System.out.println("Digite o número da conta: ");
                String nroConta = scan.nextLine();

                //Criar objeto Conta
                Conta conta = new Conta(nroConta, nomeBanco, titular);

                //Adicionar ArrayList contas
                contas.add(conta);

            } else if (opcao == 2) {
                //Buscar a conta no ArrayList
                Conta conta = buscarConta(contas);
                if (conta == null) {
                    System.out.println("Conta não encontrada!");
                    continue;
                }

                System.out.println("Digite o valor a ser sacado: ");
                double valor = scan.nextDouble();

                if (conta.sacar(valor)) {
                    System.out.println("Saque realizado com sucesso");
                } else {
                    System.out.println("Erro ao realizar o saque");
                }
            } else if (opcao == 3) {

                Conta conta = buscarConta(contas);
                if (conta == null) {
                    System.out.println("Conta não encontrada!");
                    continue;
                }

                System.out.println("Digite o valor a ser depositado: ");
                double valor = scan.nextDouble();

                if (conta.depositar(valor)) {
                    System.out.println("Deposito realizado com sucesso");
                } else {
                    System.out.println("Erro ao realizar o deposito");
                }
            } else if (opcao == 4) {
                //Buscar a conta de origem
                Conta contaOrigem = buscarConta(contas);
                //Buscar a conta de destino
                Conta contaDestino = buscarConta(contas);
                //Solicitar valor de transferencia
                System.out.println("Digite o valor da transferência: ");
                double valor = scan.nextDouble();

                //Notificar usuário
                if (contaOrigem.transferir(valor, contaDestino)) {
                    System.out.println("Transferencia realizada com sucesso!");
                } else {
                    System.out.println("Erro ao realizar transferência");
                }


            } else if (opcao == 5) {
                Conta conta = buscarConta(contas);
                if (conta == null) {
                    System.out.println("Conta não encontrada...");
                }

                System.out.println("====== Extrato =====");
                System.out.println("Nome do titular: " + conta.getTitular().getNome());
                System.out.println("Número da conta: " + conta.getNumero());
                System.out.println("Nome do Banco: " + conta.getBanco());
                System.out.println("Saldo: R$" + conta.getSaldo());
                System.out.println("=====================");
            }
        }
    }

    public static Conta buscarConta(ArrayList<Conta> contas){
        Scanner scan = new Scanner(System.in);

        //Solicitar a conta para realização do saque
        System.out.println("Digite o número da conta: ");
        String nroConta = scan.next();

        //Buscar a conta no ArrayList
        for(Conta conta : contas) {
            if (conta.getNumero().equals(nroConta)) {
                return conta;
            }
        }
        return null;
    }
}