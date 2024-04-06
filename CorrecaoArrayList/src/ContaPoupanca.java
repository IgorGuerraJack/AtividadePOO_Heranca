public class ContaPoupanca extends Conta{
    public ContaPoupanca(PessoaFisica titular, String agencia, String numero, String banco, double saldo) {
        super(titular, agencia, numero, banco, saldo);
    }
    public boolean depositar(double valor){
        if(valor > 0){
            saldo = saldo + valor;
            return true;
        }
        return false;
    }

    public boolean sacar(double valor){
        if(valor > 0 && valor <= saldo){
            saldo = saldo - valor;
            return true;
        }
        return false;
    }

    public boolean transferir(double valor, Conta contaDestino){
        if(sacar(valor)){
            contaDestino.depositar(valor);
            return true;
        }
        return false;
    }
    public void rendimento(){
    saldo = saldo * 1.005;
    }
}
