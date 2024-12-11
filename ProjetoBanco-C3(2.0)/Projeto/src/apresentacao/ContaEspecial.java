package apresentacao;

public abstract class ContaEspecial extends Conta {

    protected double limite;

    public void setLimite(double value) {
        limite = value;
    }

    public double getLimite() {
        return limite;
    }

    @Override
    public void creditar(double valor) {
        saldo = saldo + valor;
    }
}
