public class ContaEspecial extends Conta{
    private double cheque;

    public ContaEspecial(PessoaFisica titular, String agencia, String numero, String banco, double saldo, double cheque) {
        super(titular, agencia, numero, banco, saldo);
        this.cheque = cheque;
    }
    public boolean depositar(double valor){
        if(valor > 0){
            saldo = saldo + valor;
            return true;
        }
        return false;
    }

    public boolean sacar(double valor) {
        if (valor > 0 && saldo + cheque >= valor) {
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
}
