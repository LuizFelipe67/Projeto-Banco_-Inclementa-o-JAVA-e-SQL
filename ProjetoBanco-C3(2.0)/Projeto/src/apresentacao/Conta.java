package apresentacao;

public abstract class Conta implements Comparable<Conta> {

    protected String numero;
    protected double saldo;

    // Tornar os métodos públicos para acessibilidade externa
    public String getNumero() {
        return numero;
    }

    public void setNumero(String value) {
        numero = value;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double value) {
        saldo = value;
    }

    abstract void creditar(double valor);
    abstract void debitar(double valor);
}
