package apresentacao;

import negocio.BancoNegocio;
import java.util.List;

public class Banco {

    private BancoNegocio bancoNegocio;

    public Banco() {
        bancoNegocio = new BancoNegocio();
    }

    public void criaConta(Conta c) {
        bancoNegocio.criaConta(c);
    }

    public void listaContas() {
        List<Conta> contas = bancoNegocio.listaContas();
        for (Conta c : contas) {
            System.out.printf("Conta: %s, Saldo: %.2f\n", c.getNumero(), c.getSaldo());
        }
    }

    public static void main(String[] args) {
        Banco banco = new Banco();

        Conta c1 = new ContaNormal();
        c1.setNumero("1654-3");
        c1.setSaldo(500);

        ContaDebEspecial c2 = new ContaDebEspecial();
        c2.setNumero("4067-6");
        c2.setSaldo(2500);
        c2.setLimite(1000.67);

        banco.criaConta(c1);
        banco.criaConta(c2);

        banco.listaContas();
    }
}


